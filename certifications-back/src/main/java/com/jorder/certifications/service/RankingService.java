package com.jorder.certifications.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorder.certifications.models.CertificationsStudent;
import com.jorder.certifications.repository.CertificationStudentRepository;

@Service
public class RankingService {
    
    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    public List<CertificationsStudent> execute() {
        return this.certificationStudentRepository.findTop10OrderByGradeDesc();
    }

}
