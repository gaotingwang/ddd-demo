package com.gtw.business.service.query.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.gtw.business.infrastructure.db.CargoDO;
import com.gtw.business.infrastructure.db.mapper.CargoMapper;
import com.gtw.business.service.query.CargoQueryService;
import com.gtw.business.service.query.assembler.CargoDTOAssembler;
import com.gtw.business.service.query.dto.CargoDTO;
import com.gtw.business.service.query.qry.CargoFindbyCustomerQry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoQueryServiceImpl implements CargoQueryService {

    @Autowired
    private CargoMapper cargoMapper;
    
    @Autowired
    private CargoDTOAssembler converter;

    @Override
    public List<CargoDTO> queryCargos() {
        List<CargoDO> cargos = cargoMapper.selectAll();
        return cargos.stream().map(converter::apply).collect(Collectors.toList());
    }

    @Override
    public List<CargoDTO> queryCargos(CargoFindbyCustomerQry qry) {
        List<CargoDO> cargos = cargoMapper.selectByCustomer(qry.getCustomerPhone());
        return cargos.stream().map(converter::apply).collect(Collectors.toList());
    }

    @Override
    public CargoDTO getCargo(String cargoId) {
        CargoDO select = cargoMapper.select(cargoId);
        return converter.apply(select);
    }

}
