package com.rod.effective.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**  
 * @Title: ExceptionTest.java
 * @Package com.rod.effective.annotation
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Rod
 * @date 2015年5月20日 下午10:48:55
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
	Class<? extends Exception> value();
}
