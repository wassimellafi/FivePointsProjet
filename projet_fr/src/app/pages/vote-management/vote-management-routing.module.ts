import { ExtraOptions, RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import {SubjetListComponent} from './subjet-list/subjet-list.component';

export const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'sujet-list',
        component: SubjetListComponent,
      },
    ],
  }];

const config: ExtraOptions = {
  useHash: false,
};

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class VoteManagementRoutingModule {
}
