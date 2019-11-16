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
import v1.tourism.model.Blog;
import v1.tourism.repository.RepositoryInterface.BlogRepository;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/blog")
class BlogController {

    @Autowired
    public BlogRepository blogRepository;

    //creating a blog
    @PostMapping
    public Mono<ResponseEntity<Blog>> create(@RequestBody Blog blog){
        return blogRepository.save(blog)
        .map(savedBlog-> ResponseEntity.ok(savedBlog));
    }

    //Getting a blog from id
    @GetMapping("/{blogId}")
    public Mono<ResponseEntity<Blog>> getBlog(@PathVariable String blogId){
        return blogRepository.findById(blogId)
        .map(blog->ResponseEntity.ok(blog))
        .defaultIfEmpty(ResponseEntity.notFound()
        .build());
    }

    //Get All the blogs
    @GetMapping("/all")
    public Flux<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }

    //Update Blog Details
    @PutMapping("/{blogId}")
    public Mono<ResponseEntity<Blog>> updateBlog(@RequestBody Blog blog , @PathVariable String blogId){
        return blogRepository.findById(blogId)
        .flatMap(blogInDb->{
            blogInDb.setTopic(blog.getTopic());
            blogInDb.setImageId(blog.getImageId());
            blogInDb.setDescription(blog.getDescription());

            return blogRepository.save(blogInDb);
        })
        .map(updatedBlog -> ResponseEntity.ok(updatedBlog))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Delete a Blog
    @DeleteMapping("/{blogId}")
    public Mono<ResponseEntity<Void>> deleteStudent(@PathVariable(value = "blogId") String blogId) {
        return blogRepository.findById(blogId)
        .flatMap(selectedBlog ->
        blogRepository.delete(selectedBlog)
        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
        ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}