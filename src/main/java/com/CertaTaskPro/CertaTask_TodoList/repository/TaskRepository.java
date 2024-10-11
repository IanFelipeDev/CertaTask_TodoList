package com.CertaTaskPro.CertaTask_TodoList.repository;
import com.CertaTaskPro.CertaTask_TodoList.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}