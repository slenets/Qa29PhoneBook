package apiContact.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contact {
    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String description;






}
