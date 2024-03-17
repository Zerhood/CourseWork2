package SkyPro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class LargeNumberOfQuestionsException extends RuntimeException {
    public LargeNumberOfQuestionsException(String message) {
        super(message);
    }
}