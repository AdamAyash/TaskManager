package bg.tuvarna.sit.taskmanager.services;

import bg.tuvarna.sit.taskmanager.dto.TaskDto;
import bg.tuvarna.sit.taskmanager.models.Task;
import bg.tuvarna.sit.taskmanager.repository.TaskRepository;
import bg.tuvarna.sit.taskmanager.repository.impl.TaskRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

  private TaskRepository taskRepository;
  private ModelMapper modelMapper;

  public TaskServiceImpl(ModelMapper modelMapper)
  {
      this.taskRepository = TaskRepositoryImpl.getInstance();
      this.modelMapper = modelMapper;
  }
  @Override
  public Task createTask(TaskDto taskDto) {
      Task task = modelMapper.map(taskDto, Task.class);
     return taskRepository.createTask(task);
  }

    @Override
    public TaskDto getTaskById(int id) {
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
    public List<TaskDto> getAllTasks() {
     List<Task> tasksList =  taskRepository.getAllTasks();
     List<TaskDto> taskDtoList = new ArrayList<TaskDto>();

        for (TaskDto currentTask : taskDtoList) {
            taskDtoList.add(modelMapper.map(currentTask, Task.class));
        }
        return taskDtoList;
    }
}
