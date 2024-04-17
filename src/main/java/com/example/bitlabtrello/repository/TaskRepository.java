package com.example.bitlabtrello.repository;

import com.example.bitlabtrello.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long> {
    // Тут я должна по folderId находит все таски
    List<Tasks> findAllByFolderId(Long folderId);
}
