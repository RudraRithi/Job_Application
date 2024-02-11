package com.App.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.App.model.Job;
import com.App.repo.JobRepo;
import com.App.service.JobService;

@Service
public class JobServiceImpl  implements JobService{

	private JobRepo jobRepo;
	
	

	public JobServiceImpl(JobRepo jobRepo) {
		super();
		this.jobRepo = jobRepo;
	}

	@Override
	public List<Job> findAll() {
		return jobRepo.findAll();
	}

	@Override
	public void createJob(Job job) {
		jobRepo.save(job);
		
	}

	@Override
	public Job getJobById(Long id) {
		return jobRepo.findById(id).orElse(null);
	}

	@Override
	public boolean deleteById(Long id) {
		try {
			jobRepo.deleteById(id);
		 return true;
		 }catch(Exception e) {
			 return false;
		 }
	}

	@Override
	public boolean updateJobById(Long id, Job updatedJob) {
		Optional<Job> jobOptional = jobRepo.findById(id);
		if(jobOptional.isPresent()) {
			Job job= jobOptional.get();
			job.setTitle(updatedJob.getTitle());
			job.setDescription(updatedJob.getDescription());
			job.setMinSalary(updatedJob.getMinSalary());
			job.setMaxSalary(updatedJob.getMaxSalary());
			job.setLocation(updatedJob.getLocation());
			jobRepo.save(job);
			return true;
		}
		return false;
		
	}
	



	

}
