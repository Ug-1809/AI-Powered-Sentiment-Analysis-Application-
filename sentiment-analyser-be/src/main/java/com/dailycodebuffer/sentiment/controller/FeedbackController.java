package com.dailycodebuffer.sentiment.controller;

import com.dailycodebuffer.sentiment.repository.FeedbackRepository;
import com.dailycodebuffer.sentiment.service.SentimentAnalysisService;
import com.dailycodebuffer.sentiment.entity.Feedback;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "http://localhost:5173/")
public class FeedbackController {

    private final FeedbackRepository feedbackRepository;
    private final SentimentAnalysisService service;

    public FeedbackController(FeedbackRepository feedbackRepository,SentimentAnalysisService service){
    this.feedbackRepository = feedbackRepository;
    this.service = service;
    }

    @GetMapping
    public List<Feedback> getAllFeedback(){
        return feedbackRepository.findAll();
    }

    @PostMapping
    public Feedback saveFeedback(@RequestBody String content)
    {
        Feedback feedback = service.analyseFeedback(content);
        //here create service which will take content and check the feeback
        return feedbackRepository.save(feedback);
    }

}