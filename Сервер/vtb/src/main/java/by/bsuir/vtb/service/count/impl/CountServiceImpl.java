package by.bsuir.vtb.service.count.impl;

import by.bsuir.vtb.repository.model.User;
import by.bsuir.vtb.repository.user.UserRepository;
import by.bsuir.vtb.service.Authenticated;
import by.bsuir.vtb.service.count.CountService;
import by.bsuir.vtb.service.count.model.FillCountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CountServiceImpl extends Authenticated implements CountService  {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addMoney(FillCountDto dto) {
        Optional<User> user = getUser();
        if(user.isPresent()){
            User presentUser = user.get();
            double count = user.get().getCount();
            count += dto.getAmount();
            presentUser.setCount(count);
            userRepository.save(presentUser);
        }
    }
}
