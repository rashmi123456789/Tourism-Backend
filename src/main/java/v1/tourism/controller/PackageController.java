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
import v1.tourism.model.Package;
import v1.tourism.repository.RepositoryInterface.PackageRepository;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/packages")
class PackageController {

    @Autowired
    public PackageRepository packagesRepository;

    //creating a packages
    @PostMapping
    public Mono<ResponseEntity<Package>> create(@RequestBody Package packages){
        return packagesRepository.save(packages)
        .map(savedPackage-> ResponseEntity.ok(savedPackage));
    }

    //Getting a packages from id
    @GetMapping("/{packagesId}")
    public Mono<ResponseEntity<Package>> getPackage(@PathVariable String packagesId){
        return packagesRepository.findById(packagesId)
        .map(packages->ResponseEntity.ok(packages))
        .defaultIfEmpty(ResponseEntity.notFound()
        .build());
    }

    //Get All the packagess
    @GetMapping("/all")
    public Flux<Package> getAllPackages(){
        return packagesRepository.findAll();
    }

    //Update Package Details
    @PutMapping("/{packagesId}")
    public Mono<ResponseEntity<Package>> updatePackage(@RequestBody Package packages , @PathVariable String packagesId){
        return packagesRepository.findById(packagesId)
        .flatMap(packagesInDb->{
            packagesInDb.setDescription(packages.getDescription());
            packagesInDb.setTotalPrice(packages.getTotalPrice());
            packagesInDb.setItineraryIdArray(packages.getItineraryIdArray());
            packagesInDb.setExclusions(packages.getExclusions());
            packagesInDb.setInclusions(packages.getInclusions());
            packagesInDb.setName(packages.getName());
            packagesInDb.setImageName(packages.getImageName());
            packagesInDb.setMapId(packages.getMapId());

            return packagesRepository.save(packagesInDb);
        })
        .map(updatedPackage -> ResponseEntity.ok(updatedPackage))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Delete a Package
    @DeleteMapping("/{packagesId}")
    public Mono<ResponseEntity<Void>> deleteStudent(@PathVariable(value = "packagesId") String packagesId) {
        return packagesRepository.findById(packagesId)
        .flatMap(selectedPackage ->
        packagesRepository.delete(selectedPackage)
        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
        ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}