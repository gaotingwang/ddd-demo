package com.gtw.business.service.query;

import com.gtw.business.service.query.dto.OrderDTO;

/**
 * CQRS
 */
public interface OrderQueryService {


    /**
     * 这里为了说明CQRS对查询的使用
     * @param id
     * @return
     */
    OrderDTO byId(String id);

}
