import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MenuModule} from 'primeng/menu';
import {TabViewModule} from 'primeng/tabview';
import {TableModule} from 'primeng/table';
import {ButtonModule} from 'primeng/button';
import {InputTextModule} from 'primeng/inputtext';
import {CheckboxModule} from 'primeng/checkbox';

@NgModule({
  exports: [
    CommonModule,
    MenuModule,
    TabViewModule,
    TableModule,
    ButtonModule,
    InputTextModule,
    CheckboxModule
  ],
  declarations: []
})
export class PrimeNgModule { }
