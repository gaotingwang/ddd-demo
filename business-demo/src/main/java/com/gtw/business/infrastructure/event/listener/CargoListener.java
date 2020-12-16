package com.gtw.business.infrastructure.event.listener;

import com.gtw.business.domain.aggregate.cargo.Cargo;
import com.gtw.business.domain.aggregate.cargo.CargoBookEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class CargoListener {

    @EventListener
    @Order(1)
    public void processIndexEvent(final CargoBookEvent event) {
        execute();
        System.out.println("货物预定成功：" + ((Cargo)event.getSource()));
    }

    private void execute() {
        System.out.println("CargoListener: 调用CargoListener进行索引");
    }
}
