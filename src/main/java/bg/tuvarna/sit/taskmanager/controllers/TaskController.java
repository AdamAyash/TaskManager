package bg.tuvarna.sit.taskmanager.controllers;

import bg.tuvarna.sit.taskmanager.models;
import bg.tuvarna.sit.taskmanager.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
  private final TaskService taskService;

  public TaskController(TaskService taskService){
    this.taskService = taskService;
  }

  @PostMapping("/api/tasks")
  public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto task){
    ResponseEntity<TaskDto> response;

    if(!taskService.createTask(task))
      response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    else
      response = new ResponseEntity<>(task, HttpStatus.CREATED);

    return response;
  }

  @GetMapping("/api/task/{id}")
  public ResponseEntity<TaskDto> getTask(@PathVariable int id){
    ResponseEntity<TaskDto> response;

    TaskDto task =  taskService.getTaskById(id);
    if(task == null)
      response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
    else{
      response = new ResponseEntity<>(task, HttpStatus.OK);
    }

    return response;
  }

  @GetMapping("/api/task/all")
  public ResponseEntity<List<TaskDto>> getAllTasks(){
    return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
  }
}
