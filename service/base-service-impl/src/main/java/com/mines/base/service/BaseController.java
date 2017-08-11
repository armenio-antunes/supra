package com.mines.base.service;

import com.mines.base.libs.dtos.request.Request;
import com.mines.base.libs.dtos.response.Response;

public interface BaseController{

  Response submit(Request payload);

}
