package models;

import lombok.*;

@Getter
@Setter
@Builder
public class User {
    String email;
    String password;

//    public User withEmail(String email) {
//        this.email = email;
//        return this;
//    }
//
//    public User withPassword(String password) {
//        this.password = password;
//        return this;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
}
