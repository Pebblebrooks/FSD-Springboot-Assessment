package org.generation.todolist.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.generation.todolist.controller.dto.TaskDTO;

import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Date date;

    public Task() {
    }

    public Task(TaskDTO taskDTO) {

        this.title = taskDTO.getTitle();
        this.description = taskDTO.getDescription();
        this.date = taskDTO.getDate();
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "Task{" +
                "id=" + id +
                ", title='" + title
                + ", description=" + description
                + ", date=" + date + '\''
                + '}';
    }

















}
