package com.gtw.business.domain.aggregate.cargo;

import org.springframework.context.ApplicationEvent;

public class CargoBookEvent extends ApplicationEvent {

    public CargoBookEvent(Cargo cargo) {
        super(cargo);
    }

}
