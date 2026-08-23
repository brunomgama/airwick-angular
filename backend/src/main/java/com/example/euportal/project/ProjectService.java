package com.example.euportal.project;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProjectService {

	private ProjectRepository projectRepository;

	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public List<Project> getProjects() {
		return projectRepository.findAll();
	}
}
