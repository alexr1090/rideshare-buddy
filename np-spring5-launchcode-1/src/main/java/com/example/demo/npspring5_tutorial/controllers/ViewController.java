package com.example.demo.npspring5_tutorial.controllers;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.npspring5_tutorial.domain.UserStats;
import com.example.demo.npspring5_tutorial.repositories.UserStatsRepository;
import com.example.demo.npspring5_tutorial.services.StatsService;
import com.example.demo.npspring5_tutorial.utils.StatsUtils;


@Controller
@RequestMapping("view")
public class ViewController {
	@Autowired
	private UserStatsRepository repository;
	@Autowired
	private StatsService statsService;
	
	@Autowired
	private StatsUtils myUtils;
	
	@GetMapping
	public String stats(ModelMap model) {
	
		
		List<UserStats>sortedStatsList = statsService.getSortedByDate();
		int totalMiles = 0;
		model.put("statsList",sortedStatsList);
		totalMiles =  myUtils.getTotalMiles(sortedStatsList);
		model.put("totalMilesSum",totalMiles);
		model.put("totalMoneyMade", myUtils.getTotalMoneyMade(sortedStatsList));
		model.put("totalMoneySpent", myUtils.getTotalMoneySpent(sortedStatsList));
		model.put("totalNetPorL", myUtils.getTotalNetPorL(sortedStatsList));
		model.put("taxSavings",myUtils.taxCredit2019(totalMiles));
		return "view";
	}
	//deletes record(s) from db
	@PostMapping(params="delete")
	public String delete(HttpServletRequest request, ModelMap modelMap) {
		try {
			for (String date : request.getParameterValues("date")) {
				statsService.deleteByDate(date);
				}
				return "redirect:/view";
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
		return "redirect:/view";
	}
	@PostMapping(params="edit")
	public String edit(HttpServletRequest request, ModelMap modelMap,RedirectAttributes redirectAttributes) {
		try {
				String j = "";
				for (String date:  request.getParameterValues("date")){
					j = date;
				}
					redirectAttributes.addAttribute("date",j);
					
					return "redirect:/edit";
				}
				
			 catch(Exception e){
				System.out.println(e.getMessage());
			}
		return "redirect:/view";
	}
}
