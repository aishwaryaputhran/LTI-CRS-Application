import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard-professor',
  templateUrl: './dashboard-professor.component.html',
  styleUrls: ['./dashboard-professor.component.css']
})

export class DashboardProfessorComponent implements OnInit {
 title='Welcome to Professor';
 today=new Date();
  constructor() { }

  ngOnInit(): void {
  }

}

