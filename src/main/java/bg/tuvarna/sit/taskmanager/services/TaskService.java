package bg.tuvarna.sit.taskmanager.services;
import bg.tuvarna.sit.taskmanager.models.Task;
import bg.tuvarna.sit.taskmanager.dto.TaskDto;

import java.util.List;

public interface TaskService {
  Task createTask(final TaskDto task);
  TaskDto getTaskById(final int id);
  boolean updateTask(final Task task);
  boolean deleteTaskById(final int id);
  List<TaskDto> getAllTasks();

}
