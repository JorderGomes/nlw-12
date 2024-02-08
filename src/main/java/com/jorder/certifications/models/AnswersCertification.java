package com.jorder.certifications.models;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswersCertification {

    private UUID id;
    private UUID certificationId;
    private UUID studentId;
    private UUID questionId;
    private UUID answerId;
    private boolean isCorrect; 

}
