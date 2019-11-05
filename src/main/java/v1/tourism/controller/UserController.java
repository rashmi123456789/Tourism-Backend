package v1.tourism.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import v1.tourism.model.User;
import v1.tourism.repository.RepositoryInterface.UserRepository;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    public UserRepository userRepository;

    //creating a user
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

    //Get All the users
    @GetMapping("/all")
    public Flux<User> getAllUsers(){
        return userRepository.findAll();
    }

    //Update User Details
    @PutMapping("/{userId}")
    public Mono<ResponseEntity<User>> updateUser(@RequestBody User user , @PathVariable String userId){
        return userRepository.findById(userId)
        .flatMap(userInDb->{
            userInDb.setEmail(user.getEmail());
            userInDb.setCountry(user.getCountry());
            userInDb.setAge(user.getAge());
            userInDb.setPassword(user.getPassword());
            userInDb.setName(user.getName());

            return userRepository.save(userInDb);
        })
        .map(updatedUser -> ResponseEntity.ok(updatedUser))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Delete a User
    @DeleteMapping("/{userId}")
    public Mono<ResponseEntity<Void>> deleteStudent(@PathVariable(value = "userId") String userId) {
        return userRepository.findById(userId)
        .flatMap(selectedUser ->
        userRepository.delete(selectedUser)
        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
        ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}