package SkyPro.controller;

import SkyPro.dto.Question;
import SkyPro.exceptions.MethodNotAllowedException;
import SkyPro.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    private QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam(value = "question", required = false) String question,
                                @RequestParam(value = "answer", required = false) String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam(value = "question", required = false) String question,
                                   @RequestParam(value = "answer", required = false) String answer) {
        return questionService.remove(new Question(question, answer));
    }
}