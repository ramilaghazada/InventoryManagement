package org.warehouse.inventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "username")
    private String email;
    @Column(name = "password")
    private String password;

//    @ManyToOne
//    @JoinColumn(name = "CreatedBy", referencedColumnName = "Id")
//    private User user;
    @CreationTimestamp
    @Column(name = "date")
    private LocalDateTime date;
}
