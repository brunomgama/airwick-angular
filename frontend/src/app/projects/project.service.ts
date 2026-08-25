import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CreateProject, Project } from './project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private readonly httpClient = inject(HttpClient);

  getProjects(): Observable<Project[]> {
    return this.httpClient.get<Project[]>("http://localhost:8080/api/projects")
  }

  createProject(project: CreateProject): Observable<Project> {
    return this.httpClient.post<Project>("http://localhost:8080/api/projects", {name: project.name})
  }

}
