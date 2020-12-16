package com.gtw.business.application.controller;

import java.util.List;

import com.gtw.business.infrastructure.db.LocationDO;
import com.gtw.business.service.query.RoutingQueryService;
import com.gtw.business.service.query.dto.CarrierMovementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routing")
public class RoutingController {

    @Autowired
    private RoutingQueryService routingQueryService;

    @RequestMapping(value = "/carrier", method = RequestMethod.GET)
    public List<CarrierMovementDTO> carriers() {
        return routingQueryService.queryCarriers();
    }

    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public List<LocationDO> locations() {
        return routingQueryService.queryLocations();
    }

}
