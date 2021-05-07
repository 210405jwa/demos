import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/models/pokemon';
import { PokemonService } from '../pokemon.service';

@Component({
  selector: 'app-latest-pokemon',
  templateUrl: './latest-pokemon.component.html',
  styleUrls: ['./latest-pokemon.component.css']
})
export class LatestPokemonComponent implements OnInit {

  latestPokemon: Pokemon;

  constructor(private pokemonService: PokemonService) {
    this.pokemonService.getSubject().subscribe((pokemon) => {
      this.latestPokemon = pokemon;
    });
  }

  ngOnInit(): void {
  }

}
