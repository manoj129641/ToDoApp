package com.hcbs.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcbs.demo.dao.TaskRepository;
import com.hcbs.demo.model.Task;

@RestController
@RequestMapping(path = "/tasks")
public class ToDoController
{
    @Autowired
    private Task task;
    
    @Autowired
    TaskRepository repository;

    @PostMapping("/create")
    @ResponseBody
    public String create(@RequestBody Task emp){

    repository.save(emp);

    return "Task is created";

    }

    @GetMapping("/findall")

    public List<Task> findAll(){

    return repository.findAll();

    }

    @PutMapping("/update")
    public String search(@RequestBody Task task){

    repository.save(task);

    return "Task updated";
    }

    @GetMapping("/searchbyId/{id}")
    public Optional<Task> fetchDataById(@PathVariable Long id){

    	return repository.findById(id);
}

    
    
    	
    
    

    
}