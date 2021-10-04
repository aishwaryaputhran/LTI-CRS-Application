import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { LoggerModule, NgxLoggerLevel } from 'ngx-logger';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestpipePipe } from './pipe/testpipe.pipe';
import { HighlightdirectiveDirective } from './directive/highlightdirective.directive';
import { DashboardProfessorComponent } from './dashboard-professor/dashboard-professor.component';
import { AdminComponentComponent } from './admin-component/admin-component.component';
import { RegisteredCourseComponent } from './registered-course/registered-course.component';
import { ViewCourseComponent } from './view-course/view-course.component';
import { AddGradeComponent } from './add-grade/add-grade.component';
import { AddProfessorComponent } from './add-professor/add-professor.component';
import { ApproveStudentComponent } from './approve-student/approve-student.component';
import { EditCourseComponent } from './edit-course/edit-course.component';
import { LoginComponent } from './login/login.component';
import { DashboardUserComponent } from './dashboard-user/dashboard-user.component';
import { SignupComponent } from './signup/signup.component';
import { UpdatePasswordComponent } from './update-password/update-password.component';
import { DashboardStudentComponent } from './dashboard-student/dashboard-student.component';
import { MyCourseRegistrationComponent } from './my-course-registration/my-course-registration.component';
import { MyCreditCardComponent } from './my-credit-card/my-credit-card.component';
import { MyGradeCardComponent } from './my-grade-card/my-grade-card.component';
import { MyPaymentComponent } from './my-payment/my-payment.component';
import { MyRegisteredCourseComponent } from './my-registered-course/my-registered-course.component';
// import { CustomerComponentComponent } from './customer-component/customer-component.component';
// import { MyStudentComponent } from './my-student/my-student.component';
// import { MyRegisteredCourseComponent } from './my-registered-course/my-registered-course.component';
// import { MyCourseRegistrartionComponent } from './my-course-registrartion/my-course-registrartion.component';
// import { MyGradeCardComponent } from './my-grade-card/my-grade-card.component';
// import { MyPaymentComponent } from './my-payment/my-payment.component';
// import { MycreditCardComponent } from './mycredit-card/mycredit-card.component';
// import { MyDebitCardComponent } from './my-debit-card/my-debit-card.component';
// import { MyCreditCardComponent } from './my-credit-card/my-credit-card.component';
// import { DashboardStudentComponent } from './dashboard-student/dashboard-student.component';
// import { LoginComponent } from './login/login.component';
// import { DashboardUserComponent } from './dashboard-user/dashboard-user.component';

@NgModule({
  declarations: [
    AppComponent,
    TestpipePipe,
    HighlightdirectiveDirective,
    AdminComponentComponent,
    DashboardProfessorComponent,
    RegisteredCourseComponent,
    ViewCourseComponent,
    AddGradeComponent,
    AddProfessorComponent,
    ApproveStudentComponent,
    EditCourseComponent,
    LoginComponent,
    DashboardUserComponent,
    SignupComponent,
    UpdatePasswordComponent,
    DashboardStudentComponent,
    MyCourseRegistrationComponent,
    MyCreditCardComponent,
    MyGradeCardComponent,
    MyPaymentComponent,
    MyRegisteredCourseComponent
    // CustomerComponentComponent,
    // MyStudentComponent,
    // MyRegisteredCourseComponent,
    // MyCourseRegistrartionComponent,
    // MyGradeCardComponent,
    // MyPaymentComponent,
    // MycreditCardComponent,
    // MyDebitCardComponent,
    // MyCreditCardComponent,
    // DashboardStudentComponent,
    // LoginComponent,
    // DashboardUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    LoggerModule.forRoot({serverLoggingUrl: '/users/logs', level: NgxLoggerLevel.DEBUG, serverLogLevel: NgxLoggerLevel.ERROR})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
