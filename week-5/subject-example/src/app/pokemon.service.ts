import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Pokemon } from 'src/models/pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  private subject: Subject<Pokemon>;

  constructor(private httpClient: HttpClient ) {
    this.subject = new Subject();
  }

  async publishPokemon(pokemonId: string): Promise<void> {
    const pokemon: Pokemon = await this.httpClient.get<Pokemon>(`https://pokeapi.co/api/v2/pokemon/${pokemonId}`).toPromise();

    this.subject.next(pokemon);
  }

  getSubject(): Subject<Pokemon> {
    return this.subject
  }
}
