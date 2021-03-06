package com.aop.demo;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
/**
 * 定义切面
 * @author maskwang
 *2017年6月18日
 */
@Aspect
@Component
public class LogAspect {
	@Pointcut("@annotation(com.aop.demo.Action)")
	public void annotationPointCut(){};
	@After("annotationPointCut()")
	public void after(JoinPoint joinPoint){
		MethodSignature signature=(MethodSignature) joinPoint.getSignature();
		Method method=signature.getMethod();
		Action action=method.getDeclaredAnnotation(Action.class);
		System.out.println("注解是拦截"+action.name());
	}
	//Aspectj的表达式，表示DemoMethodService任何方法执行时候
	@Before("execution(* com.aop.demo.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
		MethodSignature signature=(MethodSignature) joinPoint.getSignature();
		Method method=signature.getMethod();
		System.out.println("方法规则式拦截"+method.getName());
	}
}
