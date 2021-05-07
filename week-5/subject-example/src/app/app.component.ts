import { Component } from '@angular/core';
import { PokemonService } from './pokemon.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  pokemonIdInput: string;

  constructor(private pokemonService: PokemonService) { }

  onGetPokemonClick() {
    this.pokemonService.publishPokemon(this.pokemonIdInput);
  }
}
