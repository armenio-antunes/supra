package com.mines.base.libs.dtos.response;

import java.io.Serializable;

public class Response implements Serializable {
  
    private static final long serialVersionUID = 2540128883298237136L;

    
    private String correlationId;
    private String content;

    public String getCorrelationId(){

        return correlationId;
    }

    public void setCorrelationId(String correlationId){

        this.correlationId = correlationId;
    }

    public String getContent(){

        return content;
    }

    public void setContent(String content){

        this.content = content;
    }
}
