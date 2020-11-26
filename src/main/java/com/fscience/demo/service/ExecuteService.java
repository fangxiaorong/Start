package com.fscience.demo.service;

import com.fscience.demo.backend.data.Result;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ExecuteService {
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    Map<String, Object> clientMap = new HashMap();

    public Result doExecute(String client, String evlStr) {
        return new Result();
    }
}
