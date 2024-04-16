package bg.tuvarna.sit.taskmanager.repository;

import bg.tuvarna.sit.taskmanager.models.Task;

import java.util.List;

public interface TaskRepository {
  boolean createTask(Task task);
  Task getTaskById(final int id);
  boolean updateTask(final Task task);
  List<Task> getAllTasks();
  boolean deleteTaskById(final int id);

}
