package com.gtw.business.service.command;

import com.gtw.business.service.command.cmd.CargoBookCommand;
import com.gtw.business.service.command.cmd.CargoDeleteCommand;
import com.gtw.business.service.command.cmd.CargoDeliveryUpdateCommand;
import com.gtw.business.service.command.cmd.CargoSenderUpdateCommand;

public interface CargoCmdService {
    
    void bookCargo(CargoBookCommand cargoBookCommand);

    void updateCargoDelivery(CargoDeliveryUpdateCommand cmd);

    void deleteCargo(CargoDeleteCommand cmd);

    void updateCargoSender(CargoSenderUpdateCommand cmd);

}
