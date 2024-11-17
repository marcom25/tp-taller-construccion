package com.example.TpTaller.task.model;

import com.example.TpTaller.list.model.TODOList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String name;
    private String description;
    private boolean completed;
    private LocalDateTime creationDate;
    @ManyToOne
    @JoinColumn(name = "list_id", nullable = false) // Relación con TODOList, columna de clave foránea
    private TODOList todoList;
}
