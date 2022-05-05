package com.kgisl.ws.repository;

import com.kgisl.ws.entity.TaskDemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TaskDemoRepository extends JpaRepository<TaskDemo, Long> {

}
