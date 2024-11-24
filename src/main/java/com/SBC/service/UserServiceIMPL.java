package com.SBC.service;

import com.SBC.dto.UserDto;
import com.SBC.entity.UserEntity;
import com.SBC.exception.ResourceNotFound;
import com.SBC.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceIMPL {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public UserDto mapToDto(UserEntity user){
        UserDto map = mapper.map(user, UserDto.class);
        return map;
    }
    UserEntity mapToEntity(UserDto userDto){
        UserEntity map = mapper.map(userDto, UserEntity.class);
        return map;
    }

    public UserDto createReg(UserEntity userEntity){
        UserEntity save = userRepository.save(userEntity);
        UserDto userDto = mapToDto(save);
        return userDto;
    }
    public List<UserDto> getUser(UserEntity userEntity){
        List<UserEntity> all = userRepository.findAll();
        List<UserDto> list = all.stream().map(r -> mapToDto(r)).toList();
        return list;

    }
    public UserDto updateUser( long id ,UserDto dto){
        UserEntity user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFound("id is not present"));
       user.setName(dto.getName());
       user.setAddress(dto.getAddress());
       user.setAge(dto.getAge());
        UserEntity save = userRepository.save(user);
        return mapToDto(save);

    }
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

    public  UserDto getById (long id){
        UserEntity user = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("id is not present"));
        return mapToDto(user);
    }

}




