package com.example.demo.npspring5_tutorial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.npspring5_tutorial.commands.StatsCommand;
import com.example.demo.npspring5_tutorial.domain.UserStats;
import com.example.demo.npspring5_tutorial.repositories.UserStatsRepository;


@Service("statsService")
public class StatsServiceImpl implements StatsService {
	
	@Autowired
	private UserStatsRepository userStatsRepository;

	@Override
	public void addRecord(StatsCommand statsCommand) {
		userStatsRepository.save(statsCommand.toUserStats());
	}

	@Override
	@Transactional
	public void deleteByDate(String date) {
		userStatsRepository.deleteByDate(date);
		
	}

	@Override
	public List<UserStats> getSortedByDate() {
		return userStatsRepository.findByOrderByDateDesc();
	}

	@Override
	@Transactional
	public void updateRecord(StatsCommand newStats, StatsCommand oldStats) {
		//need to turn oldStats date into user Stats to find the correct format
		//UserStats oldUserStats = oldStats.toUserStats();
		//userStatsRepository.deleteByDate(oldUserStats.getDate());
		userStatsRepository.save(newStats.toUserStats());
		
	}
}
	

	

	

