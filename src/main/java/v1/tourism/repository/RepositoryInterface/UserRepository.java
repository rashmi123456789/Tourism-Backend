package v1.tourism.repository.RepositoryInterface;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import v1.tourism.model.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
    
} 