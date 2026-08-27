import { Component, inject, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ActivatedRoute } from '@angular/router';
import { Project } from './project';
import { ProjectService } from './project.service';

@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.html',
  styleUrl: './project.css',
  imports: [MatFormFieldModule, MatInputModule, FormsModule],
})
export class ProjectDetails {

  private readonly service = inject(ProjectService);
  private route = inject(ActivatedRoute);

  project = signal<Project | null>(null);
  projectTitle = signal('');

  constructor() {
    const id = this.route.snapshot.paramMap.get('id');

    if(id !== null) {
      this.service.getProjectDetails(Number(id)).subscribe(p => {
        this.project.set(p);
        this.projectTitle.set(p.name);
      })
    }
    console.log();
  }

  updateProject() {
    const project = this.project();

    if (project !== null) {
      const updatedProject = {
        id: project.id,
        name: this.projectTitle()
      };

      this.service.updateProject(updatedProject).subscribe(p => {
        this.project.set(p);
        this.projectTitle.set(p.name);
      });
    }
  }
}
