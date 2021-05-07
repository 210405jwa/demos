import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { GeneratorComponent } from './generator/generator.component';
import { NgforexampleComponent } from './ngforexample/ngforexample.component';
import { NgswitchexampleComponent } from './ngswitchexample/ngswitchexample.component';
import { LengthInputComponent } from './length-input/length-input.component';

@NgModule({
  declarations: [
    AppComponent,
    GeneratorComponent,
    NgforexampleComponent,
    NgswitchexampleComponent,
    LengthInputComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
