package br.com.projeto.cactoplan.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.cactoplan.entities.Task;
import br.com.projeto.cactoplan.repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTaskStatus(Long id, String status) {
        Task task = taskRepository.findById(id)
            .orElseThrow();
        task.setStatus(status);
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }
}
