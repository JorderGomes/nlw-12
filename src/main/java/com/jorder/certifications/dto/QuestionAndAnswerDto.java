package com.jorder.certifications.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionAndAnswerDto {

    // todo: change String to UUID
    private String questionId;
    private String alternativeId;
    private boolean isCorrect;
    
}
