package apiContact.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorMessage {
    private Integer code;
    private String details;
    private String message;
    private String timestamp;
}
