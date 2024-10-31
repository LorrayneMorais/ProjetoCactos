package br.com.projeto.cactoplan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.cactoplan.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(String status);
}

