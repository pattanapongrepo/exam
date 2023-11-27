package com.example.exam.repo;

import com.example.exam.entities.Tran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranRepository extends JpaRepository<Tran, Integer> {
}
