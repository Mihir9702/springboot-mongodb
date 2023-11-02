package dev.mihir.display;

import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisplayService {

  @Autowired
  private DisplayRepository displayRepository;

  public List<Display> allDisplays() {
    return displayRepository.findAll();
  }

  public Optional<Display> singleDisplay(String displayId) {
    return displayRepository.findByDisplayId(displayId);
  }
}
