//package com.penguins.common.exception;
//
//import com.penguins.common.Result;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.TypeMismatchException;
//import org.springframework.dao.DuplicateKeyException;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.FieldError;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.MissingServletRequestParameterException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.io.IOException;
//import java.net.SocketTimeoutException;
//import java.sql.SQLException;
//import java.util.List;
//
///**
// * 全局统一异常处理
// *
// * @author 郑冰
// * @email mydreambing@126.com
// * @since jdk8
// **/
//
//@Slf4j
//@Component
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    /**
//     * 系统自定义异常
//     *
//     * @param e PenguinsException
//     * @return Result<Object>
//     */
//    @ExceptionHandler(value = PenguinsException.class)
//    public Result<Object> handle(PenguinsException e) {
//        e.printStackTrace();
//        return Result.fail(e.getMessage());
//    }
//
//    /**
//     * 空指针异常
//     *
//     * @param e NullPointerException
//     * @return Result<Object>
//     */
//    @ExceptionHandler(value = NullPointerException.class)
//    public Result<Object> handle(NullPointerException e) {
//        e.printStackTrace();
//        return Result.fail("【 PENGUINS 系统内部错误！】");
//    }
//
//    /**
//     * 400错误
//     *
//     * @param ex HttpMessageNotReadableException
//     * @return Result<Object>
//     */
//    @ExceptionHandler({HttpMessageNotReadableException.class})
//    public Result<Object> requestNotReadable(HttpMessageNotReadableException ex) {
//        ex.printStackTrace();
//        return Result.fail(ex.getMessage());
//    }
//
//    /**
//     * 400错误
//     *
//     * @param ex TypeMismatchException
//     * @return Result<Object>
//     */
//    @ExceptionHandler({TypeMismatchException.class})
//    public Result<Object> requestTypeMismatch(TypeMismatchException ex) {
//        ex.printStackTrace();
//        return Result.fail(ex.getMessage());
//    }
//
//    /**
//     * 400错误
//     *
//     * @param ex MissingServletRequestParameterException
//     * @return Result<Object>
//     */
//    @ExceptionHandler({MissingServletRequestParameterException.class})
//    public Result<Object> requestMissingServletRequest(
//            MissingServletRequestParameterException ex) {
//        ex.printStackTrace();
//        return Result.fail(ex.getMessage());
//    }
//
//    /**
//     * IO异常
//     *
//     * @param ex IOException
//     * @return Result<Object>
//     */
//    @ExceptionHandler(IOException.class)
//    public Result<Object> iOExceptionHandler(IOException ex) {
//        ex.printStackTrace();
//        return Result.fail(ex.getMessage());
//    }
//
//    /**
//     * 405错误
//     *
//     * @param ex HttpRequestMethodNotSupportedException
//     * @return Result<Object>
//     */
//    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
//    public Result<Object> request405(HttpRequestMethodNotSupportedException ex) {
//        ex.printStackTrace();
//        return Result.fail(ex.getMessage());
//    }
//
//    /**
//     * 超时异常
//     *
//     * @param ex SocketTimeoutException
//     * @return Result<Object>
//     */
//    @ExceptionHandler(SocketTimeoutException.class)
//    public Result<Object> socketTimeoutException(SocketTimeoutException ex) {
//        ex.printStackTrace();
//        return Result.fail(ex.getMessage());
//    }
//
//    /**
//     * 处理入参异常
//     *
//     * @param e MethodArgumentNotValidException
//     * @return Result<Object>
//     */
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public Result<Object> handleIllegalParamException(MethodArgumentNotValidException e) {
//        e.printStackTrace();
//        String message = "参数不合法";
//        List<FieldError> errors = e.getBindingResult().getFieldErrors();
//        if (errors.size() > 0) {
//            message = errors.get(0).getDefaultMessage();
//        }
//        return Result.fail(message);
//    }
//
//    /**
//     * 处理SQL异常
//     *
//     * @param e SQLException
//     * @return Result<Object>
//     */
//    @ExceptionHandler(value = SQLException.class)
//    public Result<Object> sqlException(SQLException e) {
//        e.printStackTrace();
//        return Result.fail(e.getMessage());
//    }
//
//    /**
//     * 处理key值重复异常
//     *
//     * @param e DuplicateKeyException
//     * @return Result<Object>
//     */
//    @ExceptionHandler(value = DuplicateKeyException.class)
//    public Result<Object> duplicateKeyException(DuplicateKeyException e) {
//        e.printStackTrace();
//        return Result.fail(e.getMessage());
//    }
//
//    /**
//     * 其他类型的运行时异常
//     *
//     * @param e RuntimeException
//     * @return Result<Object>
//     */
//    @ExceptionHandler(value = Exception.class)
//    public Result<Object> handle(Exception e) {
//        e.printStackTrace();
//        StackTraceElement element = e.getStackTrace()[0];
//        log.error(
//                "出现其他异常"
//                        + e.getClass().getSimpleName()
//                        + ",【"
//                        + e.getMessage()
//                        + "】"
//                        + "所属类："
//                        + element.getClassName()
//                        + "，所属方法："
//                        + element.getMethodName()
//                        + "，所在行号："
//                        + element.getLineNumber());
//        return Result.fail("【 PENGUINS 系统内部错误！】" + e.getMessage());
//    }
//}
//
