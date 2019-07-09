package com.example.demo.npspring5_tutorial.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.stereotype.Component;

import com.example.demo.npspring5_tutorial.domain.UserStats;
@Component
public class StatsUtils {
	public int getTotalMiles(List<UserStats> userStatsList) {
		int totalMiles = 0;
		for(UserStats stats : userStatsList)
		{
		   totalMiles += stats.getTotalDaily();
		}
		return totalMiles;
	}
	
	public BigDecimal getTotalMoneyMade(List<UserStats> userStatsList) {
		BigDecimal moneyTotal = new BigDecimal(00.00);
		BigDecimal holder = new BigDecimal(0);
		for(UserStats stats : userStatsList)
		{
			holder = moneyTotal;
			moneyTotal = holder.add(stats.getMoneyMade());
	
		}
		return moneyTotal;
	}
	public BigDecimal getTotalMoneySpent(List<UserStats> userStatsList) {
		BigDecimal moneyTotal = new BigDecimal(00.00);
		BigDecimal holder = new BigDecimal(0);
		for(UserStats stats : userStatsList)
		{
			holder = moneyTotal;
			moneyTotal = holder.add(stats.getMoneySpent());
		}
		return moneyTotal;
	}
	
	public BigDecimal getTotalNetPorL(List<UserStats> userStatsList) {
		BigDecimal moneyTotal = new BigDecimal(00.00);
		BigDecimal holder = new BigDecimal(0);
		for(UserStats stats : userStatsList)
		{
			holder = moneyTotal;
			moneyTotal = holder.add(stats.getNetPorL());
			
		}
		return moneyTotal;
	}
	
	public BigDecimal taxCredit2019(int totalMiles) {
		//calculates tax credit for miles driven based on 2019 year
		BigDecimal taxRate = new BigDecimal(00.58);
		return BigDecimal.valueOf(totalMiles).multiply(taxRate).setScale(2,RoundingMode.HALF_UP); //58 cent deduction, 2 scale is places to right of decimal point, rounding mode indicate 5 will round up
		
	}
}