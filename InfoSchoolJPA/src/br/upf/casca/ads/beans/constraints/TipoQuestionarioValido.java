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
@Constraint(validatedBy = TipoQuestionarioValidoImpl.class)
@Documented

public @interface TipoQuestionarioValido {
	String message() default "{br.upf.casca.ads.beans.constraints.TipoQuestioarioValido}";
	Class<?>[] groups() default{};
	Class <? extends Payload>[] payload() default {};
	String[] opcoes() default{};
	
	
}
