package com.abdulbasit.spring.documented.webapp.Controller;

import com.abdulbasit.spring.documented.webapp.Config.WebClientImpl;
import com.abdulbasit.spring.documented.webapp.Model.UserData;
import com.abdulbasit.spring.documented.webapp.Repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    private final WebClientImpl webClient;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "(Gets all users from DataBase)",
            notes = "Displays all saved users info or from static source when empty.",
            response = UserData.class)
    public Flux<UserData> findAll() {
        return userRepository.findAll().switchIfEmpty(webClient.simpleClient().get()
                .uri("https://jsonplaceholder.typicode.com/users")
                .retrieve()
                .bodyToFlux(UserData.class));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserData user) throws ExecutionException, InterruptedException {
        System.out.println("Saving data to DB for :." + user.getName());
        Mono<UserData> response = userRepository.save(user);
        System.out.println(">>>>>>>>>>>>> User data saved : " + response.toFuture().get());
    }

    @DeleteMapping("/{id}")
    //   @RequestMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) throws ExecutionException, InterruptedException {
        System.out.println("Data id to delete : " + id);
        userRepository.deleteById(id).toFuture().get();

        if (userRepository.findById(id) == null) {
            System.out.println(" >>>>>>>>>> Deleted successfully from DB.");
        } else {
            System.out.println(" >>>>>>>>>> Data not deleted ID is :." + userRepository.findById(id)
                    .toFuture().get());
        }

    }
}
