import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MultiplatsViewComponent } from './multiplats/multiplats-view/multiplats-view.component';
import { MultiplatsSaveComponent } from './multiplats/multiplats-save/multiplats-save.component';

const routes: Routes = [
  {
    path: '',
    component: MultiplatsViewComponent
  },
  {
    path: 'multiplats/view',
    component: MultiplatsViewComponent
  },
  {
    path: 'multiplats/save',
    component: MultiplatsSaveComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
