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
import v1.tourism.model.Inquiries;
import v1.tourism.repository.RepositoryInterface.InquiriesRepository;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/inquiries")
class InquiriesController {

    @Autowired
    public InquiriesRepository inquiriesRepository;

    //creating a inquiries
    @PostMapping
    public Mono<ResponseEntity<Inquiries>> create(@RequestBody Inquiries inquiries){
        return inquiriesRepository.save(inquiries)
        .map(savedInquiries-> ResponseEntity.ok(savedInquiries));
    }

    //Getting a inquiries from id
    @GetMapping("/{inquiriesId}")
    public Mono<ResponseEntity<Inquiries>> getInquiries(@PathVariable String inquiriesId){
        return inquiriesRepository.findById(inquiriesId)
        .map(inquiries->ResponseEntity.ok(inquiries))
        .defaultIfEmpty(ResponseEntity.notFound()
        .build());
    }

    //Get All the inquiriess
    @GetMapping("/all")
    public Flux<Inquiries> getAllInquiriess(){
        return inquiriesRepository.findAll();
    }

    //Update Inquiries Details
    @PutMapping("/{inquiriesId}")
    public Mono<ResponseEntity<Inquiries>> updateInquiries(@RequestBody Inquiries inquiries , @PathVariable String inquiriesId){
        return inquiriesRepository.findById(inquiriesId)
        .flatMap(inquiriesInDb->{
            inquiriesInDb.setEmail(inquiries.getEmail());
            inquiriesInDb.setCountry(inquiries.getCountry());
            inquiriesInDb.setFromDate(inquiries.getFromDate());
            inquiriesInDb.setToDate(inquiries.getToDate());
            inquiriesInDb.setNumOfAdult(inquiries.getNumOfAdult());
            inquiriesInDb.setNumOfChildren(inquiries.getNumOfChildren());
            inquiriesInDb.setPackageId(inquiries.getPackageId());

            return inquiriesRepository.save(inquiriesInDb);
        })
        .map(updatedInquiries -> ResponseEntity.ok(updatedInquiries))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Delete a Inquiries
    @DeleteMapping("/{inquiriesId}")
    public Mono<ResponseEntity<Void>> deleteStudent(@PathVariable(value = "inquiriesId") String inquiriesId) {
        return inquiriesRepository.findById(inquiriesId)
        .flatMap(selectedInquiries ->
        inquiriesRepository.delete(selectedInquiries)
        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
        ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}