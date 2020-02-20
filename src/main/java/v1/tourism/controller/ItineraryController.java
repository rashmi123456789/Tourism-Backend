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
import v1.tourism.model.Itinerary;
import v1.tourism.repository.RepositoryInterface.ItineraryRepository;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/itinerary")
class ItineraryController {

    @Autowired
    public ItineraryRepository itineraryRepository;

    //creating a itinerary
    @PostMapping
    public Mono<ResponseEntity<Itinerary>> create(@RequestBody Itinerary itinerary){
        return itineraryRepository.save(itinerary)
        .map(savedItinerary-> ResponseEntity.ok(savedItinerary));
    }

    //Getting a itinerary from id
    @GetMapping("/{itineraryId}")
    public Mono<ResponseEntity<Itinerary>> getItinerary(@PathVariable String itineraryId){
        return itineraryRepository.findById(itineraryId)
        .map(itinerary->ResponseEntity.ok(itinerary))
        .defaultIfEmpty(ResponseEntity.notFound()
        .build());
    }

    //Get All the itinerarys
    @GetMapping("/all")
    public Flux<Itinerary> getAllItinerarys(){
        return itineraryRepository.findAll();
    }

    //Update Itinerary Details
    @PutMapping("/{itineraryId}")
    public Mono<ResponseEntity<Itinerary>> updateItinerary(@RequestBody Itinerary itinerary , @PathVariable String itineraryId){
        return itineraryRepository.findById(itineraryId)
        .flatMap(itineraryInDb->{
            itineraryInDb.setDescription(itinerary.getDescription());
            itineraryInDb.setActivities(itinerary.getActivities());
            itineraryInDb.setDayNum(itinerary.getDayNum());
            itineraryInDb.setDestination(itinerary.getDestination());
            itineraryInDb.setImageName(itinerary.getImageName());
            itineraryInDb.setName(itinerary.getName());

            return itineraryRepository.save(itineraryInDb);
        })
        .map(updatedItinerary -> ResponseEntity.ok(updatedItinerary))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Delete a Itinerary
    @DeleteMapping("/{itineraryId}")
    public Mono<ResponseEntity<Void>> deleteStudent(@PathVariable(value = "itineraryId") String itineraryId) {
        return itineraryRepository.findById(itineraryId)
        .flatMap(selectedItinerary ->
        itineraryRepository.delete(selectedItinerary)
        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
        ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}