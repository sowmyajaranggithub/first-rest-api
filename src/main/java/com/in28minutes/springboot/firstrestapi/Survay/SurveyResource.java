package com.in28minutes.springboot.firstrestapi.Survay;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SurveyResource {
    private SurveyService serviceService;

    public SurveyResource(SurveyService serviceService) {
        super();
        this.serviceService = serviceService;
    }

    @RequestMapping("/surveys")
    public List<Survey> retrieveAllSurveys() {
        return serviceService.retrieveALLSurveys();
    }

    @RequestMapping("/surveys/{surveyID}")
    public Survey retrieveSurveyByID(@PathVariable String surveyID) {
        return serviceService.retrieveSurveyById(surveyID);
    }

    @RequestMapping("/surveys/{surveyId}/questions")
    public List<Question> retrieveAllSurveyQuestions(@PathVariable String surveyId) {
        List<Question> questions = SurveyService.retrieveAllSurveyQuestions(surveyId);
        //List<Question> questions;
        if (questions == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return questions;
    }

    @RequestMapping("/surveys/{surveyId}/questions/{questionId}")
    public Question retrieveSpecificSurveyQuestions(@PathVariable String surveyId,
                                                    @PathVariable String questionId) {
        Question questions = SurveyService.retrieveSpecificSurveyQuestion(surveyId, questionId);
        if (questions == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return questions;
    }

    @RequestMapping(value = "/surveys/{surveyId}/questions", method = RequestMethod.POST)
    public ResponseEntity<Object> addNewSurveyQuestions(@PathVariable String surveyId,
                                                     @RequestBody Question question) {
        String questionId = SurveyService.addNewSurveyQuestion(surveyId, question);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionId}").buildAndExpand
                (questionId).toUri();
        return ResponseEntity.created(location).build();

    }
    @RequestMapping(value="/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSurveyQuestions(@PathVariable String surveyId,
                                                        @PathVariable String questionId) {
         SurveyService.deleteSurveyQuestion(surveyId, questionId);
        return ResponseEntity.noContent().build();
    }
    @RequestMapping(value="/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSurveyQuestion(@PathVariable String surveyId,
                                                        @PathVariable String questionId,
                                                        @RequestBody Question question) {
        SurveyService.updateSurveyQuestion(surveyId, questionId, question);
        return ResponseEntity.noContent().build();
    }
}
