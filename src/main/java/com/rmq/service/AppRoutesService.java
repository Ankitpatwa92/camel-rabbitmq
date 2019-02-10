package com.rmq.service;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.rmq.bean.AppBean;


/**
 * The Class AppRoutesService.
 */
@Component
public class AppRoutesService extends RouteBuilder {

	
	@Override
	public void configure() throws Exception {
		
		String HOST="localhost";
		String PORT="5672";
		String USER_NAME="guest";
		String PASSWORD="guest";
		
		
		String route = "rabbitmq://"+HOST+":"+PORT
				        + "/oppo.exchange?"
				        + "username="+USER_NAME
				        + "&password="+PASSWORD
				        + "&autoDelete=false"
				        + "&autoAck=true"
				        + "&queue=oppo";
		
		
		from(route).bean(AppBean.class, "printMessage");

	}

	
}
