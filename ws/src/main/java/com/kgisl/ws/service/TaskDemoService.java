package com.kgisl.ws.service;

import java.util.List;
import com.kgisl.ws.entity.TaskDemo;

public interface TaskDemoService {

    public List<TaskDemo> getTaskDemo();

    public TaskDemo findByTaskDemoId(Long id);

    public TaskDemo createTaskDemo(TaskDemo taskDemo);

    public TaskDemo updateTaskDemo(Long id, TaskDemo taskDemo);

    // public TaskDemo deleteTaskDemo();

    public void deleteTaskDemoById(Long id);
}
