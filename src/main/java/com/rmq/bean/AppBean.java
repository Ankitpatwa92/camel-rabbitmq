package com.rmq.bean;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

/**
 * The Class AppBean.
 *
 * @author ankit.patwa msa
 */
@Component
public class AppBean {

	
	public void printMessage(Exchange e) {
		
		System.out.println(e.getIn().getBody(String.class));
		System.out.println("..");
	}
}
