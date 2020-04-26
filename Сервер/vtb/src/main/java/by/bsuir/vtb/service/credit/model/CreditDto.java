package by.bsuir.vtb.service.credit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditDto {

    private long id;

    private double sum;

    private Integer percent;

    private String title;
}
