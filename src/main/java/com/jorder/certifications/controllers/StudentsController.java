package com.jorder.certifications.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorder.certifications.dto.StudentCertificationAnswerDto;
import com.jorder.certifications.dto.VerifyHasCertificationDTO;
import com.jorder.certifications.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/students")
public class StudentsController {
    
    @Autowired
    StudentService studentService;


    
    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyIfHasCertification) {
        var result = studentService.verifyIfHasCertification(verifyIfHasCertification);
        if (result){
            return "Usuário já fez a prova.";
        }
        return "Usuário pode fazer a prova.";
    }

    @PostMapping("/certification/answer")
    public StudentCertificationAnswerDto certificationAnswer(@RequestBody StudentCertificationAnswerDto dto) {
        return studentService.studentCertificationAnswers(dto);
    }
    
    
    
}
