package com.jorder.certifications.models;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificationsStudent {

    private UUID id;
    private UUID studentId;
    private String technology;
    private int grate;
    private List<AnswersCertification> answersCertifications;

    

}
