package com.mines.base.restapi.impl;

import com.mines.base.libs.dtos.request.Request;
import com.mines.base.libs.dtos.response.Response;
import com.mines.base.restapi.services.BaseService;
import com.mines.base.service.BaseController;
import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/base", produces = MediaType.APPLICATION_JSON_VALUE)
public class BaseServiceController implements BaseService{

    private static final Logger LOG = LoggerFactory.getLogger(BaseServiceController.class);

    @Autowired
    private BaseController baseController;

    @Override
    @RequestMapping("/ping")
    @ResponseBody
    public String ping(@RequestParam(value = "message", required = false) String message) {

        return message;
    }

    @Override
    @RequestMapping(path = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public Response submit(@RequestBody(required = false) Request request) {

        LOG.debug("entering submit with arguments request and values {}", Arrays.toString(new Object[]{request}));
        MDC.put("correlationId", request.getCorrelationId());
        try {
            return baseController.submit(request);
        } finally {
            MDC.remove("correlationId");
        }
    }

}
