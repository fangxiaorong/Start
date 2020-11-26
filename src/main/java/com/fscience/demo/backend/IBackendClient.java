package com.fscience.demo.backend;

import com.fscience.demo.backend.data.Result;

public interface IBackendClient {
    Result init(String[] args);
    Result evaluate(String command);
    Result destroy();
}
