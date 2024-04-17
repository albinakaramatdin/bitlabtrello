package com.example.bitlabtrello.repository;

import com.example.bitlabtrello.model.TaskCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TaskCategoriesRepository extends JpaRepository<TaskCategories, Long> {
}
