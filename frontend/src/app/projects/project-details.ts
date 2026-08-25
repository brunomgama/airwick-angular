import { Component, inject, signal } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Project } from './project';
import { ProjectService } from './project.service';

@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.html',
  styleUrl: './project.css',
})
export class ProjectDetails {

  private readonly service = inject(ProjectService);
  private route = inject(ActivatedRoute);
  project = signal<Project | null>(null);

  constructor() {
    const id = this.route.snapshot.paramMap.get('id');

    if(id !== null) {
      this.service.getProjectDetails(Number(id)).subscribe(p => {
        console.log(p.id + " " + p.name);
        this.project.set(p);
      })
    }
    console.log();
  }

}
