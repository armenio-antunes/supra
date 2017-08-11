package com.mines.base.restapi.services;

import com.mines.base.libs.dtos.request.Request;
import com.mines.base.libs.dtos.response.Response;

public interface BaseService{
    /**
     * Ping-pong method. Used to test if service is up and running.
     *
     * @param message
     * @return
     */
    String ping(String message);

    Response submit(Request request);
}
