import { Component } from '@angular/core';
import { CartComponent } from './cart/cart.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  constructor(private cart: CartComponent) { }
  getLenght = () => {
    return this.cart.cartList.length
  }
  title = 'e-commerce';
}
