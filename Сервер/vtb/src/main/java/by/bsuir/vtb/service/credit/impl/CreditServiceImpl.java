package by.bsuir.vtb.service.credit.impl;

import by.bsuir.vtb.repository.model.Credit;
import by.bsuir.vtb.repository.model.Deposit;
import by.bsuir.vtb.repository.model.User;
import by.bsuir.vtb.repository.user.UserRepository;
import by.bsuir.vtb.service.Authenticated;
import by.bsuir.vtb.service.credit.CreditService;
import by.bsuir.vtb.service.credit.model.CreditDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CreditServiceImpl extends Authenticated implements CreditService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void addCredit(CreditDto dto) {
        Optional<User> user = getUser();

        if(user.isPresent()){
            User presentUser = user.get();
            presentUser.setCount(presentUser.getCount() + dto.getSum());
            Credit credit = Credit.builder()
                    .percent(dto.getPercent())
                    .sum(dto.getSum())
                    .title(dto.getTitle())
                    .build();
            presentUser.getCreditList().add(credit);
            userRepository.save(presentUser);
        }
    }

    @Override
    public void deleteCredits(List<Long> ids) {
        User user = getUser().get();
        Double creditCount = user.getCreditList().stream()
                .filter(deposit -> ids.contains(deposit.getId()))
                .map(Credit::getSum)
                .reduce(Double::sum).get();
        Double initialCount = user.getCount();
        user.setCount(initialCount - creditCount);
        List<Credit> filtered = user.getCreditList().stream()
                .filter(credit -> !ids.contains(credit.getId()))
                .collect(Collectors.toList());
        user.setCreditList(filtered);
        userRepository.save(user);
    }
}
