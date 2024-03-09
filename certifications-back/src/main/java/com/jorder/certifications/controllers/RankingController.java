package com.jorder.certifications.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jorder.certifications.models.CertificationsStudent;
import com.jorder.certifications.service.RankingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    private RankingService rankingService;

    @GetMapping("/top10")
    public List<CertificationsStudent> top10() {
        return this.rankingService.execute();
    }
    
    
    
    
    
    
}
