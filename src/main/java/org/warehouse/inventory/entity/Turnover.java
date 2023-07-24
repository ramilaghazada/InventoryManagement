package org.warehouse.inventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Turnover")
public class Turnover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "code", referencedColumnName = "code")
    private Card card;
    @Column(name = "o_balance")
    private Double OBalance;
    @Column(name = "input")
    private Double input;
    @Column(name = "output")
    private Double output;
    @Column(name = "c_balance")
    private Double CBalance;

}
