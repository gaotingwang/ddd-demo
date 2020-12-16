package com.gtw.business.infrastructure.db.mapper;

import java.util.List;

import com.gtw.business.infrastructure.db.CargoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CargoMapper {

    CargoDO select(@Param("id") String id);

    List<CargoDO> selectAll();

    List<CargoDO> selectByCustomer(@Param("phone") String phone);

    void save(CargoDO cargoDO);
    
    void update(CargoDO cargoDO);

    void remove(@Param("id") String id);

    int countByCustomer(@Param("phone") String phone);


}
