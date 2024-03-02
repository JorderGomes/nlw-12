package com.jorder.certifications.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorder.certifications.dto.VerifyHasCertificationDTO;
import com.jorder.certifications.repository.CertificationStudentRepository;

@Service
public class StudentService {
    
    @Autowired
    CertificationStudentRepository certificationStudentRepository;

    public boolean verifyIfHasCertification(VerifyHasCertificationDTO dto) {
        var result = certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
        if (!result.isEmpty()){
            return true;
        }
        return false;
    }

}
