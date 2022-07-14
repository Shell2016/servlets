package ru.michaelshell.http.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);
}
