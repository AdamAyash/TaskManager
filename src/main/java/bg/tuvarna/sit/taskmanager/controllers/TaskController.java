package bg.tuvarna.sit.taskmanager.controllers;

import bg.tuvarna.sit.taskmanager.models.Task;
import bg.tuvarna.sit.taskmanager.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
  private TaskService taskService;

  public TaskController(TaskService taskService){
    this.taskService = taskService;
  }

  @PostMapping("/api/tasks")
  public ResponseEntity<Task> createTask(@RequestBody Task task){
    ResponseEntity<Task> response;

    if(!taskService.createTask(task))
      response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    return  new ResponseEntity<>(task, HttpStatus.CREATED);
  }

  @GetMapping("/api/task/{id}")
  public ResponseEntity<Task> getTask(@PathVariable int id){
    ResponseEntity<Task> response;

    Task task =  taskService.getTaskById(id);
    if(task == null)
      response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

    return new ResponseEntity<>(task, HttpStatus.OK);
  }

  @GetMapping("/api/task/all}")
  public ResponseEntity<List<Task>> getAllTasks(){
    ResponseEntity<Task> response;

    return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
  }
}
