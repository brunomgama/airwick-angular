import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ProjectList } from './projects/project-list';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ProjectList],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('EU Project Management Portal II');
}
