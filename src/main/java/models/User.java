package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Builder

public class User {
    private String name;
    private String email;
    private String phone;
    private String subject;
    private String message;
}
