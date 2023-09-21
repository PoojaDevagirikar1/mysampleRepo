/**
 * 
 */
package com.application.utils.annotations;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({TYPE, METHOD, PARAMETER, CONSTRUCTOR})
/**
 * @author pooja.devagirikar
 *
 */
public @interface Test {

	String description();

	int invocationCount();

	String[] groups();

}
