package com.gtw.business.infrastructure.event.publisher;

import com.gtw.business.domain.aggregate.cargo.CargoBookEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CargoBookEventPublisher {
    @Autowired
    private ApplicationEventPublisher publisher;

    public void publish(CargoBookEvent event) {
        publisher.publishEvent(event);
    }

}
