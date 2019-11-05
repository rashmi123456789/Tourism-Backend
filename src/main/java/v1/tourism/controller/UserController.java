package v1.tourism.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import v1.tourism.model.User;
import v1.tourism.repository.RepositoryInterface.UserRepository;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    public UserRepository userRepository;

    //Creating a user
    @PostMapping
    public Mono<ResponseEntity<User>> create(@RequestBody User user){
        return userRepository.save(user)
        .map(savedUser-> ResponseEntity.ok(savedUser));
    }

    //Getting a user from id
    @GetMapping("/{userId}")
    public Mono<ResponseEntity<User>> getUser(@PathVariable String userId){
        return userRepository.findById(userId)
        .map(user->ResponseEntity.ok(user))
        .defaultIfEmpty(ResponseEntity.notFound()
        .build());
    }


}