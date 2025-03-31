package com.easedine.easedine.model;


import java.util.Date;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userId;
    private String name;
    private String category;
    private String phoneNo;
    private String address;
    private String email;
    private String gender;
    private Date dob;

}
