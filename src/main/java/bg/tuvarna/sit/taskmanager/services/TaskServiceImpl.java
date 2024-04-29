package bg.tuvarna.sit.taskmanager.services;

import bg.tuvarna.sit.taskmanager.dto.TaskDto;
import bg.tuvarna.sit.taskmanager.domain_models.Task;
import bg.tuvarna.sit.taskmanager.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

  private TaskRepository taskRepository;
  private ModelMapper modelMapper;

  public TaskServiceImpl(ModelMapper modelMapper, TaskRepository taskRepository)
  {
      this.taskRepository = taskRepository;
      this.modelMapper = modelMapper;
  }
  @Override
  public boolean createTask(TaskDto taskDto) {
      Task task = modelMapper.map(taskDto, Task.class);
        taskRepository.save(task);
        return true;
  }

    @Override
    public TaskDto getTaskById(Long id) {
        return modelMapper.map(taskRepository.findById(id), TaskDto.class);
    }

    @Override
    public boolean updateTask(Task task) {
        return true;
    }

    @Override
    public boolean deleteTaskById(Long id) {
      taskRepository.deleteById(id);

      return true;
    }

    @Override
    public List<TaskDto> getAllTasks() {
     List<Task> tasksList =  taskRepository.findAll();
     List<TaskDto> taskDtoList = new ArrayList<TaskDto>();

        for (Task currentTask : tasksList) {
            taskDtoList.add(modelMapper.map(currentTask, TaskDto.class));
        }
        return taskDtoList;
    }
}
