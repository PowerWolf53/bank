package by.bsuir.vtb.controller;

import by.bsuir.vtb.service.credit.CreditService;
import by.bsuir.vtb.service.credit.model.CreditDto;
import by.bsuir.vtb.service.deposit.DepositService;
import by.bsuir.vtb.service.deposit.model.DeleteDepositsDto;
import by.bsuir.vtb.service.deposit.model.DepositDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/vtb/credit", produces = APPLICATION_JSON_VALUE)
public class CreditController {

    @Autowired
    private CreditService creditService;

    @PostMapping(value = "/add")
    public void add(@RequestBody CreditDto dto){
        creditService.addCredit(dto);
    }

    @PostMapping(value = "/delete")
    public void sdelete(@RequestBody DeleteDepositsDto dto){
        creditService.deleteCredits(dto.getIds());
    }
}
