package by.bsuir.vtb.job;

import by.bsuir.vtb.repository.model.Deposit;
import by.bsuir.vtb.repository.model.User;
import by.bsuir.vtb.repository.user.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;


@Component
public class DepositJob {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void scheduleDeposits(){
        List<User> users = Lists.newArrayList(userRepository.findAll());
        users.forEach(this::handleUser);
    }

    private void handleUser(User user){
        List<Deposit> deposits = user.getDepositList();
        Double totalSum = deposits.stream()
                .map(this::getDepositPercent)
                .mapToDouble(Double::doubleValue)
                .sum();
        user.setCount(user.getCount()+totalSum);
        userRepository.save(user);
    }

    private Double getDepositPercent(Deposit deposit){
        double sum = deposit.getSum();
        double percent = (sum/100)*deposit.getPercent();
        return  new BigDecimal(percent).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
