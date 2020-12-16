package com.gtw.business.infrastructure.rpc.cargo;

import org.springframework.stereotype.Component;

@Component
public class RemoteServiceTranslator {

    public UserDO toUserDO(Object obj) {
        return new UserDO();
    }

}
