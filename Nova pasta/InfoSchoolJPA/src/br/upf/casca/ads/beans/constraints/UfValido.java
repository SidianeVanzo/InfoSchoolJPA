package br.upf.casca.ads.beans.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UfValidoImpl.class)
@Documented
public @interface UfValido{
	String message() default "{br.upf.casca.ads.beans.constraints.UfValido}";
	Class<?>[] groups() default{};
	Class <? extends Payload>[] payload() default {};
	String[] opcoes() default{};
	
	
	
	
}
