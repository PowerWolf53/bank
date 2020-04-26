package by.bsuir.vtb.job;

import by.bsuir.vtb.repository.model.Credit;
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
public class CreditJob {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void scheduleCredits(){
        List<User> users = Lists.newArrayList(userRepository.findAll());
        users.forEach(this::handleUser);
    }

    private void handleUser(User user){
        List<Credit> credits = user.getCreditList();
        credits.forEach(credit->{
            Double percent = getCreditPercent(credit);
            credit.setSum(credit.getSum()+percent);

        });
        user.setCreditList(credits);
        userRepository.save(user);
    }

    private Double getCreditPercent(Credit credit){
        double sum = credit.getSum();
        double percent = (sum/100)*credit.getPercent();
        return  new BigDecimal(percent).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
