package org.tsypanov.sb.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ServiceAspect {

  @Pointcut("execution(* org.tsypanov.sb.aspect.service.AspectedServiceImpl.getRandomLongWithAspect(..))")
  public void serviceMethod() {
  }

  @Around(value = "serviceMethod()", argNames = "pjp")
  public Object around(ProceedingJoinPoint pjp) throws Throwable {
    return pjp.proceed();
  }
}
