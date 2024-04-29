package bg.tuvarna.sit.taskmanager.domain_models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Task {
  private Long id;
  private String title;
  private String description;
  private String deadline;
}
