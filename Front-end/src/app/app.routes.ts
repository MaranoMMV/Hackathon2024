import { Routes } from '@angular/router';
import { HomeMenuComponent } from './home/template/home-menu/home-menu.component';
import { HomeComponent } from './home/home/home.component';
import { HomeInteresseAdocaoComponent } from './home/home-interesse-adocao/home-interesse-adocao.component';
import { HomeOngsComponent } from './home/home-ongs/home-ongs.component';

export const routes: Routes = [
    {
        path: '', component: HomeMenuComponent, children: [
            { path: '', component: HomeComponent},
            { path: 'interesseAdocao', component: HomeInteresseAdocaoComponent},
            {  path:  'ongs', component: HomeOngsComponent}
        ]
    }
];
