package org.warehouse.inventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Card")
public class Card {

    @Id
    @Column(name = "code")
    private String id;
    @Column(name = "description")
    private String description;
    @Column(name = "unit")
    private String unit;

    @CreationTimestamp
    @Column(name = "date")
    private LocalDateTime date;


}
