package com.example.TpTaller.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private boolean completed;
    @ManyToOne
    @JoinColumn(name = "list_id", nullable = false) // Relación con TODOList, columna de clave foránea
    private TODOList todoList;
}
