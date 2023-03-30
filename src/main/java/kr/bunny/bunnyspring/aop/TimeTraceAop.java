package kr.bunny.bunnyspring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    /**Kr.buuny.bunnyspring 하위 모든 곳에서 aop 동작하도록 */
    @Around("execution(* kr.bunny.bunnyspring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());

        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END = " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
