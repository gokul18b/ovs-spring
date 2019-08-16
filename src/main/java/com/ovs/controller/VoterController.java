package com.ovs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ovs.dao.EmployeeResponse;
import com.ovs.service.voter.VoterService;

@RestController
@RequestMapping("/voter")
public class VoterController {
	@Autowired
	VoterService voterService;

	@GetMapping("/get_employee")
	public ResponseEntity<List<EmployeeResponse>> get_join() {
		return ResponseEntity.ok().body(voterService.get_employees());
	}
	
	@GetMapping("/get_student")
	public ResponseEntity<List<EmployeeResponse>> get_student() {
		return ResponseEntity.ok().body(voterService.get_students());
	}
	
	
	@GetMapping("/test")
	public String  test() {
		return "test";
	}
}
