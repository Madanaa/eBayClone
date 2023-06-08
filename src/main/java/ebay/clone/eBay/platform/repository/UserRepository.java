package ebay.clone.eBay.platform.repository;

import ebay.clone.eBay.platform.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUserName(String userName);
}
