package br.com.projeto.cactoplan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.cactoplan.entities.Task;
import br.com.projeto.cactoplan.services.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/tasks")
@Api(value = "Task Management System")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    @ApiOperation(value = "Retrieve all tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    @ApiOperation(value = "Create a new task")
    public Task createTask(@ApiParam(value = "Task object to be created") @RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}/status")
    @ApiOperation(value = "Update the status of a task")
    public Task updateTaskStatus(
            @ApiParam(value = "ID of the task to update", required = true) @PathVariable Long id,
            @ApiParam(value = "New status for the task", required = true) @RequestParam String status) {
        return taskService.updateTaskStatus(id, status);
    }
}
