import { e, PI } from './mathconstants';
import { Car } from './Car';

console.log(e);
console.log(PI);

const c = new Car(300, 'Red', 2010, 'Mustang');

console.log(c);
console.log(c.getHorsepower());