package by.bsuir.vtb.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    private DepositJob depositJob;

    @Autowired
    private CreditJob creditJob;

    @Scheduled(cron = "0 * * * * ?")
    public void scheduleDeposits(){
        depositJob.scheduleDeposits();
    }

    @Scheduled(cron = "0 * * * * ?")
    public void scheduleCredits(){
        creditJob.scheduleCredits();
    }
}
