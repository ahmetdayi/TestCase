package com.bobu.testcase.validation;


import jakarta.validation.ConstraintValidator;


import jakarta.validation.ConstraintValidatorContext;
import org.passay.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
//        // check if string contains at least one digit, one lowercase letter, one uppercase letter, one special character and 8 characters long
//        return value.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()]).{8,}$");
        Properties props = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("passay.properties");
        try {
            props.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PasswordValidator validator = getPasswordValidator(props);
        RuleResult result = validator.validate(new PasswordData(value));
        if (result.isValid()) {
            return true;

        }
        List<String> messages = validator.getMessages(result);
        String messageTemplate = String.join(",", messages);
        context.buildConstraintViolationWithTemplate(messageTemplate).addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }

    private static PasswordValidator getPasswordValidator(Properties props) {
        MessageResolver resolver = new PropertiesMessageResolver(props);
        return new PasswordValidator(resolver, Arrays.asList(
                // length between 8 and 16 characters
                new LengthRule(8, 16),
                // at least one upper-case character
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                // at least one lower-case character
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                // at least one digit character
                new CharacterRule(EnglishCharacterData.Digit, 1),
                // no whitespace
                new WhitespaceRule()
        ));
    }
}