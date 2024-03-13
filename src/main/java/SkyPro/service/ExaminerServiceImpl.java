package SkyPro.service;

import SkyPro.dto.Question;
import SkyPro.exceptions.LargeNumberOfQuestionsException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private QuestionService math;

    private QuestionService java;

    public ExaminerServiceImpl(@Qualifier("mathQuestionService") QuestionService math,
                               @Qualifier("javaQuestionService") QuestionService java) {
        this.math = math;
        this.java = java;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if (java.getAll().size() < amount) {
            throw new LargeNumberOfQuestionsException("Количество вопросов меньше!");
        }
        while (questions.size() <= amount) {
            questions.add(new Random().nextBoolean() ? java.getRandomQuestion() : math.getRandomQuestion());
        }
        return questions;
    }
}