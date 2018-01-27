package rs.crapp.dialgreen.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import rs.crapp.dialgreen.dto.AddPointsDto;
import rs.crapp.dialgreen.dto.UserFromDto;
import rs.crapp.dialgreen.dto.UserToDto;
import rs.crapp.dialgreen.service.UserService;

public class UserApi {
	
	@Autowired
	UserService service;
	
	//User sing up
	@RequestMapping (value = "/user/sign-up", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserToDto sigupUser(@RequestBody UserFromDto user) {
		return service.createUser(user);
	}
	
	//User login
	@RequestMapping (value = "/user/sing-in", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserToDto signinUser(@RequestBody UserFromDto userName) {
		return service.isUserExist(userName);
	}
	
	//addPoints
	@RequestMapping (value = "/user/add-points", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserToDto addPoints(@RequestBody AddPointsDto addPointsDto) throws Exception {
		return service.addPoints(addPointsDto.getUserId(), addPointsDto.getWeight(), addPointsDto.getMaterialType());
	}
	
	
}
