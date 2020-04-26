package by.bsuir.vtb.service.deposit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepositDto {

    private long id;

    private double sum;

    private Integer percent;

    private String title;
}
