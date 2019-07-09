package com.example.demo.npspring5_tutorial.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stats")
public class UserStats {
	
	@Id
	@Column
	private String date;
	
	@Column
	private BigDecimal moneyMade;
	
	@Column
	private BigDecimal moneySpent;
	
	@Column
	private BigDecimal netPorL;
		
	public BigDecimal getNetPorL() {
		return netPorL;
	}



	public void setNetPorL(BigDecimal netPorL) {
		this.netPorL = netPorL;
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
	
	

	public void setMoneyMade(BigDecimal moneyMade2) {
		this.moneyMade = moneyMade2;
	}

	public UserStats(String date, Integer startingMiles, Integer endingMiles, Integer totalDaily, BigDecimal moneyMade, BigDecimal moneySpent) {
		super();

		this.startingMiles = startingMiles;
		this.endingMiles = endingMiles;
		this.totalDaily = totalDaily;
		this.date = "2019-1-1";
		this.moneyMade= moneyMade;
		this.moneySpent= moneySpent;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	@Column(nullable=true)
	private Integer startingMiles;
	
	@Column(nullable=true)
	private Integer endingMiles;
	
	public UserStats() {}
	
	@Column(nullable=true)
	private Integer totalDaily;
	
	
	
	public Integer getStartingMiles() {
		return startingMiles;
	}

	public void setStartingMiles(Integer startingMiles) {
		this.startingMiles = startingMiles;
	}

	public Integer getEndingMiles() {
		return endingMiles;
	}

	public void setEndingMiles(Integer endingMiles) {
		this.endingMiles = endingMiles;
	}

	public Integer getTotalDaily() {
		return totalDaily;
	}

	public void setTotalDaily(Integer totalDaily) {
		this.totalDaily = totalDaily;
	}

}