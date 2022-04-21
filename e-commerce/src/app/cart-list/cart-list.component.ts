import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartComponent } from '../cart/cart.component';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.scss']
})
export class CartListComponent {

  constructor(private cart: CartComponent, private router: Router) { }


  isEmptyCart = () => {
    return this.cart.cartList.length > 0;
  }

  getCart() {
    return this.cart.cart;
  }

  get price() {

    return this.cart.price

  }

  buy = () => {
    this.cart.buyAll()
    this.router.navigateByUrl("product-list")
  }
}
