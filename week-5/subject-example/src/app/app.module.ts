import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { PokemonService } from './pokemon.service';
import { LatestPokemonComponent } from './latest-pokemon/latest-pokemon.component';
import { PokemonTableComponent } from './pokemon-table/pokemon-table.component';

@NgModule({
  declarations: [
    AppComponent,
    LatestPokemonComponent,
    PokemonTableComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [PokemonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
