package com.example.TpTaller.list.model;

import com.example.TpTaller.task.model.Task;
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
@Table(name = "list")
public class TODOList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listId;
    private String name;
    private LocalDateTime creationDate;
    private boolean completed;
    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL)
    private List<Task> taskList;
}
