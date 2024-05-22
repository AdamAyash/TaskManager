package bg.tuvarna.sit.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReportDto {
    private int id;
    private int taskId;
    private String content;
    private int hoursWorked;
}
