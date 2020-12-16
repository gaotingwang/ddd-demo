package com.gtw.business.service.query;

import com.gtw.business.service.query.dto.CargoHandlingEventDTO;
import com.gtw.business.service.query.qry.EventFindbyCargoQry;

public interface TrackQueryService {
    
    CargoHandlingEventDTO queryHistory(EventFindbyCargoQry qry);


}
