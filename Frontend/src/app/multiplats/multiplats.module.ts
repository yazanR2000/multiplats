import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MultiplatsSaveComponent } from './multiplats-save/multiplats-save.component';
import { MultiplatsViewComponent } from './multiplats-view/multiplats-view.component';
import { FormsModule } from '@angular/forms';



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
