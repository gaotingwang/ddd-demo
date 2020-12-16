package com.gtw.business.infrastructure.db.mapper;

import java.util.List;

import com.gtw.business.infrastructure.db.CarrierMovementDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CarrierMovementMapper {

    CarrierMovementDO select(@Param("scheduleId") String scheduleId);

    List<CarrierMovementDO> selectAll();


}
