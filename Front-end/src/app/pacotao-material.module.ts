import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';



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
  ],exports: [
    CommonModule,
    MatToolbarModule, 
    MatIconModule, 
    MatButtonModule,
    MatSidenavModule, 
    MatListModule,
    HttpClientModule, 
    RouterModule,
  ]
})
export class PacotaoMaterialModule { }
