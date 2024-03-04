package com.jorder.certifications.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorder.certifications.dto.AlternativesResultDto;
import com.jorder.certifications.dto.QuestionResultDto;
import com.jorder.certifications.models.Alternative;
import com.jorder.certifications.models.Question;
import com.jorder.certifications.repository.QuestionRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/questions")
public class QuestionController {
    
    @Autowired
    private QuestionRepository questionRepository;
    
    @GetMapping("/technology/{technology}")
    public List<QuestionResultDto> findByTechnology(@PathVariable String technology) {
        var result = questionRepository.findByTechnology(technology);
        var toMap = result.stream().map(question -> mapToQuestionDto(question))
        .collect(Collectors.toList());
        return toMap;
    }
    
    
    static QuestionResultDto mapToQuestionDto(Question question){
        List<AlternativesResultDto> mapAlternatives = question.getAlternatives()
        .stream().map(alternative -> mapAlternativesResultDto(alternative))
        .collect(Collectors.toList());

        return QuestionResultDto.builder()
            .id(question.getId())
            .technology(question.getTechnology())
            .description(question.getDescription())
            .alternativesResultDto(mapAlternatives)
            .build();
    }
      
    static AlternativesResultDto mapAlternativesResultDto(Alternative alternative){
        return AlternativesResultDto.builder()
        .id(alternative.getId())
            .description(alternative.getDescription())
            .build();
    }
    
    
}
