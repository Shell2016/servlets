package ru.michaelshell.http.service;

import lombok.NoArgsConstructor;
import ru.michaelshell.http.dao.UserDao;
import ru.michaelshell.http.dto.CreateUserDto;
import ru.michaelshell.http.exception.ValidationException;
import ru.michaelshell.http.mapper.CreateUserMapper;
import ru.michaelshell.http.validator.CreateUserValidator;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();

    public static UserService getInstance() {
        return INSTANCE;
    }

    public void create(CreateUserDto userDto) {
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var user = createUserMapper.mapFrom(userDto);
        userDao.save(user);
    }
}
