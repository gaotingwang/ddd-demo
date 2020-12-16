package com.gtw.business.domain.aggregate.location;

public interface LocationRepository {
    Location find(String code);
}
