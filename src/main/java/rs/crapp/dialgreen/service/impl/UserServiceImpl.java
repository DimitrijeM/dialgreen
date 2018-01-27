package rs.crapp.dialgreen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.crapp.dialgreen.config.RawMaterialConsts;
import rs.crapp.dialgreen.dao.UserRepository;
import rs.crapp.dialgreen.domain.UserEntity;
import rs.crapp.dialgreen.dto.UserFromDto;
import rs.crapp.dialgreen.dto.UserToDto;
import rs.crapp.dialgreen.service.UserService;
import rs.crapp.dialgreen.util.impl.CastDtoDaoService;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CastDtoDaoService castDtoDaoService;

//    ArrayList<String> rawMaterials

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
    public UserToDto addPoints(String userId, double weight, String materialType) throws Exception{
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
        UserToDto userToDto = castDtoDaoService.castUserToDto(userEntity);

        return userToDto;
    }
}
