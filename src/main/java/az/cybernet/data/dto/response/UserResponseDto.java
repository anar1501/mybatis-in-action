package az.cybernet.data.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UserResponseDto {
    private String name;
    private BigDecimal salary;
}
