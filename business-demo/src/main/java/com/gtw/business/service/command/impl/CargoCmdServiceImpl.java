package com.gtw.business.service.command.impl;

import java.util.List;

import com.gtw.business.domain.aggregate.cargo.Cargo;
import com.gtw.business.domain.aggregate.cargo.CargoRepository;
import com.gtw.business.domain.aggregate.cargo.valueobject.DeliverySpecification;
import com.gtw.business.domain.aggregate.cargo.valueobject.EnterpriseSegment;
import com.gtw.business.domain.aggregate.handlingevent.HandlingEvent;
import com.gtw.business.domain.aggregate.handlingevent.HandlingEventRepository;
import com.gtw.business.domain.aggregate.cargo.CargoBookEvent;
import com.gtw.business.infrastructure.event.publisher.CargoBookEventPublisher;
import com.gtw.business.domain.service.CargoDomainService;
import com.gtw.business.infrastructure.rpc.cargo.SalersService;
import com.gtw.business.service.command.CargoCmdService;
import com.gtw.business.service.command.cmd.CargoBookCommand;
import com.gtw.business.service.command.cmd.CargoDeleteCommand;
import com.gtw.business.service.command.cmd.CargoDeliveryUpdateCommand;
import com.gtw.business.service.command.cmd.CargoSenderUpdateCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class CargoCmdServiceImpl implements CargoCmdService {

    @Autowired
    private CargoRepository cargoRepository;
    @Autowired
    private HandlingEventRepository handlingEventRepository;
    @Autowired
    private CargoDomainService cargoDomainService;
    @Autowired
    private SalersService salersService;
    @Autowired
    CargoBookEventPublisher cargoBookEventPublisher;

    @Override
    public void bookCargo(CargoBookCommand cargoBookCommand) {
        // 参数校验

        // 协调领域模型
        DeliverySpecification delivery = new DeliverySpecification(
                cargoBookCommand.getOriginLocationCode(),
                cargoBookCommand.getDestinationLocationCode());

        Cargo cargo = Cargo.newCargo(CargoDomainService.nextCargoId(), cargoBookCommand.getSenderPhone(),
                cargoBookCommand.getDescription(), delivery);

        // 流程编排
        int size = cargoRepository.sizeByCustomer(cargoBookCommand.getSenderPhone());
        EnterpriseSegment enterpriseSegment = salersService.deriveEnterpriseSegment(cargo);
        int sizeCargo = cargoRepository.sizeByEnterpriseSegment(enterpriseSegment);
        
        if (!cargoDomainService.mayAccept(size, sizeCargo,
                cargo)) { throw new IllegalArgumentException(
                        cargoBookCommand.getSenderPhone() + " cannot book cargo, exceed the limit: "
                                + CargoDomainService.MAX_CARGO_LIMIT); }

        // 持久化
        cargoRepository.save(cargo);
        
        // 发布领域事件
        cargoBookEventPublisher.publish(new CargoBookEvent(cargo));
    }

    @Override
    public void updateCargoDelivery(CargoDeliveryUpdateCommand cmd) {
        // validate

        // find
        Cargo cargo = cargoRepository.find(cmd.getCargoId());

        // domain logic
        cargo.changeDelivery(cmd.getDestinationLocationCode());

        // save
        cargoRepository.save(cargo);
    }

    @Override
    public void updateCargoSender(CargoSenderUpdateCommand cmd) {
        // find
        Cargo cargo = cargoRepository.find(cmd.getCargoId());
        List<HandlingEvent> events = handlingEventRepository.findByCargo(cmd.getCargoId());

        // domain service
        cargoDomainService.updateCargoSender(cargo, cmd.getSenderPhone(), CollectionUtils.isEmpty(events) ? null : events.get(0));

        // save
        cargoRepository.save(cargo);
    }

    @Override
    public void deleteCargo(CargoDeleteCommand cmd) {
        cargoRepository.remove(cmd.getCargoId());
    }

}
