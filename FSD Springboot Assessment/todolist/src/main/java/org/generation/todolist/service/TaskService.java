package org.generation.todolist.service;

import org.generation.todolist.repository.entity.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface TaskService {


    //save method is for 2 purposes - Create new customer & Update existing customer
    Task save(Task task);

    //Read all customer from database
    ArrayList<Task> all();


}
