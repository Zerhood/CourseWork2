package SkyPro.service;

import SkyPro.dto.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service("mathQuestionService")
public class MathQuestionService implements QuestionService {

    public Question add(String q, String a) {
        return null;
    }

    public Question add(Question question) {
        return null;
    }

    public Question remove(Question question) {
        return null;
    }

    public Collection<Question> getAll() {
        return null;
    }

    public Question getRandomQuestion() {
        int i = new Random().nextInt();
        return new Question("mathQuestion" + i, "mathAnswer" + i);
    }
}