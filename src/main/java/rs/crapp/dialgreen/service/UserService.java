package rs.crapp.dialgreen.service;

import rs.crapp.dialgreen.dto.UserFromDto;
import rs.crapp.dialgreen.dto.UserToDto;

public interface UserService {

    public UserToDto createUser(UserFromDto user);

    public UserToDto isUserExist(UserFromDto user); //login

    public UserToDto addPoints(UserFromDto user, double weight, String materialType);
}
