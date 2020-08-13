package com.example.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.example.utils.JsonUtils;
import com.example.utils.ResponseMesg;

// import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * GlobValidation 全局参数异常捕获
 */
@ControllerAdvice // 实现全局异常处理
public class GlobValidation {
  // 捕获方法参数校验异常
  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseBody
  public ResponseMesg constraintViolationExceptionHandler(ConstraintViolationException e){
      Set<ConstraintViolation<?>> message = e.getConstraintViolations();
      HashMap<String, Object> map = new HashMap<>();
      message.stream().forEach(msg -> {
          String path = msg.getPropertyPath().toString();
          String field = path.substring(path.indexOf(".")+1);
          map.put(field,msg.getMessageTemplate());
      });
      return  ResponseMesg.errorMsg(JsonUtils.objectToJson(map));
  }

  // 捕获实体参数校验异常
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  public ResponseMesg resolveMethodArgumentNotValidException(MethodArgumentNotValidException e){
      List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
      HashMap<String, Object> map = new HashMap<>();
      allErrors.stream().forEach(error -> {
          FieldError fieldError = (FieldError) error;
          map.put(fieldError.getField(), fieldError.getDefaultMessage());
      });
      return ResponseMesg.errorMsg(JsonUtils.objectToJson(map));
  }


//   // 捕获方法参数校验异常
//   @ExceptionHandler(ConstraintViolationException.class)
//   @ResponseBody
//   public ResponseEntity constraintViolationExceptionHandler(ConstraintViolationException e){
//       Set<ConstraintViolation<?>> message = e.getConstraintViolations();
//       HashMap<String, Object> map = new HashMap<>();
//       message.stream().forEach(msg -> {
//           String path = msg.getPropertyPath().toString();
//           String field = path.substring(path.indexOf(".")+1);
//           map.put(field,msg.getMessageTemplate());
//       });
//       return  ResponseEntity.ok(map);
//   }

//   // 捕获实体参数校验异常
//   @ExceptionHandler(MethodArgumentNotValidException.class)
//   @ResponseBody
//   public ResponseEntity resolveMethodArgumentNotValidException(MethodArgumentNotValidException e){
//       List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
//       HashMap<String, Object> map = new HashMap<>();
//       allErrors.stream().forEach(error -> {
//           FieldError fieldError = (FieldError) error;
//           map.put(fieldError.getField(), fieldError.getDefaultMessage());
//       });
//       return ResponseEntity.ok(map);
//   }
}