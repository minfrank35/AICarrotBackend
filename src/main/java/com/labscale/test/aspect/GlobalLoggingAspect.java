package com.labscale.test.aspect;

import com.labscale.test.dto.req.APIRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class GlobalLoggingAspect {

    private static final String LOG_FILE_PATH = "C:\\Users\\user\\Desktop\\log\\error_log.txt"; //오류 로그 남기는 곳
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Pointcut("execution(* com.labscale.test.controller..*.*(..))")
    public void allControllerMethods() {}

    @Before("allControllerMethods()")
    public void checkApiSecretKey(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof APIRequest) { // APIRequest 객체가 첫 번째 인자일 때
            APIRequest<?> request = (APIRequest<?>) args[0];
            String apiSecretKey = request.getApiSecretKey();

            if (!isValidSecretKey(apiSecretKey)) {
                throw new SecurityException("Invalid API Secret Key");
            }
            System.out.println("Valid API Secret Key provided.");
        }
    }

    @Around("allControllerMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Method execution started at: " + startTime.format(DATE_TIME_FORMATTER));

        Object proceed;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            LocalDateTime errorTime = LocalDateTime.now();
            String errorMessage = "Error occurred at " + errorTime.format(DATE_TIME_FORMATTER) + ": " + throwable.getMessage();
            logErrorToFile(errorMessage);
            throw throwable;
        }

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Method execution ended at: " + endTime.format(DATE_TIME_FORMATTER));

        long duration = java.time.Duration.between(startTime, endTime).toMillis();
        System.out.println("Method execution time: " + duration + " milliseconds");

        return proceed;
    }

    private boolean isValidSecretKey(String secretKey) {
        // 여기에 Secret Key의 유효성을 검사하는 로직을 구현
        return "your_api_secret_key".equals(secretKey);  // 예시: 고정된 키와 비교
    }

    private void logErrorToFile(String errorMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
            writer.write(errorMessage);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}