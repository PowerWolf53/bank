package by.bsuir.vtb.controller;

import by.bsuir.vtb.service.count.CountService;
import by.bsuir.vtb.service.count.model.FillCountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/vtb/count", produces = APPLICATION_JSON_VALUE)
public class CountController {

    @Autowired
    CountService countService;

    @PostMapping(value = "/add")
    public @ResponseBody void addMoney(@RequestBody FillCountDto dto){
        countService.addMoney(dto);
    }
}
