package SkyPro.service;

import SkyPro.dto.Question;
import SkyPro.exceptions.MethodNotAllowedException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service("mathQuestionService")
public class MathQuestionService implements QuestionService {

    public Question add(String q, String a) {
        throw new MethodNotAllowedException("Метода не существует!");
    }

    public Question add(Question question) {
        throw new MethodNotAllowedException("Метода не существует!");
    }

    public Question remove(Question question) {
        throw new MethodNotAllowedException("Метода не существует!");
    }

    public Collection<Question> getAll() {
        throw new MethodNotAllowedException("Метода не существует!");
    }

    public Question getRandomQuestion() {
        int i = new Random().nextInt();
        return new Question("mathQuestion" + i, "mathAnswer" + i);
    }
}