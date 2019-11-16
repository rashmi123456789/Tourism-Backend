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
import v1.tourism.model.About;
import v1.tourism.repository.RepositoryInterface.AboutRepository;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/about")
class AboutController {

    @Autowired
    public AboutRepository aboutRepository;

    //creating a about
    @PostMapping
    public Mono<ResponseEntity<About>> create(@RequestBody About about){
        return aboutRepository.save(about)
        .map(savedAbout-> ResponseEntity.ok(savedAbout));
    }

    //Getting a about from id
    @GetMapping("/{aboutId}")
    public Mono<ResponseEntity<About>> getAbout(@PathVariable String aboutId){
        return aboutRepository.findById(aboutId)
        .map(about->ResponseEntity.ok(about))
        .defaultIfEmpty(ResponseEntity.notFound()
        .build());
    }

    //Get All the abouts
    @GetMapping("/all")
    public Flux<About> getAllAbouts(){
        return aboutRepository.findAll();
    }

    //Update About Details
    @PutMapping("/{aboutId}")
    public Mono<ResponseEntity<About>> updateAbout(@RequestBody About about , @PathVariable String aboutId){
        return aboutRepository.findById(aboutId)
        .flatMap(aboutInDb->{
            aboutInDb.setEmail(about.getEmail());
            aboutInDb.setMapLanLat(about.getMapLanLat());
            aboutInDb.setTel(about.getTel());
            aboutInDb.setAddress(about.getAddress());

            return aboutRepository.save(aboutInDb);
        })
        .map(updatedAbout -> ResponseEntity.ok(updatedAbout))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Delete a About
    @DeleteMapping("/{aboutId}")
    public Mono<ResponseEntity<Void>> deleteStudent(@PathVariable(value = "aboutId") String aboutId) {
        return aboutRepository.findById(aboutId)
        .flatMap(selectedAbout ->
        aboutRepository.delete(selectedAbout)
        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
        ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}