import { HttpClient } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
@Injectable({
  providedIn: 'root'
})
export class CartComponent {
  cart: any[] = []
  constructor(private http: HttpClient) { }

  get cartList() {
    return this.cart;
  }

  addToCart(product: any) {
    this.cart.push(product)
  }

  get price() {
    let tot = 0;

    this.cart.forEach(element => tot += element.price)

    return tot;
  }

  buyAll = () => {
    if (this.cart.length == 0) return;
    this.http.post("http://localhost:8080/acquisti/", { body: this.cart }).subscribe(
      (response) => {
        if (response != null)
          this.cart = []
      }
    )
  }
}
