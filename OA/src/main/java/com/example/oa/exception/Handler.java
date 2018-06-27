package com.example.oa.exception;

import com.example.oa.util.Result;
import com.example.oa.util.ResultUtil;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class Handler {

    @ExceptionHandler(ParameterNotValidException.class)
    @ResponseBody
    public ResponseEntity parameterError(ParameterNotValidException e) {
        return new ResponseEntity<Result>(
                ResultUtil.error(e.getMessage(), 422),
                HttpStatus.UNPROCESSABLE_ENTITY
        );
    }

    @ExceptionHandler(RecordAlreadyExistsException.class)
    public Object recordExists(RecordAlreadyExistsException e, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        if ("XMLHttpRequest" == request.getHeader("X-Requested-With")) {

            return new ResponseEntity<Result>(
                    ResultUtil.error(e.getMessage(), 422),
                    HttpStatus.UNPROCESSABLE_ENTITY
            );
        }
        redirectAttributes.addFlashAttribute("error", e.getMessage());
        return "redirect:" + e.getRedirect();
    }

    @ExceptionHandler(RecordNotExistsException.class)
    public Object recordNotExists(RecordNotExistsException e, HttpServletRequest request) {
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            return new ResponseEntity<Result>(
                    ResultUtil.error(e.getMessage(), 404),
                    HttpStatus.NOT_FOUND
            );
        }

        return "redirect:" + e.getRedirect();
    }

    @ExceptionHandler(InvalidFormatException.class)
    @ResponseBody
    public ResponseEntity recordNotExists(InvalidFormatException e) {
        return new ResponseEntity<Result>(
                ResultUtil.error("请求错误。", 403),
                HttpStatus.FORBIDDEN
        );
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public ResponseEntity type(MethodArgumentTypeMismatchException e) {

        return new ResponseEntity<Result>(
                ResultUtil.error("请求错误。", 403),
                HttpStatus.FORBIDDEN
        );
    }

    @ExceptionHandler(HasException.class)
    @ResponseBody
    public ResponseEntity staff(HasException e) {
        return new ResponseEntity<Result>(
                ResultUtil.error(e.getMessage(), e.getCode()),
                e.getHttpStatus()
        );
    }
}
