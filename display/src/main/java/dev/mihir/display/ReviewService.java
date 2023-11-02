package dev.mihir.display;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;

public class ReviewService {

  @Autowired
  private ReviewRepository reviewRepository;

  @Autowired
  private MongoTemplate mongoTemplate;

  public Review createReview(String reviewBody, String displayId) {
    Review review = reviewRepository.insert(new Review(reviewBody));

    mongoTemplate
      .update(Display.class)
      .matching(Criteria.where("displayId").is(displayId))
      .apply(new Update().push("reviewIds").value(review))
      .first();

    return review;
  }
}
