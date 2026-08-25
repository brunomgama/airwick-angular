import { Component, inject, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { RouterModule } from '@angular/router';
import { CreateProject, Project } from './project';
import { ProjectService } from './project.service';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.html',
  styleUrl: './project.css',
  imports: [MatFormFieldModule, MatInputModule, FormsModule, RouterModule],
})
export class ProjectList {

  private readonly service = inject(ProjectService);

  projectList = signal<Project[]>([]);
  projectTitle = signal('');

  constructor() {
    this.service.getProjects().subscribe(projects => {
      console.log("hello world", projects);
      this.projectList.set(projects);
    });
  }

  createTestRequest() {
    const request : CreateProject =
    {
      name: this.projectTitle(),
    };

    this.service.createProject(request).subscribe(p => {
      console.log("Created project with id ", p.id);
      this.projectList.update(projectList => [
        ...projectList,
        p
      ])

      this.projectTitle.set('');
    })
  }
}
