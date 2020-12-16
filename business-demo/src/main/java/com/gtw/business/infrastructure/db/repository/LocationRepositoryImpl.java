package com.gtw.business.infrastructure.db.repository;

import com.gtw.business.domain.aggregate.location.Location;
import com.gtw.business.domain.aggregate.location.LocationRepository;
import com.gtw.business.infrastructure.db.LocationDO;
import com.gtw.business.infrastructure.db.converter.LocationConverter;
import com.gtw.business.infrastructure.db.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationRepositoryImpl implements LocationRepository {
    
    @Autowired
    private LocationMapper mapper;

    @Override
    public Location find(String code) {
        LocationDO locationDO = mapper.select(code);
        return LocationConverter.deserialize(locationDO);
    }

}
