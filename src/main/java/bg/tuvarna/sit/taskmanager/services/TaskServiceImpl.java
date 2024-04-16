package bg.tuvarna.sit.taskmanager.services;

import bg.tuvarna.sit.taskmanager.models.Task;
import bg.tuvarna.sit.taskmanager.repository.TaskRepository;
import bg.tuvarna.sit.taskmanager.repository.impl.TaskRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
  private TaskRepository taskRepository;

  public TaskServiceImpl()
  {
      this.taskRepository = TaskRepositoryImpl.getInstance();
  }
  @Override
  public boolean createTask(Task task) {
     return taskRepository.createTask(task);
  }

    @Override
    public Task getTaskById(int id) {
        return taskRepository.getTaskById(id);
    }

    @Override
    public boolean updateTask(Task task) {
        return taskRepository.updateTask(task);
    }

    @Override
    public boolean deleteTaskById(int id) {
        return taskRepository.deleteTaskById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }
}
