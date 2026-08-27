package com.example.euportal.project;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProjectService {

	private final ProjectRepository projectRepository;

	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public List<Project> getProjects() {
		return projectRepository.findAll();
	}

	public Project createProject(String name) {
		Project p = new Project(null, name);
		return projectRepository.save(p);
	}

	public Optional<Project> getSingleProject(Long id) {
		return projectRepository.findById(id);
	}

	@Transactional
	public Optional<Project> updateProject(Long id, String name) {
		return projectRepository.findById(id).map(p -> {
			p.setName(name);
			// return projectRepository.save(p);
			return p;
		});
	}

	@Transactional
	public Optional<Project> patchProject(Long id, String name) {
		return projectRepository.findById(id).map(p -> {
			if(name != null && !name.isBlank()) {
				p.setName(name);
			}
			return p;
		});
	}
}
