package com.sellab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sellab.model.User;
import com.sellab.repository.FlipkarRepository;

@RestController
@RequestMapping("/oderservice")
public class FlipkarOMController {

	@Autowired
	private FlipkarRepository repository;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	@PostMapping("/placeOrderNow")
	public String placeOrder(@RequestBody User user) {
		repository.save(user);
		return "Success";
	}
	
	@GetMapping("/getUserByName/{name}")
	public List<User> getUserName(@RequestBody String name){
		return repository.findByName(name);
	}
	
	@GetMapping("/getUserByAddress/{city}")
	public List<User> getUserByAddress(@RequestBody String city){
		return repository.findByCity(city);
	}
	
}
