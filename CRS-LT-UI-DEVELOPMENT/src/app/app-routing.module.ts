import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// import { DashboardStudentComponent } from './dashboard-student/dashboard-student.component';
// import { DashboardUserComponent } from './dashboard-user/dashboard-user.component';
// import { LoginComponent } from './login/login.component';
// import { MyCourseRegistrartionComponent } from './my-course-registrartion/my-course-registrartion.component';
// import { MyCreditCardComponent } from './my-credit-card/my-credit-card.component';
// import { MyDebitCardComponent } from './my-debit-card/my-debit-card.component';
// import { MyGradeCardComponent } from './my-grade-card/my-grade-card.component';
// import { MyPaymentComponent } from './my-payment/my-payment.component';
// import { MyRegisteredCourseComponent } from './my-registered-course/my-registered-course.component';
import { DashboardProfessorComponent } from './dashboard-professor/dashboard-professor.component';
import { RegisteredCourseComponent } from './registered-course/registered-course.component';
import { ViewCourseComponent } from './view-course/view-course.component';
import { AddGradeComponent } from './add-grade/add-grade.component';
import { AdminComponentComponent } from './admin-component/admin-component.component';
import { AddProfessorComponent } from './add-professor/add-professor.component';
import { ApproveStudentComponent } from './approve-student/approve-student.component';
import { EditCourseComponent } from './edit-course/edit-course.component';
import { LoginComponent } from './login/login.component';
import { DashboardStudentComponent } from './dashboard-student/dashboard-student.component';
import { MyRegisteredCourseComponent } from './my-registered-course/my-registered-course.component';
import { MyGradeCardComponent } from './my-grade-card/my-grade-card.component';
import { MyCreditCardComponent } from './my-credit-card/my-credit-card.component';
import { MyCourseRegistrationComponent } from './my-course-registration/my-course-registration.component';
import { DashboardUserComponent } from './dashboard-user/dashboard-user.component';
import { SignupComponent } from './signup/signup.component';
import { UpdatePasswordComponent } from './update-password/update-password.component';


const routes: Routes = [

  //Defining route rules we have certain properties like path(it's define URI and URL whcih maps to component)
  //redirectTo : Which is sending the URI/URL controls to another URL
  //pathMath: which is basically matching the absolute path of the URL/URL
  //Component: Responsible to map respective Angular component
  
  //Path for User dashboard
  { path : '', component:  DashboardUserComponent,

  children: [
    { path: '', redirectTo: 'normalOrder', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'signup', component: SignupComponent },
    { path: 'updatePassword', component: UpdatePasswordComponent }
    ]},
   
  //path for Professor dashboard
  {
    path: 'professor', component: DashboardProfessorComponent,
    children: [
      { path: '', redirectTo: 'normalOrder', pathMatch: 'full' },
      { path: 'registeredCourse', component: RegisteredCourseComponent },
      { path: 'viewCourse', component: ViewCourseComponent },
      { path: 'grade', component: AddGradeComponent },
    ]
  },
  
  //path for Admin Dashboard
  { path : 'admin',component: AdminComponentComponent,
  children:[
      { path: '', redirectTo: 'admin', pathMatch: 'full'},
      { path: 'professor', component: AddProfessorComponent },
      { path: 'approveStudent', component: ApproveStudentComponent },
      { path: 'editCourse', component: EditCourseComponent }
      ]
    },

    //path for Student Dashboard
    {
      path: 'dashboardstudent', component: DashboardStudentComponent,
      children: [
      { path: '', redirectTo: 'customer', pathMatch: 'full' },
      { path: 'registeredCourse', component: MyRegisteredCourseComponent },
      { path: 'grade', component: MyGradeCardComponent },
      { path: 'courseRegistration', component: MyCourseRegistrationComponent },
      {
      path: 'payment', component: MyCreditCardComponent,
      // children: [
      // { path: '', redirectTo: 'normalOrder', pathMatch: 'full' },
      // { path: 'creditCard', component: MyCreditCardComponent },
      // { path: 'debitCard', component: MyDebitCardComponent },
      // ]
      },
      ]
      }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
