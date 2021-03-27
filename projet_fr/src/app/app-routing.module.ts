import { ExtraOptions, RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { AuthGuardService } from './services/auth/AuthGuard.service';

export const routes: Routes = [
  {
    path: 'auth',
    loadChildren:() => import('./auth/auth.module').then(m=> m.NgxAuthModule),

  },
  {
   //canActivate: [AuthGuardService],
    path: 'zen-people-referential',
    loadChildren: () => import('./pages/pages.module')
      .then(m => m.PagesModule),
  },

  { path: '', redirectTo: 'auth', pathMatch: 'full' },
  { path: '**', redirectTo: 'zen-people-referential' },
];

const config: ExtraOptions = {
  useHash: false,
};

@NgModule({
  imports: [RouterModule.forRoot(routes, config)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
