package com.hyena.spring.core.validator;

import com.hyena.spring.core.model.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");

        Person p = (Person) target;

        if (p.getAge() < 0) {
            errors.rejectValue("age", "negativeValue");
        } else if (p.getAge() > 110) {
            errors.rejectValue("age" , "too.darn.old");
        }
    }
}
