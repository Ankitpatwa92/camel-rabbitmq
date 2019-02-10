/**
 * 
 */
package com.rmq.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ankit.patwa
 *
 */
@Service
public class RmqPublisherService {

	@Autowired
	CamelContext camelContext;
	
	public void publishMessage(String msg) {
		
		String HOST="localhost";
		String PORT="5672";
		String USER_NAME="guest";
		String PASSWORD="guest";

		
		String route="rabbitmq://"+HOST+":"+PORT+"/oppo.exchange?"
				+ "username="+USER_NAME
				+ "&password="+PASSWORD
				+ "&autoDelete=false"
				+ "&autoAck=true"	
		        + "&declare=false"
				+ "&vhost=/";		       
				
		Map<String,Object> headers=new HashMap<String,Object>();
		headers.put("rabbitmq.ROUTING_KEY","R1");
		headers.put("rabbitmq.DELIVERY_MODE",2);
		
		ProducerTemplate producerTemplate=camelContext.createProducerTemplate();		
		producerTemplate.sendBodyAndHeaders(route,msg,headers);
		try {
			 producerTemplate.stop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
}
