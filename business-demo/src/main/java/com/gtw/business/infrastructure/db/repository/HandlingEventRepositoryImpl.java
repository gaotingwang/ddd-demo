package com.gtw.business.infrastructure.db.repository;

import java.util.List;
import java.util.stream.Collectors;

import com.gtw.business.domain.aggregate.handlingevent.HandlingEvent;
import com.gtw.business.domain.aggregate.handlingevent.HandlingEventRepository;
import com.gtw.business.infrastructure.db.HandlingEventDO;
import com.gtw.business.infrastructure.db.converter.HandlingEventConverter;
import com.gtw.business.infrastructure.db.mapper.HandlingEventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HandlingEventRepositoryImpl implements HandlingEventRepository {

    @Autowired
    private HandlingEventMapper mapper;

    @Override
    public List<HandlingEvent> findByCargo(String cargoId) {
        List<HandlingEventDO> handlingEventDOs = mapper.selectByCargo(cargoId);

        return handlingEventDOs.stream().map(HandlingEventConverter::deserialize)
                .collect(Collectors.toList());
    }

    @Override
    public List<HandlingEvent> findByScheduleId(String scheduleId) {
        List<HandlingEventDO> handlingEventDOs = mapper.selectByScheduleId(scheduleId);

        return handlingEventDOs.stream().map(HandlingEventConverter::deserialize)
                .collect(Collectors.toList());
    }

    @Override
    public void save(HandlingEvent handlingEvent) {
        HandlingEventDO handlingEventDO = HandlingEventConverter.serialize(handlingEvent);
        mapper.save(handlingEventDO);
    }

}
