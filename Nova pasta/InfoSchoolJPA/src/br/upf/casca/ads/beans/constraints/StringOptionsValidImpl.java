package br.upf.casca.ads.beans.constraints;

import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringOptionsValidImpl implements 
                         ConstraintValidator<StringOptionsValid, String> {
    
    private String[] opcoes;
    
    public void initialize(StringOptionsValid a) {
        opcoes = a.opcoes();
    }
    
    public boolean isValid(String value, ConstraintValidatorContext cvc) {
      if (value == null)
         return true;
      List<String> list = Arrays.asList(opcoes); // vetor para List
      if (list.contains(value))
         return true;
      else
         return false;
    }
}
