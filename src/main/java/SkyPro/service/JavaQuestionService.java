package SkyPro.service;

import SkyPro.dto.Question;
import SkyPro.repository.JavaQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("javaQuestionService")
public class JavaQuestionService implements QuestionService {

    private JavaQuestionRepository repository;

    public JavaQuestionService(JavaQuestionRepository repository) {
        this.repository = repository;
    }

    public Question add(String q, String a) {
        Question question = new Question(q, a);
        return repository.add(question);
    }

    public Question add(Question question) {
        return repository.add(question);
    }

    public Question remove(Question question) {
        return repository.remove(question);
    }

    public Collection<Question> getAll() {
        return repository.getAll();
    }

    public Question getRandomQuestion() {

        return repository.getAll().stream().findFirst().orElse(null);
    }
}