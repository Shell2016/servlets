package ru.michaelshell.http.mapper;

import lombok.NoArgsConstructor;
import ru.michaelshell.http.dto.UserDto;
import ru.michaelshell.http.entity.User;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserMapper implements Mapper<User, UserDto> {

    private static final UserMapper INSTANCE = new UserMapper();

    public static UserMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public UserDto mapFrom(User object) {
        return UserDto.builder()
                .id(object.getId())
                .name(object.getEmail())
                .birthday(object.getBirthday())
                .email(object.getEmail())
                .image(object.getImage())
                .role(object.getRole())
                .gender(object.getGender())
                .build();
    }
}
