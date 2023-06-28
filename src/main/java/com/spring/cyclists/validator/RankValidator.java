package com.spring.cyclists.validator;


import com.spring.cyclists.model.Rank;
import com.spring.cyclists.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RankValidator implements Validator {

    @Autowired
    private RankService rankService;

     @Override
    public boolean supports(Class<?> aClass) {
        return Rank.class.equals(aClass);
    }
     @Override
    public void validate(Object o, Errors errors) {
        Rank rank = (Rank) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
      if (rank.getName().length() < 3 || rank.getName().length() > 32) {
            errors.rejectValue("name", "rank.name");
        }

    }


}
