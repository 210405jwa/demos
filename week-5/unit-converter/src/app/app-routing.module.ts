import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SpeedComponent } from './speed/speed.component';
import { TemperatureComponent } from './temperature/temperature.component';

const routes: Routes = [
  { path: 'speed', component: SpeedComponent },
  { path: 'temperature', component: TemperatureComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
