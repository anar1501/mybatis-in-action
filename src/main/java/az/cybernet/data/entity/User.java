package az.cybernet.data.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class User {
    private Long id;
    private String name;
    private BigDecimal salary;
}
