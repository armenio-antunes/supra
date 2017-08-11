package com.mines.base.libs.dtos.request;

import java.io.Serializable;

public class Request implements Serializable {
    private static final long serialVersionUID = -4317779502512471785L;

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
