package net.homecredit.oauth2.test.restsp.advice;

import net.homecredit.oauth2.test.restsp.exception.UserNotFoundException;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 *
 * @author Pavel.Botos
 */
@ControllerAdvice
public class BookmarkControllerAdvice {
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public VndErrors userNotFoundExceptionHandler(UserNotFoundException ex){
        return new VndErrors("error", ex.getMessage());
    }
}
