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
@Table(name = "OBalance")
public class OBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "code", referencedColumnName = "code")
    private Card card;
    @Column(name = "quantity")
    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "createdBy", referencedColumnName = "id")
    private User user;
    @CreationTimestamp
    @Column(name = "date")
    private LocalDateTime date;
}
