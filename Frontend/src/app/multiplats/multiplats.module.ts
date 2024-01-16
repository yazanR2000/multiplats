import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MultiplatsViewComponent } from './multiplats-view/multiplats-view.component';
import { MultiplatsSaveComponent } from './multiplats-save/multiplats-save.component';



@NgModule({
  declarations: [
    MultiplatsViewComponent,
    MultiplatsSaveComponent
  ],
  imports: [
    CommonModule, 
    FormsModule
  ]
})
export class MultiplatsModule { }
