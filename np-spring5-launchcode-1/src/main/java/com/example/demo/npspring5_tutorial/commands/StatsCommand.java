package com.example.demo.npspring5_tutorial.commands;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.example.demo.npspring5_tutorial.domain.UserStats;


//pojo object used to receive data from form.

public class StatsCommand {
			
	@NotBlank(message="{blankDate}")
	private String date; //change to type date or errorcheck for db
	
	@NotNull
	private int startMiles;
	
	@NotNull
	private int endMiles;
	
	private int totalMiles;
	
	@NumberFormat(style=Style.CURRENCY)
	private BigDecimal moneyMade;
	
	@NumberFormat(style=Style.CURRENCY)
	private BigDecimal moneySpent;
	
	@NumberFormat(style=Style.CURRENCY)
	private BigDecimal netPorL;

	public void fillValues(String date, int startMiles,int endMiles,BigDecimal moneyMade,BigDecimal moneySpent,BigDecimal netPorL) {
		
		this.date = date;
		this.startMiles = startMiles;
		this.endMiles = endMiles;
		this.moneyMade = moneyMade;
		this.moneySpent = moneySpent;
		this.netPorL = netPorL;
		
	
	}
	
	public BigDecimal getNetPorL() {
		return netPorL;
	}



	public BigDecimal getMoneySpent() {
		return moneySpent;
	}



	public void setMoneySpent(BigDecimal moneySpent) {
		this.moneySpent = moneySpent;
	}



	public BigDecimal getMoneyMade() {
		return moneyMade;
	}



	public void setMoneyMade(BigDecimal moneyMade) {
		this.moneyMade = moneyMade;
	}



	public void setTotalMiles(int totalMiles) {
		this.totalMiles = totalMiles;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public int getStartMiles() {
		return startMiles;
	}



	public void setStartMiles(int startMiles) {
		this.startMiles = startMiles;
	}



	public int getEndMiles() {
		return endMiles;
	}



	public void setEndMiles(int endMiles) {
		this.endMiles = endMiles;
	}



	public int getTotalMiles() {
		return totalMiles;
	}



	public UserStats toUserStats() {
		//creates userStats object from command info
		
		UserStats userStats = new UserStats();
		
		userStats.setDate(date);
		userStats.setStartingMiles(startMiles);
		userStats.setEndingMiles(endMiles);
		userStats.setTotalDaily(endMiles - startMiles);
		userStats.setMoneyMade(moneyMade);
		userStats.setMoneySpent(moneySpent);
		userStats.setNetPorL(moneyMade.subtract(moneySpent));
		
		return userStats;
	}
}