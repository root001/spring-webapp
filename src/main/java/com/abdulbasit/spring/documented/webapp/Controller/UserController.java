package com.abdulbasit.spring.documented.webapp.Controller;

import com.abdulbasit.spring.documented.webapp.Model.UserData;
import com.abdulbasit.spring.documented.webapp.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<UserData> findAll(){
        return userRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserData user){
        userRepository.save(user);
    }
}
