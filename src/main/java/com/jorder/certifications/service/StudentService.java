package com.jorder.certifications.service;

import org.springframework.stereotype.Service;

import com.jorder.certifications.dto.VerifyHasCertificationDTO;

@Service
public class StudentService {
    
    public boolean verifyIfHasCertification(VerifyHasCertificationDTO dto) {
        if (dto.getEmail().equals("ruan@redmail.com") && dto.getTechnology().equals("ruby")){
            return true;
        }
        return false;
    }

}
