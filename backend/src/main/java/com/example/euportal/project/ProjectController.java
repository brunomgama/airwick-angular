package com.example.euportal.project;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins="http://localhost:4200")
public class ProjectController {

	private final ProjectService projectService;

	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	@GetMapping
	public List<Project> getProjects() {
		return projectService.getProjects();
	}

	@PostMapping
	public ResponseEntity<Project> createProject(@Valid @RequestBody CreateProjectRequest request) {
		Project createdProject = projectService.createProject(request.name());
		return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
	}
}
