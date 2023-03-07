import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListThamsoComponent } from './list-thamso/list-thamso.component';
import { FormsModule } from '@angular/forms';
import { AddThamsoComponent } from './add-thamso/add-thamso.component';
import { EditThamsoComponent } from './edit-thamso/edit-thamso.component';

@NgModule({
  declarations: [
    AppComponent,
    ListThamsoComponent,
    AddThamsoComponent,
    EditThamsoComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
