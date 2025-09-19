package store.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

    private String userName;
    private String country;
    private String city;
    private String creditCard;
    private String month;
    private String year;

}
