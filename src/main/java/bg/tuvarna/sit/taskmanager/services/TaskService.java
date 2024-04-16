package bg.tuvarna.sit.taskmanager.services;

import bg.tuvarna.sit.taskmanager.models.Task;

import java.util.List;

public interface TaskService {
  boolean createTask(final Task task);
  Task getTaskById(final int id);
  boolean updateTask(final Task task);
  boolean deleteTaskById(final int id);
  List<Task> getAllTasks();

}
