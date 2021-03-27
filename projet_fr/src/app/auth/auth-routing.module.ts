import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { NgxLoginComponent } from './login/login.component';
import {RegisterComponent} from "./register/register.component"; // <---

export const routes: Routes = [
  {
    path: 'login',
    component: NgxLoginComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class NgxAuthRoutingModule {
}
