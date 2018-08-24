package com.puc.tcc.scheduler.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
 
@RestController
@AllArgsConstructor
@RequestMapping("v1/main")
public class MaintainerController {
 
    private final MaintainerService maintainerService;
 
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public String getString() {
        return maintainerService.getString();
    }
}