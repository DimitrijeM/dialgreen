package rs.crapp.dialgreen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.crapp.dialgreen.config.RawMaterialConsts;
import rs.crapp.dialgreen.dao.UserRepository;
import rs.crapp.dialgreen.domain.UserEntity;
import rs.crapp.dialgreen.dto.UserFromDto;
import rs.crapp.dialgreen.dto.UserToDto;
import rs.crapp.dialgreen.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserToDto createUser(UserFromDto user) {
        UserEntity userEntity = new UserEntity(user.getName(), user.getPassword(), 0.0);
//        UserEntity userEntity = castDtoDaoService.castUserFromDto(user);
        userRepository.save(userEntity);
        UserToDto userToDto = new UserToDto(userEntity.getId(), userEntity.getName(), userEntity.getPoints());
//        UserToDto userToDto = castDtoDaoService.castUserToDto(userEntity);
        return userToDto;
    }


    @Override
    public UserEntity isUserExist(UserFromDto user) throws Exception{
        UserEntity userEntity = userRepository.findUserEntitiesByName(user.getName());
        if(userEntity.getPassword().equals(user.getPassword()))
            return userEntity;
        else throw new Exception("Incorrect password");

    }

    @Override
    public UserToDto addPoints(Long userId, double weight, String materialType) throws Exception{
        int coeff = 0;
        if(materialType.equals("PAPER")) coeff = RawMaterialConsts.PAPER_COEF;
        if(materialType.equals("GLASS")) coeff = RawMaterialConsts.GLASS_COEF;
        if(materialType.equals("PLASTIC")) coeff = RawMaterialConsts.PLASTIC_COEF;
        if(materialType.equals("ALUMINIUM")) coeff = RawMaterialConsts.ALUMINIUM_COEF;

        if (coeff == 0) throw new Exception("Error material type.");
        double points = weight*coeff;

        UserEntity userEntity = userRepository.findOne(userId);
        points = userEntity.getPoints() + points;
        userEntity.setPoints(points);
        userRepository.save(userEntity);
        UserToDto userToDto = new UserToDto(userEntity.getId(), userEntity.getName(), userEntity.getPoints());

        return userToDto;
    }
}
