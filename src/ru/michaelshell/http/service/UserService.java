package ru.michaelshell.http.service;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import ru.michaelshell.http.dao.UserDao;
import ru.michaelshell.http.dto.CreateUserDto;
import ru.michaelshell.http.dto.UserDto;
import ru.michaelshell.http.exception.ValidationException;
import ru.michaelshell.http.mapper.CreateUserMapper;
import ru.michaelshell.http.mapper.UserMapper;
import ru.michaelshell.http.validator.CreateUserValidator;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();
    private final ImageService imageService = ImageService.getINSTANCE();

    public static UserService getInstance() {
        return INSTANCE;
    }

    public Optional<UserDto> login(String email, String password) {
        return userDao.findByEmailAndPassword(email, password)
                .map(userMapper::mapFrom);
    }

    @SneakyThrows
    public void create(CreateUserDto userDto) {
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var user = createUserMapper.mapFrom(userDto);
        imageService.upload(user.getImage(), userDto.getImage().getInputStream());
        userDao.save(user);
    }
}
