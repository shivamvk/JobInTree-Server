package io.jobintree.rest.company;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jobintree.rest.response.Response;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService service;
	
	@PostMapping(value="/company")
	public Response addCompany(@RequestParam String name,
			@RequestParam String id,
			@RequestParam String description) {
		service.insert(new Company(id, name, description));
		List<Object> list = new ArrayList<>();
		list.add(new Company(id, name, description));
		Response response = new Response(200, list, "Okay.");
		return response;
	}
	
}
