package com.nttdata.test.controller;

import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.test.service.Greeting;

@RequestMapping("greetings")
@BasePathAwareController
public class GreetingController {

	@GetMapping(value = "/sayHello", produces = MediaTypes.HAL_JSON_VALUE)
	public ResponseEntity<Resource<Greeting>> greeting(@RequestParam("name") String name) {
		final String message = String.format(Greeting.FORMAT, name);
		Resource<Greeting> resource= new Resource<>(new Greeting(message));
		return ResponseEntity.ok(resource);
	}

}
