package com.jorder.certifications.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorder.certifications.dto.QuestionAndAnswerDto;
import com.jorder.certifications.dto.StudentCertificationAnswerDto;
import com.jorder.certifications.dto.VerifyHasCertificationDTO;
import com.jorder.certifications.models.AnswersCertification;
import com.jorder.certifications.models.CertificationsStudent;
import com.jorder.certifications.models.Question;
import com.jorder.certifications.models.Student;
import com.jorder.certifications.repository.CertificationStudentRepository;
import com.jorder.certifications.repository.QuestionRepository;
import com.jorder.certifications.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    CertificationStudentRepository certificationStudentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    QuestionRepository questionRepository;

    public boolean verifyIfHasCertification(VerifyHasCertificationDTO dto) {
        var result = certificationStudentRepository
                .findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
        if (!result.isEmpty()) {
            return true;
        }
        return false;
    }

    public CertificationsStudent studentCertificationAnswers(StudentCertificationAnswerDto dto) {

        // Buscar as alternativas das perguntas
        List<Question> questions = questionRepository.findByTechnology(dto.getTechnology());
        List<AnswersCertification> answersCertifications = new ArrayList<>();

        int grade = 0;
        int qtdTotalQuestions = dto.getQuestionAndAnswers().size();
        AtomicInteger qtdCorrects = new AtomicInteger(0);

        dto.getQuestionAndAnswers()
                .stream().forEach(questionAnswer -> {
                    var currentQuestion = questions.stream()
                            .filter(question -> question.getId().toString().equals(questionAnswer.getQuestionId()))
                            .findFirst().get();

                    var correctAlternative = currentQuestion.getAlternatives().stream()
                            .filter(alternative -> alternative.isCorrect())
                            .findFirst().get();

                    if (correctAlternative.getId().toString().equals(questionAnswer.getAlternativeId())) {
                        questionAnswer.setCorrect(true);
                        qtdCorrects.incrementAndGet();
                    } else {
                        questionAnswer.setCorrect(false);
                    }

                    var answerCertification = AnswersCertification.builder()
                    .answerID(UUID.fromString(questionAnswer.getAlternativeId()))
                    .questionID(UUID.fromString(questionAnswer.getQuestionId()))
                    .isCorrect(questionAnswer.isCorrect())
                    .build();
                    answersCertifications.add(answerCertification);

                });

        // Verificar se usuário existe
        var optStudent = studentRepository.findByEmail(dto.getEmail());
        UUID studentId;
        if (optStudent.isEmpty()) {
            var studentCreated = Student.builder().email(dto.getEmail()).build();
            studentCreated = studentRepository.save(studentCreated);
            studentId = studentCreated.getId();
            // todo: change to throw new Exception("E-mail do estudante incorreto.");
        } else {
            studentId = optStudent.get().getId();
        }

        //int grade = this.calculateGrade(dto.getQuestionAndAnswers());
        grade = (qtdCorrects.get() * 10) / qtdTotalQuestions;

        // Salvar as informações da certificação
        CertificationsStudent certificationsStudent = CertificationsStudent.builder()
                .technology(dto.getTechnology())
                .studentID(studentId)
                .grade(grade)
                .build();

        var certificationsStudentCreated = certificationStudentRepository.save(certificationsStudent);
        
        answersCertifications.stream().forEach(answersCertification -> {
            answersCertification.setCertificationID(certificationsStudent.getId());
            answersCertification.setCertificationStudent(certificationsStudent);
        });

        certificationsStudent.setAnswersCertifications(answersCertifications);

        certificationStudentRepository.save(certificationsStudent);
        
        return certificationsStudentCreated;
    }

    public int calculateGrade(List<QuestionAndAnswerDto> questionAndAnswers) {
        int result = 0;
        int qtdTotalQuestions = questionAndAnswers.size();
        int qtdCorrects = 0;

        for (QuestionAndAnswerDto question : questionAndAnswers) {
            if (question.isCorrect()) {
                qtdCorrects++;
            }
        }

        result = (qtdCorrects * 10) / qtdTotalQuestions;

        return result;
    }

}
