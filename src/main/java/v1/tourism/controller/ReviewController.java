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
import v1.tourism.model.Review;
import v1.tourism.repository.RepositoryInterface.ReviewRepository;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/review")
class ReviewController {

    @Autowired
    public ReviewRepository reviewRepository;

    //creating a review
    @PostMapping
    public Mono<ResponseEntity<Review>> create(@RequestBody Review review){
        return reviewRepository.save(review)
        .map(savedReview-> ResponseEntity.ok(savedReview));
    }

    //Getting a review from id
    @GetMapping("/{reviewId}")
    public Mono<ResponseEntity<Review>> getReview(@PathVariable String reviewId){
        return reviewRepository.findById(reviewId)
        .map(review->ResponseEntity.ok(review))
        .defaultIfEmpty(ResponseEntity.notFound()
        .build());
    }

    //Get All the reviews
    @GetMapping("/all")
    public Flux<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    //Update Review Details
    @PutMapping("/{reviewId}")
    public Mono<ResponseEntity<Review>> updateReview(@RequestBody Review review , @PathVariable String reviewId){
        return reviewRepository.findById(reviewId)
        .flatMap(reviewInDb->{
            reviewInDb.setEmail(review.getEmail());
            reviewInDb.setMessage(review.getMessage());
            reviewInDb.setDate(review.getDate());
            reviewInDb.setName(review.getName());

            return reviewRepository.save(reviewInDb);
        })
        .map(updatedReview -> ResponseEntity.ok(updatedReview))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Delete a Review
    @DeleteMapping("/{reviewId}")
    public Mono<ResponseEntity<Void>> deleteStudent(@PathVariable(value = "reviewId") String reviewId) {
        return reviewRepository.findById(reviewId)
        .flatMap(selectedReview ->
        reviewRepository.delete(selectedReview)
        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
        ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}