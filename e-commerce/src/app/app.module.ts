import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MaterialModule } from './material/materialmodule.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { ProductListComponent } from './product-list/product-list.component';
import { CartComponent } from './cart/cart.component';
import { CartListComponent } from './cart-list/cart-list.component';
import { DetailsComponent, MyDialog } from './details/details.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    CartComponent,
    CartListComponent,
    DetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MaterialModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [
    { provide: CartComponent, useClass: CartComponent },

  ],
  entryComponents: [MyDialog],
  bootstrap: [AppComponent]
})
export class AppModule { }
