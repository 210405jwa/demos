import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { Pokemon } from 'src/models/pokemon';
import { PokemonService } from '../pokemon.service';

@Component({
  selector: 'app-pokemon-table',
  templateUrl: './pokemon-table.component.html',
  styleUrls: ['./pokemon-table.component.css']
})
export class PokemonTableComponent implements OnInit {

  pokemons: Pokemon[] = [];

  constructor(private pokemonService: PokemonService) {
    this.pokemonService.getSubject().subscribe((pokemon) => {
      this.pokemons.push(pokemon);
    });
  }

  ngOnInit(): void {
  }

}
