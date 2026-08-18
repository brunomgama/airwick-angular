package com.example.euportal.project;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins="http://localhost:4200")
public class ProjectController {

	@GetMapping
	public List<Project> getProjects() {
		return List.of(
			new Project(1L, "Digital Europe Portal"),
			new Project(2L, "Green Mobility Programme")
		);
	}
}
