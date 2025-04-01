package com.easedine.easedine.model;


import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private String userId;

    @Column(nullable = false,unique = true)
    private String name;

    private String category;

    @Column(unique = true,nullable = false)
    private String phoneNo;

    private String address;

    @Column(unique = true,nullable = false)
    private String email;

    private String gender;

    private Date dob;
    private UserRole userRole;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
