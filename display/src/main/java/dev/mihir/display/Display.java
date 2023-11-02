package dev.mihir.display;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "displays")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Display {

  @Id
  private ObjectId id;

  private String title;

  private String description;

  private String displayId;

  private int width;

  private int height;

  @DocumentReference
  private List<Review> reviewIds;
}
