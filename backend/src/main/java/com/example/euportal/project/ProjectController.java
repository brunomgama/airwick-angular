package com.example.euportal.project;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/{id}")
	public ResponseEntity<Project> getSingleProject(@PathVariable Long id) {
		Optional <Project> project = projectService.getSingleProject(id);
		return project.map(p -> ResponseEntity.ok(p)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable Long id, @Valid @RequestBody UpdateProjectRequest request) {
		Optional <Project> updatedProject = projectService.updateProject(id, request.name());
		return updatedProject.map(p -> ResponseEntity.ok(p)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Project> patchProject(@PathVariable Long id, @Valid @RequestBody PatchProjectRequest request) {
		Optional <Project> patchProject = projectService.patchProject(id, request.name());
		return patchProject.map(p -> ResponseEntity.ok(p)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
}
