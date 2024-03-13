package SkyPro.service;

import SkyPro.dto.Question;
import SkyPro.repository.JavaQuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@DisplayName("Тест запросов по работе с коллекцией вопросов")
public class JavaQuestionServiceTest {
    private JavaQuestionRepository repository;
    private JavaQuestionService service;

    @BeforeEach
    void prepare() {
        this.repository = mock(JavaQuestionRepository.class);
        this.service = new JavaQuestionService(repository);
    }

    @Test
    @DisplayName("добавляем по вопросу и ответу")
    public void testAdd() {
        String q = "question";
        String a = "answer";
        Question actual = new Question(q, a);
        doReturn(actual).when(repository).add(actual);

        Question expected = service.add(q, a);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("добавляем по объекту вопрос-ответа")
    public void testAddQuestionObject() {
        Question actual = new Question();
        doReturn(actual).when(repository).add(actual);

        Question expected = service.add(actual);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("удаляем по объекту вопрос-ответа")
    public void testRemove() {
        Question actual = new Question();
        doReturn(actual).when(repository).remove(actual);

        Question expected = service.remove(actual);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("получаем всю коллекцию вопросов")
    public void testGetAll() {
        Set<Question> actual = new HashSet<>(Set.of(
                new Question("1", "1"),
                new Question("2", "2")
        ));
        doReturn(actual).when(repository).getAll();

        Collection<Question> expected = service.getAll();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("получаем случайный вопрос")
    public void testGetRandomQuestion() {
        Question q = new Question();
        Collection<Question> set = new HashSet<>(Set.of(q));
        doReturn(set).when(repository).getAll();
        Question actual = set.stream().findFirst().orElse(null);
        Question expected = service.getRandomQuestion();
        assertEquals(expected, actual);
    }
}