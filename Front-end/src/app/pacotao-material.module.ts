import { NgModule } from '@angular/core';
import { CommonModule, NgStyle } from '@angular/common';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { CustomInterceptor } from './custom.interceptor';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatToolbarModule, 
    MatIconModule, 
    MatButtonModule,
    MatSidenavModule, 
    MatListModule,
    HttpClientModule, 
    RouterModule,
    NgStyle,
    MatInputModule,
    ReactiveFormsModule,
  ],exports: [
    CommonModule,
    MatToolbarModule, 
    MatIconModule, 
    MatButtonModule,
    MatSidenavModule, 
    MatListModule,
    HttpClientModule, 
    RouterModule,
    ReactiveFormsModule,
    MatInputModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: CustomInterceptor, multi: true }
  ]
})
export class PacotaoMaterialModule { }
