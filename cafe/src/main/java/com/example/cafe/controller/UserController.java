package com.example.cafe.controller;

import com.example.cafe.entity.Users;
import com.example.cafe.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDetailService userDetailService;

    @GetMapping
    public List<Users>  getAll(){
        return userDetailService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody Users user){
        userDetailService.saveEntry(user);
    }

    // we will find username in database then find with username
    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody Users user, @PathVariable String userName){
        Users userPresent = userDetailService.findByUserName(userName);
        if(userPresent != null){
            userPresent.setUserName(user.getUserName());
            userPresent.setPassword(user.getPassword());
            userDetailService.saveEntry(userPresent);
        }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
