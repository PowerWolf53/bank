package by.bsuir.vtb.controller;

import by.bsuir.vtb.service.deposit.DepositService;
import by.bsuir.vtb.service.deposit.model.DeleteDepositsDto;
import by.bsuir.vtb.service.deposit.model.DepositDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/vtb/deposit", produces = APPLICATION_JSON_VALUE)
public class DepositController {

    @Autowired
    private DepositService depositService;

    @PostMapping(value = "/add")
    public void add(@RequestBody DepositDto dto){
        depositService.addDeposit(dto);
    }

    @PostMapping(value = "/delete")
    public void sdelete(@RequestBody DeleteDepositsDto dto){
        depositService.deleteDeposits(dto.getIds());
    }
}
