package by.bsuir.vtb.service.deposit.impl;

import by.bsuir.vtb.repository.model.Deposit;
import by.bsuir.vtb.repository.model.User;
import by.bsuir.vtb.repository.user.UserRepository;
import by.bsuir.vtb.service.Authenticated;
import by.bsuir.vtb.service.deposit.DepositService;
import by.bsuir.vtb.service.deposit.model.DepositDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DepositServiceImpl extends Authenticated implements DepositService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addDeposit(DepositDto depositDto) {
        Optional<User> user = getUser();

        if(user.isPresent()){
            User presentUser = user.get();
            presentUser.setCount(presentUser.getCount() - depositDto.getSum());
            Deposit deposit = Deposit.builder()
                    .percent(depositDto.getPercent())
                    .sum(depositDto.getSum())
                    .title(depositDto.getTitle())
                    .build();
            presentUser.getDepositList().add(deposit);
            userRepository.save(presentUser);
        }
    }

    @Override
    public void deleteDeposits(List<Long> ids) {
        User user = getUser().get();
        Double depositsCount = user.getDepositList().stream()
                .filter(deposit -> ids.contains(deposit.getId()))
                .map(Deposit::getSum)
                .reduce(Double::sum).get();
        Double initialCount = user.getCount();
        user.setCount(initialCount + depositsCount);
        List<Deposit> filtered = user.getDepositList().stream()
                .filter(deposit -> !ids.contains(deposit.getId()))
                .collect(Collectors.toList());
        user.setDepositList(filtered);
        userRepository.save(user);
    }
}
