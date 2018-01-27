package rs.crapp.dialgreen.service;

import org.springframework.stereotype.Service;
import rs.crapp.dialgreen.dto.UserFromDto;
import rs.crapp.dialgreen.dto.UserToDto;

@Service
public class UserService {

    public UserToDto createUser(UserFromDto user);

    public UserToDto isUserExist(UserFromDto user); //login

    public UserToDto addPoints(UserFromDto user, double weight, String materialType);
    
}
