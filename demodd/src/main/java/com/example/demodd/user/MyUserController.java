package com.example.demodd.user;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController @RequestMapping("MyUser/")
@RequiredArgsConstructor
public class MyUserController {
    private final MyUserService MyUserService;
    Logger logger = LoggerFactory.getLogger(MyUserController.class);
    @GetMapping("")
    public ResponseEntity getMyUsers(){
        logger.info("Invoked get all users");
        return ResponseEntity.status(200).body(MyUserService.getMyUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity getMyUser(@PathVariable Integer id){
        logger.info("Invoked get a user");
        return ResponseEntity.status(200).body(MyUserService.getMyUser(id));
    }

    @PostMapping("")
    public ResponseEntity addMyUser(@RequestBody @Valid MyUser myUser){
        logger.info("Invoked add a user");
        MyUserService.addMyUser(myUser);
        return ResponseEntity.status(200).body("Added" + myUser.getUsername());
    }
}
