package org.example.overrideexample;

public class UserDto {
    private String name;
    private int age;

    public UserDto(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public UserDto(User user) {
        this.name=user.getName();
        this.age=user.getAge();
    }


}
