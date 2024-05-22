package bg.tuvarna.sit.taskmanager.domain_models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name="Report")
public class Report {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int taskId;
    private String content;
    private int hoursWorked;
    @CreationTimestamp
    private Instant dateCreated;
}
