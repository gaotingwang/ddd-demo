package com.gtw.business.application.controller;

import java.util.List;

import com.gtw.business.service.command.CargoCmdService;
import com.gtw.business.service.command.cmd.CargoBookCommand;
import com.gtw.business.service.command.cmd.CargoDeleteCommand;
import com.gtw.business.service.command.cmd.CargoDeliveryUpdateCommand;
import com.gtw.business.service.command.cmd.CargoSenderUpdateCommand;
import com.gtw.business.service.query.CargoQueryService;
import com.gtw.business.service.query.dto.CargoDTO;
import com.gtw.business.service.query.qry.CargoFindbyCustomerQry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    CargoQueryService cargoQueryService;
    @Autowired
    CargoCmdService cargoCmdService;

    /**
     * 货物预定
     * @param cargoBookCommand 预定Command
     */
    @RequestMapping(method = RequestMethod.POST)
    public void book(@RequestBody CargoBookCommand cargoBookCommand) {
        cargoCmdService.bookCargo(cargoBookCommand);
    }

    @RequestMapping(value = "/{cargoId}/delivery", method = RequestMethod.PUT)
    public void modifyDestinationLocationCode(@PathVariable String cargoId,
            @RequestBody CargoDeliveryUpdateCommand cmd) {
        cmd.setCargoId(cargoId);
        cargoCmdService.updateCargoDelivery(cmd);
    }
    @RequestMapping(value = "/{cargoId}/sender", method = RequestMethod.PUT)
    public void modifySender(@PathVariable String cargoId,
            @RequestBody CargoSenderUpdateCommand cmd) {
        cmd.setCargoId(cargoId);
        cargoCmdService.updateCargoSender(cmd);
    }

    @RequestMapping(value = "/{cargoId}", method = RequestMethod.DELETE)
    public void removeCargo(@PathVariable String cargoId) {
        CargoDeleteCommand cmd = new CargoDeleteCommand();
        cmd.setCargoId(cargoId);
        cargoCmdService.deleteCargo(cmd);
    }

    @RequestMapping(value = "/{cargoId}", method = RequestMethod.GET)
    public CargoDTO cargo(@PathVariable String cargoId) {
        return cargoQueryService.getCargo(cargoId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CargoDTO> queryCargos(
        @RequestParam(value = "phone", required = false) String phone) {
        if (!StringUtils.isEmpty(phone)) {
            CargoFindbyCustomerQry qry = new CargoFindbyCustomerQry();
            qry.setCustomerPhone(phone);
            return cargoQueryService.queryCargos(qry);
        }
        return cargoQueryService.queryCargos();
    }
}
