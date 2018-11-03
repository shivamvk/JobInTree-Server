package io.jobintree.rest.user;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jobintree.rest.response.Response;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	@PostMapping(value="/login")
	public Response loginUser(@RequestParam String phone) {
		Response response;
		if(phone.length() != 10) {
			response = new Response(400, null,"Invalid mobile number!");
			return response;
		} else if(!service.numberExists(phone)) {
			response = new Response(204, null,"Mobile number doesn't exist");
			return response;
		} else {
			User user = service.getUserByPhone(phone);
			List<Object> list = new ArrayList<>();
			list.add(user);
			response = new Response(200, list, "Okay.");
			return response;
		}
	}
	
	@PostMapping(value="/signup")
	public Response signup(@RequestParam String name,
			@RequestParam String email,
			@RequestParam String phone) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
		Response response;
	    if(!matcher.find()) {
	    	response = new Response(400, null, "Invalid email address!");
	    	return response;
	    } else if (phone.length() != 10) {
	    	response = new Response(400, null, "Invalid mobile number!");
	    	return response;
	    } else if(service.numberExists(phone)) {
	    	response = new Response(204, null, "Mobile number already exists");
	    	return response;
	    } else if(service.emailExists(email)) {
	    	response = new Response(204, null, "Email already exists");
	    	return response;
	    } else {
	    	User user = new User(name, email, phone);
	    	service.insertUser(user);
	    	List<Object> list = new ArrayList<>();
	    	list.add(user);
	    	response = new Response(200, list, "Okay.");
	    	return response;
	    }
	}
	
}
