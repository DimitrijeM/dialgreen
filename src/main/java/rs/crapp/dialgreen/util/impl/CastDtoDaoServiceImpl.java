package rs.crapp.dialgreen.util.impl;

import org.springframework.stereotype.Service;
import rs.crapp.dialgreen.domain.UserEntity;
import rs.crapp.dialgreen.dto.UserFromDto;
import rs.crapp.dialgreen.dto.UserToDto;

@Service
public class CastDtoDaoServiceImpl implements CastDtoDaoService{

    @Override
    public UserEntity castUserFromDto(UserFromDto userFromDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userFromDto.getName());
        userEntity.setPassword(userFromDto.getPassword());
        Double points = new Double(0);
        userEntity.setPoints(points);
        return userEntity;
    }

    @Override
    public UserToDto castUserToDto(UserEntity userEntity) {
        UserToDto userToDto = new UserToDto();
        userToDto.setId(userEntity.getId());
        userToDto.setName(userEntity.getName());
        userToDto.setPoint(userEntity.getPoints());
        return userToDto;
    }
}
