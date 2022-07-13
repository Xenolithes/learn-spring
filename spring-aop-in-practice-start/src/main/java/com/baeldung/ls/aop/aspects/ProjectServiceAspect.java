package com.baeldung.ls.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProjectServiceAspect {

    private static Logger logger = LoggerFactory.getLogger(ProjectServiceAspect.class);

    @Before("execution(* com.baeldung.ls.service.impl.ProjectServiceImpl.findById(Long))")
    public void before(JoinPoint joinPoint){
        logger.info("Searching Project with Id {}", joinPoint.getArgs()[0]);
    }
}
