package com.retro.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import lombok.extern.slf4j.Slf4j;

// 로그 수집 작업을 하려면 모든 매서드에 해야 함
// 로그 수집은 중요한 업무이지만 핵심적인 업무는 아니고
// 공통적인 업무에 해당됨.
// 공통적인 업무는 모든 class의 모든 method에 작성하지 말고
// Advice에 모아서 작성하고 세부적인 코드에서는 핵심업무를 집중 하도록 처리

@Component // 스프링 beans로 등록되기 위한 설정
@Aspect // AOP bean - 공통업무를 지원하는 코드 
@Slf4j
public class LogAdvice {
	// 포인트컷 - 실행시점.
	// Around(매서드 실행전후)
	// Before(매서드 실행전)
	// After(매서드 실행후)
	
	// execution 경로에 // 는 하위패키지들이 다 들어갈수 있다는 의미
	
	@Around("execution(* com.retro.controller..*Controller.*(..))"
			+ "or execution (* com.retro.service..*Impl.*(..))"
			+ "or execution (* com.retro.persistence..*Impl.*(..))") 
			
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
		// 메서드 시작시간  (before)
		long start = System.currentTimeMillis();
		
		//joinPoint.proceed(); 줄을 기준으로 
		// 위에가 호출전
		// 아래가 호출 후
		Object result = joinPoint.proceed(); // 핵심업무 실행
		
		String type = joinPoint.getSignature().getDeclaringTypeName();
		
		String name = "";
		// 호출한 클래스의 이름에 따라 if문을 타고 출력.
		if (type.indexOf("Controller") > -1) { 
			name = "controller \t:";
		}else if (type.indexOf("Service") > -1) {
			name = "ServiceImpl \t:";
		}else if (type.indexOf("DAO") > -1) {
			name = "DaoImpl \t:";
		}
		// 호출한 클래스,매서드 정보
		// ex: Controller \ t:BoardController.view(); 
		log.info(name+type+"."+joinPoint.getSignature().getName());
		// method에 전달되느 매개변수들
		log.info(Arrays.deepToString(joinPoint.getArgs()));
		// 매서드가 끝나는 시간
		long end = System.currentTimeMillis();
		long time = end - start; // 시작시간과 끝나는 시간을빼 실행시간을 출력함!
		log.info("실행시간"+ time); //실행시간
		return result;
		
		
		
	}
	
}
