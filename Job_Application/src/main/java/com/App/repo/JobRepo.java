package com.App.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.App.model.Job;

public interface JobRepo  extends JpaRepository<Job, Long>{

}
