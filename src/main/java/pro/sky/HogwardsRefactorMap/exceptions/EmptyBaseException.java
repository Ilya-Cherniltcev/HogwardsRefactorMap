package pro.sky.HogwardsRefactorMap.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyBaseException extends RuntimeException{
    public EmptyBaseException(String alert) {
    }
}
