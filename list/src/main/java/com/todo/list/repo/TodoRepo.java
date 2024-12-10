package com.todo.list.repo;

import com.todo.list.Todo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TodoRepo extends JpaRepository<Todo, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Todo t SET t.isDone = true WHERE t.id = :id")
    int updateIsDoneToTrue(Long id);
}
