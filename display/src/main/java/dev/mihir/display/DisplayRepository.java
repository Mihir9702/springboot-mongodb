package dev.mihir.display;

import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisplayRepository extends MongoRepository<Display, ObjectId> {
  Optional<Display> findByDisplayId(String displayId);
}
