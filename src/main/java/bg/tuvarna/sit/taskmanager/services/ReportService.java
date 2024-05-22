package bg.tuvarna.sit.taskmanager.services;

import bg.tuvarna.sit.taskmanager.domain_models.Report;
import bg.tuvarna.sit.taskmanager.dto.ReportDto;
import bg.tuvarna.sit.taskmanager.repository.ReportRepository;

public interface ReportService {
    public boolean addReport(final ReportDto report, final int taskId);
}
