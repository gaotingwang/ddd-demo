package com.gtw.business.service.command.impl;

import com.gtw.business.domain.aggregate.handlingevent.EventTypeEnum;
import com.gtw.business.domain.aggregate.handlingevent.HandlingEvent;
import com.gtw.business.domain.aggregate.handlingevent.HandlingEventRepository;
import com.gtw.business.service.command.IncidentLoggingCmdService;
import com.gtw.business.service.command.cmd.HandlingEventAddCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidentLoggingCmdServiceImpl implements IncidentLoggingCmdService {

    @Autowired
    private HandlingEventRepository handlingEventRepository;

    @Override
    public void addHandlingEvent(HandlingEventAddCommand cmd) {
        // validate

        // create
        HandlingEvent handlingEvent = HandlingEvent.newHandlingEvent(cmd.getCargoId(),
                cmd.getDatetime(), EventTypeEnum.of(cmd.getEventType()), cmd.getScheduleId());

        // save
        handlingEventRepository.save(handlingEvent);

    }

}
