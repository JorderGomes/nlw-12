package com.jorder.certifications.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jorder.certifications.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    
    public Optional<Student> findByEmail(String email);

}
