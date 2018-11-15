import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MenuModule} from 'primeng/menu';
import {TabViewModule} from 'primeng/tabview';
import {CheckboxModule} from 'primeng/checkbox';
import {ScrollPanelModule} from 'primeng/scrollpanel';
import {ButtonModule} from 'primeng/button';

@NgModule({
  exports: [
    CommonModule,
    MenuModule,
    TabViewModule,
    CheckboxModule,
    ScrollPanelModule,
    ButtonModule
  ],
  declarations: []
})
export class PrimeNgModule { }
