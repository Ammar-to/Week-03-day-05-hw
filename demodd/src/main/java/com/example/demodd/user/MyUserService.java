package com.example.demodd.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserService {
    private final MyUserRepository MyUserRepository;

    public List<MyUser> getMyUsers(){
        return MyUserRepository.findAll();
    }

    public MyUser getMyUser(Integer MyUserId){
        return MyUserRepository.findById(MyUserId).get();
    }

    public void addMyUser(MyUser MyUser){
        MyUserRepository.save(MyUser);
    }
}
