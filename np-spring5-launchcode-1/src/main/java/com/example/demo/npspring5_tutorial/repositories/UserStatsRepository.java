package com.example.demo.npspring5_tutorial.repositories;
//import java.util.Optional;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.npspring5_tutorial.domain.UserStats;

//this is the place to call to get methods
@Repository
public interface UserStatsRepository extends JpaRepository<UserStats, String> {
	//returns if user was found by email or not when called
	//you can create your own queries with this as well
	//List<UserStats> findByEmail(String email);
	UserStats findByDate(String date);
	//User findByUsername(String username);
	@Override
	public List<UserStats> findAll();
	public void deleteByDate(String date);
	List<UserStats> findByOrderByDateDesc();
	
}
