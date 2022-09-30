import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FavmoviedetailsComponent } from './favmoviedetails/favmoviedetails.component';
import { FavoriteComponent } from './favorite/favorite.component';
import { CardguardGuard } from './guard/cardguard.guard';
import { FavGuard } from './guard/fav.guard';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MoviedetailsComponent } from './moviedetails/moviedetails.component';
import { RegisterComponent } from './register/register.component';
import { SearchResultComponent } from './search-result/search-result.component';
import { SearchbarresultComponent } from './searchbarresult/searchbarresult.component';

const routes: Routes = [
  {path:"",component:HomeComponent},
  {
    path:"searchresult" ,component:SearchResultComponent
  },
  {
    path:"searchbar", component:SearchbarresultComponent
  },
  {
    path:"moviedata",component:MoviedetailsComponent
   , canActivate:[CardguardGuard]
  },{
    path:"favourite", component:FavoriteComponent
    ,canActivate:[FavGuard]
  },
  {
    path:"login",component:LoginComponent
  },
  {
    path:"register",component:RegisterComponent
  },{
    path:"favdetails",component:FavmoviedetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
