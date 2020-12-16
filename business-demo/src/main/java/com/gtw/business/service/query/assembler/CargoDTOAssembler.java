package com.gtw.business.service.query.assembler;

import java.util.function.Function;

import com.gtw.business.infrastructure.db.CargoDO;
import com.gtw.business.infrastructure.db.LocationDO;
import com.gtw.business.infrastructure.db.mapper.LocationMapper;
import com.gtw.business.service.query.dto.CargoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CargoDTOAssembler implements Function<CargoDO, CargoDTO> {

    @Autowired
    private LocationMapper locationMapper;

    public CargoDTO apply(CargoDO t) {
        CargoDTO target = new CargoDTO();
        BeanUtils.copyProperties(t, target);
        LocationDO select = locationMapper.select(t.getOriginLocationCode());
        target.setOriginLocationName(select.getName());
        select = locationMapper.select(t.getDestinationLocationCode());
        target.setDestinationLocationName(select.getName());
        return target;
    }

}
