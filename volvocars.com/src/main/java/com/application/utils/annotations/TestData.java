package com.application.utils.annotations;



import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD})
@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
public @interface TestData {
	String source() default "";
	String dataBean() default "";
	String type() default "json";
}



