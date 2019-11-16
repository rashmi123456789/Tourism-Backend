package v1.tourism.repository.RepositoryInterface;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import v1.tourism.model.Package;

@Repository
public interface PackageRepository extends ReactiveMongoRepository<Package, String> {
    
} 