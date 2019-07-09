package com.example.demo.npspring5_tutorial.services;

import java.util.List;

import com.example.demo.npspring5_tutorial.commands.StatsCommand;
import com.example.demo.npspring5_tutorial.domain.UserStats;


public interface StatsService {

	void addRecord(StatsCommand statsCommand);
	void deleteByDate(String date);
	List<UserStats> getSortedByDate();
	void updateRecord(StatsCommand newStats, StatsCommand oldStats);
}