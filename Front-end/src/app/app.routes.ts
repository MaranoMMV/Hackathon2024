import { Routes } from '@angular/router';
import { HomeMenuComponent } from './home/template/home-menu/home-menu.component';
import { HomeComponent } from './home/home/home.component';
import { HomeInteresseAdocaoComponent } from './home/home-interesse-adocao/home-interesse-adocao.component';
import { HomeOngsComponent } from './home/home-ongs/home-ongs.component';
import { LoginComponent } from './login/pages/login/login.component';
import { AuthGuard } from './auth-guard.service';
import { SistemaComponent } from './sistema/sistema.component';
import { SistemaMenuComponent } from './sistema/template/sistema-menu/sistema-menu.component';
import path from 'path';
import { SistemaPublicacaoComponent } from './sistema/publicacao/sistema-publicacao/sistema-publicacao.component';
import { SistemaPublicacaoFormComponent } from './sistema/publicacao/sistema-publicacao-form/sistema-publicacao-form.component';

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
        component: SistemaMenuComponent,
        canActivate: [AuthGuard],
        children: [
            {
                path: '', component: SistemaComponent,

            },
            { path: 'minhaspublicacoes', component: SistemaPublicacaoComponent },
            { path: 'minhaspublicacoes/form', component: SistemaPublicacaoFormComponent},
            { path: 'minhaspublicacoes/form/:id', component: SistemaPublicacaoFormComponent}
        ]
    }
];
