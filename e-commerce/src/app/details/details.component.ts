import { Component, Inject, ViewEncapsulation } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { CartComponent } from '../cart/cart.component';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-details',
  template: '',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent {

  product: any;
  /*
  constructor(private router: Router, private cart: CartComponent) {
    this.product = router.getCurrentNavigation()?.extras.state
    this.product = this.product.product;
  }*/

  constructor(private router: Router, private dialog: MatDialog) {
    this.product = router.getCurrentNavigation()?.extras.state;
    this.product = this.product.product;

    this.openDialog()
  }

  openDialog = () => {
    const dialogRef = this.dialog.open(MyDialog, { data: { product: this.product } });
    dialogRef.afterClosed().subscribe(
      () => this.goBack()
    )
  }

  goBack = () => {
    this.router.navigateByUrl("/product-list")
  }

}

@Component(
  {
    selector: "my-dialog",
    templateUrl: "details.component.html",
    styleUrls: ["details.component.scss"],
    encapsulation: ViewEncapsulation.None
  }
)
export class MyDialog {
  product: any;
  constructor(@Inject(MAT_DIALOG_DATA) private data: any, private cart: CartComponent, public dialogRef: MatDialogRef<any>,
  ) {
    this.product = this.data.product;
  }

  addToCart = () => {
    this.cart.addToCart(this.product)
  }

  close = () => {
    this.dialogRef.close()
  }


}

