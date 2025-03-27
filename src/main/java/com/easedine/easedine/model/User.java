package com.easedine.easedine.model;


import java.util.Date;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String userId;
    String name;
    String category;
    String phoneNo;
    String address;
    String email;
    String gender;
    Date dob;

}
