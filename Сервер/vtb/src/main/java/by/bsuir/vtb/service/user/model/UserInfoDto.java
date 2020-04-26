package by.bsuir.vtb.service.user.model;

import by.bsuir.vtb.service.credit.model.CreditDto;
import by.bsuir.vtb.service.deposit.model.DepositDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {

    private String name;

    private Double count;

    private List<DepositDto> deposits;

    private List<CreditDto> credits;
}
