/**
 * 
 */
package com.rmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rmq.service.RmqPublisherService;

/**
 * @author ankit.patwa
 *
 */
@RestController
public class AppController {

	@Autowired
	RmqPublisherService rmqService;
	
	
	@PostMapping("/sendMessageToRmq")
	public String sendMessageToRmq(@RequestBody String msg) {
				
		rmqService.publishMessage(msg);
		return "Message Pubished";
	}
	
	
}
