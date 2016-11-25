package br.upf.casca.ads.beans.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringOptionsValidImpl.class)
@Documented

public @interface StringOptionsValid {
    String message() default "Opção inválida!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String[] opcoes() default {};
}
