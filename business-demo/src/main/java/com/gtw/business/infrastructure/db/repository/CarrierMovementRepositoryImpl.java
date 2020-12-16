package com.gtw.business.infrastructure.db.repository;

import com.gtw.business.domain.aggregate.carriermovement.CarrierMovement;
import com.gtw.business.domain.aggregate.carriermovement.CarrierMovementRepository;
import com.gtw.business.infrastructure.db.CarrierMovementDO;
import com.gtw.business.infrastructure.db.converter.CarrierMovementConverter;
import com.gtw.business.infrastructure.db.mapper.CarrierMovementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarrierMovementRepositoryImpl implements CarrierMovementRepository {

    @Autowired
    private CarrierMovementMapper mapper;

    @Override
    public CarrierMovement find(String id) {
        CarrierMovementDO carrierMovementDO = mapper.select(id);
        return CarrierMovementConverter.deserialize(carrierMovementDO);
    }

}
