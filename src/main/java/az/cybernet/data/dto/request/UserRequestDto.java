package az.cybernet.data.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserRequestDto {
    private String name;
    private BigDecimal salary;
}
