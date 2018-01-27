package rs.crapp.dialgreen.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class UserApi {
	
	//Create
	@RequestMapping (value = "/file", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserToDto createNewFile(@RequestBody UserToDto user) {

	}
	
	//READ - one
	@RequestMapping UserToDto (value = "/file/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  returnFile(@PathVariable String code, HttpServletRequest request) {			
	
	}

	
	
}
