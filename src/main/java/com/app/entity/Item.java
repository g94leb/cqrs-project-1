package com.app.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "ITEM")

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Item {


    @Id
    private Long id;

    @Column
    private Double price;

    @Column
    private Integer quantity;

    @Column
    private String description;

}
