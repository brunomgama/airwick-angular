package com.example.euportal.project;

import jakarta.validation.constraints.NotBlank;

public record CreateProjectRequest(
	@NotBlank String name
) {
}
