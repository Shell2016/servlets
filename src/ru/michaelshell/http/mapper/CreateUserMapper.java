package ru.michaelshell.http.mapper;

import lombok.NoArgsConstructor;
import ru.michaelshell.http.dto.CreateUserDto;
import ru.michaelshell.http.entity.Gender;
import ru.michaelshell.http.entity.Role;
import ru.michaelshell.http.entity.User;
import ru.michaelshell.http.util.LocalDateFormatter;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CreateUserMapper implements Mapper<CreateUserDto, User> {

    private static final String IMAGE_FOLDER = "users/";

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .image(IMAGE_FOLDER + object.getImage().getSubmittedFileName())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .build();
    }

}
