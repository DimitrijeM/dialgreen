package rs.crapp.dialgreen.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import rs.crapp.dialgreen.domain.UserEntity;
import rs.crapp.dialgreen.dto.AddPointsDto;
import rs.crapp.dialgreen.dto.UserFromDto;
import rs.crapp.dialgreen.dto.UserToDto;
import rs.crapp.dialgreen.service.UserService;

@RestController
public class UserApi {
	
	@Autowired
	UserService service;
	
	//User sing up
	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserToDto sigupUser(@RequestBody UserFromDto user) throws Exception {
		return service.createUser(user);
	}
	
	//User login
	@RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	UserEntity signinUser(@RequestBody UserFromDto userName) throws Exception {


		return service.isUserExist(userName);
	}
	
	//addPoints
	@RequestMapping(value = "/user/add-points", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserToDto addPoints(@RequestBody AddPointsDto addPointsDto) throws Exception {
		return service.addPoints(addPointsDto.getUserId(), addPointsDto.getWeight(), addPointsDto.getMaterialType());
	}
	
	
}
