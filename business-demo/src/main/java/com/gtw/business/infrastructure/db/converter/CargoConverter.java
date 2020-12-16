package com.gtw.business.infrastructure.db.converter;

import com.gtw.business.domain.aggregate.cargo.Cargo;
import com.gtw.business.domain.aggregate.cargo.valueobject.DeliverySpecification;
import com.gtw.business.infrastructure.db.CargoDO;

public class CargoConverter {

    public static CargoDO serialize(Cargo cargo) {
        CargoDO target = new CargoDO();
        target.setId(cargo.id());
        target.setSenderPhone(cargo.sender());
        target.setDescription(cargo.description());
        DeliverySpecification delivery = cargo.delivery();
        target.setDestinationLocationCode(delivery.getDestinationLocationCode());
        target.setOriginLocationCode(delivery.getOriginLocationCode());
        return target;
    }

    public static Cargo deserialize(CargoDO cargo) {
        Cargo target = Cargo.newCargo(cargo.getId(), cargo.getSenderPhone(), cargo.getDescription(),
                new DeliverySpecification(cargo.getOriginLocationCode(),
                        cargo.getDestinationLocationCode()));
        return target;
    }

}
