package com.crudOperation.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudOperation.example.entity.Subject;
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
