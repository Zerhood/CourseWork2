package SkyPro.service;

import SkyPro.dto.Question;
import SkyPro.exceptions.LargeNumberOfQuestionsException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    List<QuestionService> serviceList;

    public ExaminerServiceImpl(List<QuestionService> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        JavaQuestionService java = (JavaQuestionService) serviceList.stream()
                .filter(s -> s instanceof JavaQuestionService)
                .findFirst()
                .get();
        MathQuestionService math = (MathQuestionService) serviceList.stream()
                .filter(s -> s instanceof MathQuestionService)
                .findFirst()
                .get();

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