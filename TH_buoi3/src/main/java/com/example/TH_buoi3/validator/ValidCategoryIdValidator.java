package com.example.TH_buoi3.validator;

import com.example.TH_buoi3.entity.Category;
import com.example.TH_buoi3.validator.annotation.ValidCategoryId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext constraintValidatorContext) {
        return category != null && category.getId() !=null;
    }
}
