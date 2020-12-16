package com.gtw.business.infrastructure.db.mapper;

import java.util.List;

import com.gtw.business.infrastructure.db.HandlingEventDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HandlingEventMapper {

    List<HandlingEventDO> selectByCargo(@Param("cargoId") String cargoId);

    List<HandlingEventDO> selectByScheduleId(@Param("scheduleId") String scheduleId);

    void save(HandlingEventDO handlingEventDO);

}
