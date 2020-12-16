package com.gtw.business.service.query.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.gtw.business.infrastructure.db.CarrierMovementDO;
import com.gtw.business.infrastructure.db.LocationDO;
import com.gtw.business.infrastructure.db.mapper.CarrierMovementMapper;
import com.gtw.business.infrastructure.db.mapper.LocationMapper;
import com.gtw.business.service.query.RoutingQueryService;
import com.gtw.business.service.query.assembler.CarrierMovementDTOAssembler;
import com.gtw.business.service.query.dto.CarrierMovementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoutingQueryServiceImpl implements RoutingQueryService {

    @Autowired
    private CarrierMovementMapper carrierMovementMapper;
    @Autowired
    private LocationMapper locationMapper;
    @Autowired
    private CarrierMovementDTOAssembler converter;

    @Override
    public List<CarrierMovementDTO> queryCarriers() {
        List<CarrierMovementDO> carrierMovementDOs = carrierMovementMapper.selectAll();
        return carrierMovementDOs.stream().map(converter::apply).collect(Collectors.toList());
    }

    @Override
    public List<LocationDO> queryLocations() {
        return locationMapper.selectAll();
    }

}
