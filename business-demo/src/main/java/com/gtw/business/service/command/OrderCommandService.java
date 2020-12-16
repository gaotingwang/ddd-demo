package com.gtw.business.service.command;

import com.gtw.business.service.command.cmd.CreateOrderCommand;

public interface OrderCommandService {
    String createOrder(CreateOrderCommand command);
}
