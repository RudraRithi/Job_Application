package com.App.service;

import java.util.List;

import com.App.model.Job;

public interface JobService {

	List<Job> findAll();
	void createJob(Job job);
	Job getJobById(Long id);
	boolean deleteById(Long id);
	boolean updateJobById(Long id, Job updatedJob);
	
	
	 
}
