import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { IndexComponent } from './index/index.component';
import { AuthGuard } from './guard/auth.guard';
import { HouseholdAccountsComponent } from './household-accounts/household-accounts.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full', canActivate: [AuthGuard]},
  { path: 'index', component: IndexComponent},
  { path: 'login', component: LoginComponent},
  { path: 'logout', component: LogoutComponent},
  { path: 'household-accounts', component: HouseholdAccountsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
