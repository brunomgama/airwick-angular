import { Routes } from '@angular/router';
import { ProjectDetails } from './projects/project-details';
import { ProjectList } from './projects/project-list';

export const routes: Routes = [
  {
    path: 'project',
    component: ProjectList
  },
  {
    path: 'project/:id',
    component: ProjectDetails
  }
];
