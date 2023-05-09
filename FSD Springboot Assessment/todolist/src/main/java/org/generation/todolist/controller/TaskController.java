package org.generation.todolist.controller;

import org.generation.todolist.controller.dto.TaskDTO;
import org.generation.todolist.repository.entity.Task;
import org.generation.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService) {
        this.taskService = taskService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Task> getTask() {
        return taskService.all();
    }

    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="title", required = true) String title,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="date", required = true) Date date)
            throws IOException {

        TaskDTO taskDTO = new TaskDTO(title, description, date);
        Task task = new Task(taskDTO);
        taskService.save(task);
    }


}






