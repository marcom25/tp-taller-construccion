package com.example.TpTaller.task.repo;

import com.example.TpTaller.list.model.TODOList;
import com.example.TpTaller.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
