package com.gtw.business.service.query.assembler;

import java.text.SimpleDateFormat;
import java.util.function.Function;

import com.gtw.business.infrastructure.db.CarrierMovementDO;
import com.gtw.business.infrastructure.db.mapper.LocationMapper;
import com.gtw.business.service.query.dto.CarrierMovementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarrierMovementDTOAssembler
        implements Function<CarrierMovementDO, CarrierMovementDTO> {

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public CarrierMovementDTO apply(CarrierMovementDO t) {
        CarrierMovementDTO dto = new CarrierMovementDTO();
        dto.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(t.getStartTime()));
        dto.setArriveTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(t.getStartTime()));
        dto.setFromLocationId(t.getFromLocationId());
        dto.setToLocationId(t.getToLocationId());
        dto.setScheduleId(t.getScheduleId());
        dto.setFromLocationName(locationMapper.select(t.getFromLocationId()).getName());
        dto.setToLocationName(locationMapper.select(t.getToLocationId()).getName());
        return dto;
    }

}
