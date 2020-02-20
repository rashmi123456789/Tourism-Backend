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
import v1.tourism.model.Map;
import v1.tourism.repository.RepositoryInterface.MapRepository;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/map")
class MapController {

    @Autowired
    public MapRepository mapRepository;

    //creating a map
    @PostMapping
    public Mono<ResponseEntity<Map>> create(@RequestBody Map map){
        return mapRepository.save(map)
        .map(savedMap-> ResponseEntity.ok(savedMap));
    }

    //Getting a map from id
    @GetMapping("/{mapId}")
    public Mono<ResponseEntity<Map>> getMap(@PathVariable String mapId){
        return mapRepository.findById(mapId)
        .map(map->ResponseEntity.ok(map))
        .defaultIfEmpty(ResponseEntity.notFound()
        .build());
    }

    //Get All the maps
    @GetMapping("/all")
    public Flux<Map> getAllMaps(){
        return mapRepository.findAll();
    }

    //Update Map Details
    @PutMapping("/{mapId}")
    public Mono<ResponseEntity<Map>> updateMap(@RequestBody Map map , @PathVariable String mapId){
        return mapRepository.findById(mapId)
        .flatMap(mapInDb->{
            mapInDb.setUrl(map.getUrl());

            return mapRepository.save(mapInDb);
        })
        .map(updatedMap -> ResponseEntity.ok(updatedMap))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Delete a Map
    @DeleteMapping("/{mapId}")
    public Mono<ResponseEntity<Void>> deleteStudent(@PathVariable(value = "mapId") String mapId) {
        return mapRepository.findById(mapId)
        .flatMap(selectedMap ->
        mapRepository.delete(selectedMap)
        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
        ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}