export interface Pokemon {
  // we place all properties here that we want to utilize in our Angular app
  // the entire PokeAPI response is definitely much more complex and verbose than the properties here
  id: number;
  name: string;
  height: number;
  weight: number;
  base_experience: number;
  sprites: { front_default: string }

}
