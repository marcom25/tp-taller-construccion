package com.example.TpTaller.repo;

import com.example.TpTaller.model.TODOList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TODOListRepository extends JpaRepository<TODOList, Long> {
}
