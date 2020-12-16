package com.gtw.business.service.query;

import java.util.List;

import com.gtw.business.infrastructure.db.LocationDO;
import com.gtw.business.service.query.dto.CarrierMovementDTO;

public interface RoutingQueryService {

    List<CarrierMovementDTO> queryCarriers();
    List<LocationDO> queryLocations();

}
