package com.gtw.business.domain.aggregate.shop.value;

import com.gtw.business.common.utils.UuidGenerator;
import org.springframework.stereotype.Component;

@Component
public class OrderIdGenerator {

    public String generate() {
        return UuidGenerator.newUuid();
    }
}
