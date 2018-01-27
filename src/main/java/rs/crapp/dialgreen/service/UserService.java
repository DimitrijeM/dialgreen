package rs.crapp.dialgreen.service;

import rs.crapp.dialgreen.domain.UserEntity;
import rs.crapp.dialgreen.dto.UserFromDto;
import rs.crapp.dialgreen.dto.UserToDto;

public interface UserService {

    public UserToDto createUser(UserFromDto user);

    public UserEntity isUserExist(UserFromDto user) throws Exception; //login

    public UserToDto addPoints(Long userId, double weight, String materialType) throws Exception;
}
