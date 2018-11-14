import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MenuModule} from 'primeng/menu';
import {TabViewModule} from 'primeng/tabview';

@NgModule({
  exports: [
    CommonModule,
    MenuModule,
    TabViewModule
  ],
  declarations: []
})
export class PrimeNgModule { }
