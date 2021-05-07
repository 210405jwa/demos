import { Component } from '@angular/core';
import { Pokemon } from 'src/model/pokemon';

import { MyFirstService } from './my-first.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  pokemonIdInput: string;
  myFirstService: MyFirstService; // If you don't have the private keyword, a property will be 'public'
  // There is no 'default' access modifier like in Java, only public and private

  pokemons: Pokemon[] = [];

  constructor(myFirstService: MyFirstService) {
    this.myFirstService = myFirstService;
  }

  onGetPokemonClick() {
    this.myFirstService.getPokemon(this.pokemonIdInput).subscribe((pokemon) => {
      this.pokemons.push(pokemon);
    });
  }

}
