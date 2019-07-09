package com.example.demo.npspring5_tutorial.controllers;


import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.npspring5_tutorial.commands.StatsCommand;
import com.example.demo.npspring5_tutorial.domain.UserStats;
import com.example.demo.npspring5_tutorial.repositories.UserStatsRepository;
import com.example.demo.npspring5_tutorial.services.StatsService;

@Controller
public class StatsController {
	@Autowired
	private UserStatsRepository repository;
	@Autowired
	private StatsService statsService;
	
	@GetMapping("addstats")
	public String getAddStats(Model model) {
		model.addAttribute("userStats", new StatsCommand());
		return "addstats";
	}
	
	//adds record to db
	@PostMapping("addstats")
	public String addStats(@Validated @ModelAttribute("userStats") StatsCommand newStats,
			BindingResult result) {
		if (result.hasErrors())
			return "addstats";
		statsService.addRecord(newStats);
		return "redirect:/view";
	}


	@GetMapping("edit")
	public String edit(@RequestParam("date")String date,Model model ) {
		try {
				System.out.println("in edit");
				System.out.println(date);
				UserStats userStats = repository.findByDate(date);
				StatsCommand statsCommand = new StatsCommand();
				statsCommand.fillValues(userStats.getDate(), userStats.getStartingMiles(), userStats.getEndingMiles(), userStats.getMoneyMade(), userStats.getMoneySpent(),userStats.getNetPorL());
				model.addAttribute("userStats",statsCommand);
				return "edit";
			}
				
			 catch(Exception e){
				System.out.println(e.getMessage());
			}
		return "edit";
	}
	@PostMapping("edit")
	public String saveEdit(@Validated @ModelAttribute("userStats") StatsCommand newStats,BindingResult result) {
		//work around bc old and new dates being saved
		String[] dates =newStats.getDate().split(",");
		newStats.setDate(dates[dates.length-1]);
		statsService.deleteByDate(dates[0]);
		//end workaround
		statsService.addRecord(newStats);

		if (result.hasErrors())
			return "edit";
		return "redirect:/view";
	}

}
