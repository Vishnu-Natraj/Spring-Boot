package com.kgisl.ws.controller;

import java.util.List;
import com.kgisl.ws.entity.TaskDemo;
import com.kgisl.ws.repository.TaskDemoRepository;
import com.kgisl.ws.service.TaskDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RestController
@RequestMapping("/api/taskDemo")
public class TaskDemoController {

    @Autowired
    public TaskDemoService taskDemoService;

    @Autowired
    public TaskDemoRepository taskDemoRepository;

    @GetMapping("/Get")
    public @ResponseBody ResponseEntity<List<TaskDemo>> getAll() {
        return new ResponseEntity<>(taskDemoService.getTaskDemo(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDemo> getTaskDemoById(@PathVariable("id") Long id) {

        TaskDemo taskDemo = taskDemoService.findByTaskDemoId(id);
        if (taskDemo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(taskDemo, HttpStatus.OK);
    }

    @PostMapping(value = "/Post", headers = "Accept=application/json")
    public ResponseEntity<TaskDemo> createTaskDemo(@RequestBody TaskDemo taskDemo) {
        TaskDemo actualTaskDemo = taskDemoService.createTaskDemo(taskDemo);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(actualTaskDemo, headers, HttpStatus.CREATED);

    }

    @PutMapping(value = "/Put/{id}", headers = "Accept=application/json")
    public ResponseEntity<TaskDemo> updateTaskDemo(@PathVariable("id") long id, @RequestBody TaskDemo currentDemo) {
        TaskDemo taskDemo = taskDemoService.updateTaskDemo(id, currentDemo);
        return new ResponseEntity<>(taskDemo, HttpStatus.OK);
    }

    @DeleteMapping(value = "/Delete/{id}", headers = "Accept=application/json")
    public ResponseEntity<TaskDemo> deleteTaskDemo(@PathVariable("id") Long id) {
        TaskDemo taskDemo = taskDemoService.findByTaskDemoId(id);
        if (taskDemo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        taskDemoService.deleteTaskDemoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}