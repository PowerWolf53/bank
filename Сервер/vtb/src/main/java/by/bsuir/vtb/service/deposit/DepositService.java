package by.bsuir.vtb.service.deposit;


import by.bsuir.vtb.service.deposit.model.DepositDto;

import java.util.List;

public interface DepositService {

    void addDeposit(DepositDto depositDto);

    void deleteDeposits(List<Long> ids);
}
