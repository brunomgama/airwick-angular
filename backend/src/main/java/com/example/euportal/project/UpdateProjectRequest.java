package com.example.euportal.project;

import jakarta.validation.constraints.NotBlank;

public record UpdateProjectRequest(
	@NotBlank String name
) {
}
