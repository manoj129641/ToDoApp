package com.hcbs.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcbs.demo.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}