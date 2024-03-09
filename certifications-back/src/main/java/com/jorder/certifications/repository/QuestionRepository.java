package com.jorder.certifications.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorder.certifications.models.Question;
import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, UUID> {
    
    List<Question> findByTechnology(String technology);

}
