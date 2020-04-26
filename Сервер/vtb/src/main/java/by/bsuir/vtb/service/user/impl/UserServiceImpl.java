package by.bsuir.vtb.service.user.impl;

import by.bsuir.vtb.repository.model.Credit;
import by.bsuir.vtb.repository.model.Deposit;
import by.bsuir.vtb.repository.model.User;
import by.bsuir.vtb.repository.user.UserRepository;
import by.bsuir.vtb.service.Authenticated;
import by.bsuir.vtb.service.credit.model.CreditDto;
import by.bsuir.vtb.service.deposit.model.DepositDto;
import by.bsuir.vtb.service.user.UserService;
import by.bsuir.vtb.service.user.model.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl extends Authenticated implements UserService  {

    @Override
    public UserInfoDto getInfo() {
        Optional<User> user = getUser();

        User value = user.get();
        UserInfoDto dto = UserInfoDto.builder()
                .name(value.getName() + " " + value.getSurname())
                .count(value.getCount())
                .build();
        if(!CollectionUtils.isEmpty(user.get().getDepositList())){
            dto.setDeposits(getDeposits(user.get()));
        }
        if(!CollectionUtils.isEmpty(user.get().getCreditList())){
            dto.setCredits(getCredits(user.get()));
        }
        return dto;
    }

    private List<DepositDto> getDeposits(User user){
        return user.getDepositList().stream()
                    .map(this::convertDeposit)
                    .collect(Collectors.toList());


    }

    private DepositDto convertDeposit(Deposit deposit){
        return DepositDto.builder()
                .id(deposit.getId())
                .title(deposit.getTitle())
                .percent(deposit.getPercent())
                .sum(deposit.getSum()).build();
    }
    private List<CreditDto> getCredits(User user){
        return user.getCreditList().stream()
                .map(this::convertCredit)
                .collect(Collectors.toList());


    }

    private CreditDto convertCredit(Credit credit){
        return CreditDto.builder()
                .id(credit.getId())
                .title(credit.getTitle())
                .percent(credit.getPercent())
                .sum(credit.getSum()).build();
    }
}
