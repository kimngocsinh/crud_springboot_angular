import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddThamsoComponent } from './add-thamso/add-thamso.component';
import { EditThamsoComponent } from './edit-thamso/edit-thamso.component';
import { ListThamsoComponent } from './list-thamso/list-thamso.component';

const routes: Routes = [
  {path: '', component:ListThamsoComponent},
  {path: 'add', component:AddThamsoComponent},
  {path: 'edit', component:EditThamsoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
