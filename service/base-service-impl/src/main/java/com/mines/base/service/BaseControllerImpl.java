package com.mines.base.service;

import com.mines.base.libs.dtos.request.Request;
import com.mines.base.libs.dtos.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BaseControllerImpl implements BaseController{

	private static final Logger LOG = LoggerFactory.getLogger(BaseControllerImpl.class);
	@Value("${base.server.id:whatever}")
	private String serverId;

	public BaseControllerImpl(){

	}

	@Override
	public Response submit(Request request){

		LOG.debug("entering submit");

		Response response = new Response();
		response.setCorrelationId(request.getCorrelationId());
		response.setContent(request.getContent() + ">" + serverId);

		LOG.debug("responding {}", response);
		return response;
	}
}
