package org.generation.todolist.service;

import org.generation.todolist.repository.TaskRepository;
import org.generation.todolist.repository.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
@Service
public class TaskServiceMySQL implements TaskService{

    private final TaskRepository taskRepository;

    public TaskServiceMySQL(@Autowired TaskRepository taskRepository)
    {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task save(Task task)
    {
        return this.taskRepository.save(task);
    }

    @Override
    public ArrayList<Task>all()
    {
        ArrayList<Task> result= new ArrayList<>();
        taskRepository.findAll().forEach(result::add);
        return result;
    }


}
