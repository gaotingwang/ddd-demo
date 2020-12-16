package com.gtw.business.application.controller;

import java.util.Date;

import com.gtw.business.service.command.IncidentLoggingCmdService;
import com.gtw.business.service.command.cmd.HandlingEventAddCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class IncidentLogginController {

    @Autowired
    private IncidentLoggingCmdService incidentLoggingCmdService;
    
    @RequestMapping(method = RequestMethod.POST)
    public void addHandlingEvent(@RequestBody HandlingEventAddCommand cmd) {
        cmd.setDatetime(new Date());
        incidentLoggingCmdService.addHandlingEvent(cmd);
    }

}
