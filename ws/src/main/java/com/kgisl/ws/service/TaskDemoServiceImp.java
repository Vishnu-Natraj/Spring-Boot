package com.kgisl.ws.service;

import java.util.List;

// import javax.persistence.Id;
import javax.transaction.Transactional;
import com.kgisl.ws.entity.TaskDemo;
import com.kgisl.ws.repository.TaskDemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class TaskDemoServiceImp implements TaskDemoService {

    @Autowired
    public TaskDemoRepository taskDemoRepository;

    @Override
    public List<TaskDemo> getTaskDemo() {
        return taskDemoRepository.findAll();
    }

    @Override
    public TaskDemo findByTaskDemoId(Long id) {

        taskDemoRepository.findById(id);
        return taskDemoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
    }

    @Override
    public TaskDemo createTaskDemo(TaskDemo taskDemo) {
        return taskDemoRepository.save(taskDemo);
    }

    @Override
    public TaskDemo updateTaskDemo(Long id, TaskDemo taskDemo) {
        TaskDemo s = taskDemoRepository.getById(id);
        s.setContent(taskDemo.getContent());
        taskDemoRepository.save(taskDemo);
        return taskDemoRepository.save(taskDemo);
    }

    @Override
    public void deleteTaskDemoById(Long id) {
        taskDemoRepository.deleteById(id);
    }

}
