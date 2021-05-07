import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SpeedComponent } from './speed/speed.component';
import { TemperatureComponent } from './temperature/temperature.component';
import { MphToKphPipe } from './mph-to-kph.pipe';

@NgModule({
  declarations: [
    AppComponent,
    SpeedComponent,
    TemperatureComponent,
    MphToKphPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
