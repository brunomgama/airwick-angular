import { Component, inject, signal } from '@angular/core';
import { Project } from './project';
import { ProjectService } from './project.service';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.html',
  styleUrl: './project-list.css'
})
export class ProjectList {
  private readonly service = inject(ProjectService);
  projectList = signal<Project[]>([]);

  constructor() {
    this.service.getProjects().subscribe(projects => {
      console.log("hello world", projects);
      this.projectList.set(projects);
    });
  }
}
