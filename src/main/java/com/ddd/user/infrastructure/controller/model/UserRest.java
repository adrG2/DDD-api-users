package com.ddd.user.infrastructure.controller.model;

import com.ddd.user.domain.User;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRest {
    private String id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private String nickName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNickName() {
        return nickName;
    }

    private void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public User toUser() {
        return User.builder()
            .id(id)
            .firstName(firstName)
            .lastName(lastName)
            .email(email)
            .nickName(nickName)
            .build();
    }

    public static UserRest toUserRest(final User user) {
        UserRest userResponse = new UserRest();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setLastName(user.getLastName());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setNickName(user.getNickName());
        return userResponse;
    }
}
