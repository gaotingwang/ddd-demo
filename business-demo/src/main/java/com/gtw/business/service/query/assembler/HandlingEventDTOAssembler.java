package com.gtw.business.service.query.assembler;

import java.text.SimpleDateFormat;
import java.util.function.Function;

import com.gtw.business.domain.aggregate.handlingevent.EventTypeEnum;
import com.gtw.business.infrastructure.db.CarrierMovementDO;
import com.gtw.business.infrastructure.db.HandlingEventDO;
import com.gtw.business.infrastructure.db.mapper.CarrierMovementMapper;
import com.gtw.business.service.query.dto.CarrierMovementDTO;
import com.gtw.business.service.query.dto.HandlingEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class HandlingEventDTOAssembler implements Function<HandlingEventDO, HandlingEventDTO> {

    @Autowired
    private CarrierMovementMapper carrierMovementMapper;
    @Autowired
    private CarrierMovementDTOAssembler converter;

    public HandlingEventDTO apply(HandlingEventDO t) {
        HandlingEventDTO target = new HandlingEventDTO();
        target.setEventType(EventTypeEnum.of(t.getEventType()).toString());
        target.setDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(t.getDatetime()));

        if (!StringUtils.isEmpty(t.getScheduleId())) {
            CarrierMovementDO carrierMovementDO = carrierMovementMapper.select(t.getScheduleId());
            CarrierMovementDTO carrierMovement = converter.apply(carrierMovementDO);
            target.setCarrierMovement(carrierMovement);
        }
        return target;
    }

}
