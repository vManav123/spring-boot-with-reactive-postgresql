package com.reactive.programming.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serial;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(value="product")
public class Product{

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Serial
    private Integer id;
    private String description;
    private Double price;

}
