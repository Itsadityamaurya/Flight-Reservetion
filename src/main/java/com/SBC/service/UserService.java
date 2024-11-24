package com.SBC.service;

import com.SBC.dto.UserDto;
import com.SBC.entity.UserEntity;

public interface UserService {

    UserDto saveUser(UserEntity userDto);
    UserEntity mapToEntity(UserDto userDto);


}
