import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MultiplatsSaveComponent } from './multiplats-save/multiplats-save.component';
import { MultiplatsViewComponent } from './multiplats-view/multiplats-view.component';



@NgModule({
  declarations: [
    MultiplatsViewComponent,
    MultiplatsSaveComponent
  ],
  imports: [
    CommonModule
  ]
})
export class MultiplatsModule { }
