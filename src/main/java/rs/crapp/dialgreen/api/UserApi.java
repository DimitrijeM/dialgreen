package rs.crapp.dialgreen.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import rs.crapp.dialgreen.dto.UserFromDto;
import rs.crapp.dialgreen.dto.UserToDto;
import rs.crapp.dialgreen.service.UserService;

public class UserApi {
	
	@Autowired
	UserService service;
	
	//User sing up
	@RequestMapping (value = "/user/loging", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserToDto siginUser(@RequestBody UserFromDto user) {
		return service.createUser(user);
	}
	
	//User login
	@RequestMapping (value = "/user/singup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserToDto logingUser(@RequestBody UserFromDto userName) {
		return service.isUserExist(userName);
	}
	
	//addPoints
	@RequestMapping (value = "/user/addPoints", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserToDto addPoints(@RequestBody UserFromDto user, double weight, String materialType) {
		return service.addPoints(user, weight, materialType);
	}
	
	
}
