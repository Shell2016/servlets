package ru.michaelshell.http.dto;

import lombok.Builder;
import lombok.Value;
import ru.michaelshell.http.entity.Gender;
import ru.michaelshell.http.entity.Role;

import java.time.LocalDate;

@Value
@Builder
public class UserDto {
    Integer id;
    String name;
    LocalDate birthday;
    String email;
    String image;
    Role role;
    Gender gender;
}
