package com.fscience.demo.controllers;

import com.fscience.demo.backend.data.Result;
import com.fscience.demo.service.ExecuteService;
import com.fscience.demo.utils.NetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/execute")
public class ExecuteController {
    @Autowired
    ExecuteService executeService;

    @RequestMapping(value = "/init", method = {RequestMethod.POST, RequestMethod.GET})
    public Object init(String params) {
        return "Hello";
    }

    @RequestMapping(value = "/do", method = {RequestMethod.POST, RequestMethod.GET})
    public Object doExecute(String evlData) {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        Result result = executeService.doExecute(NetUtil.getIpAddr(request), evlData);
        return result;
    }
}
