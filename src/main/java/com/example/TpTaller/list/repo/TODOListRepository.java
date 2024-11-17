package com.example.TpTaller.list.repo;

import com.example.TpTaller.list.model.TODOList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TODOListRepository extends JpaRepository<TODOList, Long> {
}
