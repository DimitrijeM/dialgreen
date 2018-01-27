package rs.crapp.dialgreen.util.impl;

import rs.crapp.dialgreen.domain.UserEntity;
import rs.crapp.dialgreen.dto.UserFromDto;
import rs.crapp.dialgreen.dto.UserToDto;

public interface CastDtoDaoService {

    public UserEntity castUserFromDto(UserFromDto userFromDto);

    public UserToDto castUserToDto(UserEntity userEntity);
}
