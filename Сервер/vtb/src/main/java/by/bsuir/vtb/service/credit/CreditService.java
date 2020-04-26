package by.bsuir.vtb.service.credit;

import by.bsuir.vtb.service.credit.model.CreditDto;

import java.util.List;

public interface CreditService {

    void addCredit(CreditDto dto);

    void deleteCredits(List<Long> ids);
}
