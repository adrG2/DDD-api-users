package com.ddd.user.domain;

public class User {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String nickName;

    private User(
        final String id,
        final String firstName,
        final String lastName,
        final String email,
        final String password,
        final String nickName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public static class UserDomainBuilder {

        private String id;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String nickName;

        UserDomainBuilder() {
        }

        public UserDomainBuilder id(final String id) {
            this.id = id;
            return this;
        }

        public UserDomainBuilder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserDomainBuilder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserDomainBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public UserDomainBuilder password(final String password) {
            this.password = password;
            return this;
        }

        public UserDomainBuilder nickName(final String nickName) {
            this.nickName = nickName;
            return this;
        }

        public User build() {
            return new User(id, firstName, lastName, email, password, nickName);
        }
    }

    public static UserDomainBuilder builder() {
        return new UserDomainBuilder();
    }
}
