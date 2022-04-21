import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartComponent } from '../cart/cart.component';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent {

  products: any[] = []
  constructor(private http: HttpClient, private cart: CartComponent, private router: Router) {
    http.get<any>("http://localhost:8080/products/").subscribe(
      (response) => {
        this.products = response;
      }
    )
  }

  addToCart = (p: any) => {
    this.cart.addToCart(p)
    console.log(this.cart.price)
  }

  showDescription = (p: any) => {
    this.router.navigateByUrl("product-list/details", {
      state: { product: p }
    })
  }

}
