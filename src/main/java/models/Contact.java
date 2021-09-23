package models;

import lombok.*;

@Getter
@Setter
@Builder
public class Contact {
    String name;
    String lastName;
    String phone;
    String email;
    String address;
    String description;
}
