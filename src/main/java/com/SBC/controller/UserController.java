package com.SBC.controller;

import com.SBC.dto.UserDto;
import com.SBC.entity.UserEntity;
import com.SBC.service.UserServiceIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserServiceIMPL userServiceIMPL;

    @PostMapping
    public UserDto regCreate (@RequestBody UserEntity entity){
        UserDto reg = userServiceIMPL.createReg(entity);
        return reg;
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getUser(UserEntity user){
        List<UserDto> user1 = userServiceIMPL.getUser(user);
//        return ResponseEntity.ok(user1);
        return  new ResponseEntity<>(user1 , HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser( @PathVariable long id, @RequestBody UserDto user){
        UserDto userDto = userServiceIMPL.updateUser(id, user);
        return ResponseEntity.ok(userDto);
    }
    @DeleteMapping
    public String deleteUser(@RequestParam long id){
        userServiceIMPL.deleteUser(id);
        return "Delete Successfully";
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable long id){
        UserDto byId = userServiceIMPL.getById(id);
        return new  ResponseEntity<>(byId , HttpStatus.OK);
    }

}
