package com.rod.effective.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**  
 * @Title: ExceptionTest.java
 * @Package com.rod.effective.annotation
 * @Description: TODO(��һ�仰�������ļ���ʲô)
 * @author Rod
 * @date 2015��5��20�� ����10:48:55
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
	Class<? extends Exception> value();
}
