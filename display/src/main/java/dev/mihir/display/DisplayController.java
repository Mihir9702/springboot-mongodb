package dev.mihir.display;

import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/displays")
public class DisplayController {

  @Autowired
  private DisplayService displayService;

  @GetMapping
  public ResponseEntity<List<Display>> getAllDisplays() {
    return new ResponseEntity<List<Display>>(
      displayService.allDisplays(),
      HttpStatusCode.valueOf(200)
    );
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Display>> getSingleDisplay(
    @PathVariable String displayId
  ) {
    return new ResponseEntity<Optional<Display>>(
      displayService.singleDisplay(displayId),
      HttpStatusCode.valueOf(200)
    );
  }
}
