package bg.tuvarna.sit.taskmanager.repository;

import bg.tuvarna.sit.taskmanager.domain_models.Report;
import bg.tuvarna.sit.taskmanager.domain_models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
