package com.gtw.business.infrastructure.db.mapper;

import java.util.List;

import com.gtw.business.infrastructure.db.LocationDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LocationMapper {

    LocationDO select(@Param("code") String code);

    List<LocationDO> selectAll();


}
