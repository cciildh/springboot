package main.java.com.example.exception;

/**
 * GlobHandler 全局参数异常捕获
 */
@ControllerAdvice // 实现全局异常处理
public class GlobHandler {
  // 捕获方法参数校验异常
  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseBody
  public JsonUtils constraintViolationExceptionHandler(ConstraintViolationException e){
      Set<ConstraintViolation<?>> message = e.getConstraintViolations();
      HashMap<String, Object> map = new HashMap<>();
      message.stream().forEach(msg -> {
          String path = msg.getPropertyPath().toString();
          String field = path.substring(path.indexOf(".")+1);
          map.put(field,msg.getMessageTemplate());
      });
      return  JsonUtils.errorMsg( JsonUtils.objectToJson(map));
  }

  // 捕获实体参数校验异常
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  public ResponseEntity resolveMethodArgumentNotValidException(MethodArgumentNotValidException e){
      List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
      HashMap<String, Object> map = new HashMap<>();
      allErrors.stream().forEach(error -> {
          FieldError fieldError = (FieldError) error;
          map.put(fieldError.getField(), fieldError.getDefaultMessage());
      });
      return ResponseEntity.ok(map);
  }
}