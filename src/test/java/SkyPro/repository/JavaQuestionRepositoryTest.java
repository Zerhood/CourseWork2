package SkyPro.repository;

import SkyPro.dto.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@DisplayName("тест JavaQuestionRepository")
public class JavaQuestionRepositoryTest {
    private JavaQuestionRepository javaQuestionRepository;
    private QuestionRepository repository;

    @BeforeEach
    void prepare() {
        this.repository = mock(QuestionRepository.class);
        this.javaQuestionRepository = new JavaQuestionRepository();
    }

    @Test
    @DisplayName("добавляем объект")
    public void testAdd() {
        Question actual = new Question();
        doReturn(actual).when(repository).add(actual);

        Question expected = javaQuestionRepository.add(actual);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("удаляем объект")
    public void testRemove() {
        Question actual = new Question();
        doReturn(actual).when(repository).remove(actual);
        Question ex = javaQuestionRepository.remove(actual);
        assertEquals(ex, actual);
    }

    @Test
    @DisplayName("получаем всю коллекцию")
    public void testGetAll() {
        Question q = new Question();
        Collection<Question> actual = new HashSet<>(Set.of(q));
        doReturn(actual).when(repository).getAll();

        javaQuestionRepository.add(q);
        Collection<Question> all = javaQuestionRepository.getAll();
        assertEquals(all, actual);
    }
}