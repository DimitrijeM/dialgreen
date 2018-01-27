package rs.crapp.dialgreen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.crapp.dialgreen.dao.UserRepository;
import rs.crapp.dialgreen.domain.UserEntity;
import rs.crapp.dialgreen.dto.UserFromDto;
import rs.crapp.dialgreen.dto.UserToDto;
import rs.crapp.dialgreen.service.UserService;
import rs.crapp.dialgreen.util.impl.CastDtoDaoService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CastDtoDaoService castDtoDaoService;

    @Override
    public UserToDto createUser(UserFromDto user) {
        UserEntity userEntity = castDtoDaoService.castUserFromDto(user);
        userRepository.save(userEntity);
        UserToDto userToDto = castDtoDaoService.castUserToDto(userEntity);
        return userToDto;
    }


    @Override
    public UserToDto isUserExist(UserFromDto user) {
        return null;
    }

    @Override
    public UserToDto addPoints(UserFromDto user, double weight, String materialType) {
        return null;
    }
}
