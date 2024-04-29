package bg.tuvarna.sit.taskmanager.repository.impl;

import bg.tuvarna.sit.taskmanager.domain_models.Task;
import bg.tuvarna.sit.taskmanager.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {
  private List<Task> taskList;
  private static TaskRepositoryImpl taskRepositoryInstance = null;
  private static Long id;

  private TaskRepositoryImpl()
  {
    taskList = new ArrayList<>();
    id = 0L;
  }

  public static TaskRepositoryImpl getInstance()
  {
    if(taskRepositoryInstance == null)
      taskRepositoryInstance = new TaskRepositoryImpl();

    return taskRepositoryInstance;
  }

  @Override
  public boolean createTask(Task task) {
      task.setId(id++);
      return taskList.add(task);
  }

  @Override
  public Task getTaskById(int id) {

    Task result = null;
    for(var currentTask : taskList)
    {
      if(currentTask.getId() == id)
      {
        result = currentTask;
      }
    }
    return result;
  }

  @Override
  public boolean updateTask(Task task) {

    for(int index = 0; index < taskList.size(); index++)
    {
      Task currentTask = taskList.get(index);
      if(currentTask.getId() == task.getId())
      {
        currentTask = task;
        return true;
      }
    }
    return  false;
  }

  @Override
  public List<Task> getAllTasks() {
    return taskList;
  }

  @Override
  public boolean deleteTaskById(int id) {
    return taskList.removeIf(t -> t.getId() == id);
  }
}
