package com.gtw.business.service.query.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.gtw.business.infrastructure.db.CargoDO;
import com.gtw.business.infrastructure.db.HandlingEventDO;
import com.gtw.business.infrastructure.db.mapper.CargoMapper;
import com.gtw.business.infrastructure.db.mapper.HandlingEventMapper;
import com.gtw.business.service.query.TrackQueryService;
import com.gtw.business.service.query.assembler.CargoDTOAssembler;
import com.gtw.business.service.query.assembler.HandlingEventDTOAssembler;
import com.gtw.business.service.query.dto.CargoDTO;
import com.gtw.business.service.query.dto.CargoHandlingEventDTO;
import com.gtw.business.service.query.dto.HandlingEventDTO;
import com.gtw.business.service.query.qry.EventFindbyCargoQry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackQueryServiceImpl implements TrackQueryService {

    @Autowired
    private HandlingEventMapper handlingEventMapper;

    @Autowired
    private CargoMapper cargoMapper;

    @Autowired
    private CargoDTOAssembler converter;
    @Autowired
    private HandlingEventDTOAssembler handlingEventDTOAssembler;

    @Override
    public CargoHandlingEventDTO queryHistory(EventFindbyCargoQry qry) {

        CargoDO cargo = cargoMapper.select(qry.getCargoId());
        List<HandlingEventDO> events = handlingEventMapper.selectByCargo(qry.getCargoId());

        // convertor
        CargoDTO cargoDTO = converter.apply(cargo);
        List<HandlingEventDTO> dtoEvents = events.stream().map(handlingEventDTOAssembler::apply)
                .collect(Collectors.toList());

        CargoHandlingEventDTO cargoHandlingEventDTO = new CargoHandlingEventDTO();
        cargoHandlingEventDTO.setCargo(cargoDTO);
        cargoHandlingEventDTO.setEvents(dtoEvents);

        return cargoHandlingEventDTO;
    }

}
