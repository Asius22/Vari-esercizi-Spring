import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { CartListComponent } from './cart-list/cart-list.component';
import { DetailsComponent } from './details/details.component';
import { ProductListComponent } from './product-list/product-list.component';

const routes: Routes = [
  {
    path: "product-list", component: ProductListComponent, children: [
      { path: "details", component: DetailsComponent }
    ]
  },
  { path: "cart-list", component: CartListComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
