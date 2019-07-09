package com.example.demo.npspring5_tutorial;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import com.example.demo.npspring5_tutorial.commands.StatsCommand;
import com.example.demo.npspring5_tutorial.domain.UserStats;
import com.example.demo.npspring5_tutorial.repositories.UserStatsRepository;

@SpringBootApplication
public class NpSpring5LaunchcodeApplication1  {
	@Autowired
	private UserStatsRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(NpSpring5LaunchcodeApplication1.class, args);
	}
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//add some dummy db info
		
		StatsCommand statsCommand= new StatsCommand();
		BigDecimal moneyMade= new BigDecimal(119.75);
		BigDecimal moneySpent = new BigDecimal(19.62);
		statsCommand.fillValues("2019-06-01", 130944, 131125, moneyMade, moneySpent, moneyMade.subtract(moneySpent));
		repository.save(statsCommand.toUserStats());
		
		moneyMade = new BigDecimal(192.63);
		moneySpent = new BigDecimal(25.13);
		statsCommand.fillValues("2019-06-03", 131330, 131535, moneyMade, moneySpent, moneyMade.subtract(moneySpent));
		repository.save(statsCommand.toUserStats());
		
		moneyMade = new BigDecimal(67.03);
		moneySpent = new BigDecimal(21.19);
		statsCommand.fillValues("2019-06-04", 131915, 132005, moneyMade, moneySpent, moneyMade.subtract(moneySpent));
		repository.save(statsCommand.toUserStats());
		
		moneyMade = new BigDecimal(221.15);
		moneySpent = new BigDecimal(28.33);
		statsCommand.fillValues("2019-06-05", 132083, 132344, moneyMade, moneySpent, moneyMade.subtract(moneySpent));
		repository.save(statsCommand.toUserStats());
		
		moneyMade = new BigDecimal(16.75);
		moneySpent = new BigDecimal(19.73);
		statsCommand.fillValues("2019-06-06", 132423, 132484, moneyMade, moneySpent, moneyMade.subtract(moneySpent));
		repository.save(statsCommand.toUserStats());
		
		moneyMade = new BigDecimal(126.18);
		moneySpent = new BigDecimal(23.15);
		statsCommand.fillValues("2019-06-07", 132491, 132613, moneyMade, moneySpent, moneyMade.subtract(moneySpent));
		repository.save(statsCommand.toUserStats());
		
		
		
	}
}
