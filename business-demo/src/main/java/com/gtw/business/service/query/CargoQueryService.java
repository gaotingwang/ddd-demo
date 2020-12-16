package com.gtw.business.service.query;

import java.util.List;

import com.gtw.business.service.query.dto.CargoDTO;
import com.gtw.business.service.query.qry.CargoFindbyCustomerQry;

public interface CargoQueryService {

    CargoDTO getCargo(String cargoId);

    List<CargoDTO> queryCargos();

    List<CargoDTO> queryCargos(CargoFindbyCustomerQry qry);

}
