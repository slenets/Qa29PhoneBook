package apiContact.dto;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlRootElement
public class UserData {
    private String email;
    private String password;
}
