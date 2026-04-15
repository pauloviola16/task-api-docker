package com.example.task_api.service;

import com.example.task_api.model.Task;
import com.example.task_api.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task create(Task task) {
        return repository.save(task);
    }

    public Task markDone(Long id) {
        Task task = repository.findById(id).orElseThrow();
        task.setDone(true);
        return repository.save(task);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}