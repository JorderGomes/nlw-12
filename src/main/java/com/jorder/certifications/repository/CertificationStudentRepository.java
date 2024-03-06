package com.jorder.certifications.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jorder.certifications.models.CertificationsStudent;

@Repository
public interface CertificationStudentRepository extends JpaRepository<CertificationsStudent, UUID> {
    
    @Query("SELECT c FROM certifications c INNER JOIN c.student std WHERE std.email = :email AND c.technology = :technology")
    List<CertificationsStudent> findByStudentEmailAndTechnology(String email, String technology);
    
    @Query("SELECT c FROM certifications c ORDER BY c.grade DESC LIMIT 10")
    List<CertificationsStudent> findTop10OrderByGradeDesc();

}
