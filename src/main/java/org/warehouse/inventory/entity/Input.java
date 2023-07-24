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
@Table(name = "Input")
public class Input {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "code", referencedColumnName = "code")
    private Card card;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "notes")
    private String note;

    @ManyToOne
    @JoinColumn(name = "createdBy", referencedColumnName = "id")
    private User user;
    @CreationTimestamp
    @Column(name = "date")
    private LocalDateTime date;

}
