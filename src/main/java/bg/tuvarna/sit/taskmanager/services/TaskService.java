package bg.tuvarna.sit.taskmanager.services;
import bg.tuvarna.sit.taskmanager.domain_models.Task;
import bg.tuvarna.sit.taskmanager.dto.TaskDto;

import java.util.List;

public interface TaskService {
  boolean createTask(final TaskDto task);
  TaskDto getTaskById(final Long id);
  boolean updateTask(final Task task);
  boolean deleteTaskById(final Long id);
  List<TaskDto> getAllTasks();
}
