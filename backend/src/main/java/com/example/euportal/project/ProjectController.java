package com.example.euportal.project;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

	@GetMapping
	public List<Project> getProjects() {
		return List.of(
			new Project(1L, "Digital Europe Portal"),
			new Project(2L, "Green Mobility Programme")
		);
	}
}
