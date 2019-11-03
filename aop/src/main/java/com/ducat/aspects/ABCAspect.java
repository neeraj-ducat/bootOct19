package com.ducat.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ABCAspect {

	//definition of pointcuts
	@Pointcut("execution(* com.ducat.beans.ABC.a(..))")
	public void pc1() {}
	
	@Pointcut("execution(* com.ducat.beans.ABC.b(..))")
	public void pc2() {}
	
	@Pointcut("execution(* com.ducat.beans.ABC.c(..))")
	public void pc3() {}
	
	//definition of advices
	@Before("pc1() || pc3()")
	public void preProcessing(JoinPoint jp)
	{
		System.out.println("Before advice is applied on "
				+jp.getSignature().getName());
	}
	
	@AfterThrowing(pointcut="pc3()",throwing="ex")
	public void errorProcessing(JoinPoint jp,Exception ex)
	{
		System.out.print("Throws advice is applied on "
				+jp.getSignature().getName());
		System.out.println(" because it threw "+ex);
	}
	/*@AfterReturning(pointcut="pc2()",returning="result")
	public void postProcessing(String result)
	{
		System.out.println(result+" is received in the after advice.");
		result="failure";
		System.out.println("After advice has changed the result to failure.");
	}*/
	
	
	@Around("pc2()")
	public String aroundProcessing(ProceedingJoinPoint pjp)
	{
	System.out.println("Around advice is invoked, invoking  "
	
		+pjp.getSignature().getName()+"()...");
	
	try
	{
	String result=(String)pjp.proceed();
	System.out.println(result+" is received in the advice.");
	}catch(Throwable t)
	{
		System.out.println(t);
	}
	System.out.println("Result is changed by the advice.");
	return "failure";
	}
}
