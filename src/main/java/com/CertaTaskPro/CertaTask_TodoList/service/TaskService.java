package com.CertaTaskPro.CertaTask_TodoList.service;

import com.CertaTaskPro.CertaTask_TodoList.entity.Task;
import com.CertaTaskPro.CertaTask_TodoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }
}