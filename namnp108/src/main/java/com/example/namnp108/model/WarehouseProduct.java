package com.example.namnp108.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "warehoueProduct")
public class WarehouseProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long Inventory;
    private Integer totalImport;
    private Integer totalExport;
    private Date startDate;
    private Date expiredDate;
}
