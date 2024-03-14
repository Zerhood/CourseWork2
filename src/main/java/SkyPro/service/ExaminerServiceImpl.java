package SkyPro.service;

import SkyPro.dto.Question;
import SkyPro.exceptions.LargeNumberOfQuestionsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    @Autowired
    private ApplicationContext context;
    public ExaminerServiceImpl() {
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        JavaQuestionService java = context.getBean(JavaQuestionService.class);
        MathQuestionService math = new MathQuestionService();
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