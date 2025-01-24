package com.example.cafe.service;

import com.example.cafe.Repository.JournalEntryRepository;
import com.example.cafe.Repository.UserEntryRepository;
import com.example.cafe.entity.JournalEntry;
import com.example.cafe.entity.Users;
import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDetailService {

    @Autowired
    private UserEntryRepository userEntryRepository;

    public void saveEntry(Users user){
        userEntryRepository.save(user);
    }

    public List<Users> getAll(){
        return userEntryRepository.findAll();
    }

    public Optional<Users> findById(ObjectId id){
        return userEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userEntryRepository.deleteById(id);
    }

    public Users findByUserName(String userName){
        return userEntryRepository.findByUserName(userName);
    }
}
