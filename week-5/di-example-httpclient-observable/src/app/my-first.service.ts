import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pokemon } from 'src/model/pokemon';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MyFirstService {

  constructor(private httpClient: HttpClient) { }

  getPokemon(pokemonId: string): Observable<Pokemon> {

    // Here we will utilize httpClient to send HTTP Requests and receive a response.
    // httpClient.get(...) for example, returns an Observable instead of a Promise like we are used to
    // when using the fetch API.

    // Observables are similar to promises, except for Observable COULD contain a "stream" of values
    // rather than just a single value

    // In this case, the observable only emits a single value, because http only responds once per request
    return this.httpClient.get<Pokemon>(`https://pokeapi.co/api/v2/pokemon/${pokemonId}`, {
      withCredentials: true,
    });
  }

}
