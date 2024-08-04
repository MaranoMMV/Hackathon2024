import { Routes } from '@angular/router';
import { HomeMenuComponent } from './home/template/home-menu/home-menu.component';
import { HomeComponent } from './home/home/home.component';
import { HomeInteresseAdocaoComponent } from './home/home-interesse-adocao/home-interesse-adocao.component';
import { HomeOngsComponent } from './home/home-ongs/home-ongs.component';
import { LoginComponent } from './login/pages/login/login.component';
import { AuthGuard } from './auth-guard.service';
import { SistemaComponent } from './sistema/sistema.component';

export const routes: Routes = [
    {
        path: '', component: HomeMenuComponent, children: [
            { path: '', component: HomeComponent},
            { path: 'interesseAdocao', component: HomeInteresseAdocaoComponent},
            {  path:  'ongs', component: HomeOngsComponent},

        ]
    },
    { path: 'login', component: LoginComponent },
    {
        path: 'sistema',
        component: SistemaComponent,
        canActivate: [AuthGuard],
        children: [
            
        ]
    }
];
