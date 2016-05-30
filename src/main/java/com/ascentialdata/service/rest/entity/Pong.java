package com.ascentialdata.service.rest.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pong {

	String response = "pong";
	Date datetime = new java.util.Date();
	String environmnet = "DEV";

	public String getEnvironmnet() {
		return environmnet;
	}

	public void setEnvironmnet(String environmnet) {
		this.environmnet = environmnet;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}