import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { IndexComponent } from './index/index.component';
import { LogoutComponent } from './logout/logout.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HttpclientService } from './service/httpclient.service';
import { AuthGuard } from './guard/auth.guard';
import { AlertComponent } from './alert/alert.component';
import { HouseholdAccountsComponent } from './household-accounts/household-accounts.component';

@NgModule({
  declarations: [
    AlertComponent,
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    LogoutComponent,
    IndexComponent,
    HouseholdAccountsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [HttpclientService,AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
