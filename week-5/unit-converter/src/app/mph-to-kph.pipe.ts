import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'mphToKph'
})
export class MphToKphPipe implements PipeTransform {

  transform(value: number, reverse: boolean = false): unknown {
    if (!reverse) {
      return value * 1.60934;
    } else {
      return value / 1.60934;
    }
  }

}
