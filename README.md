## E-Commerce-Dummy
Spring Boot based application.

### Functional-APIs
* Register-user: http://localhost:8080/api/user/register
* Login-user: http://localhost:8080/api/user/login
* Cart-Items(add products in the cart): http://localhost:8080/api/cart-items
* Checkout(calculate the total price of the cart): http://localhost:8080/api/checkout
* Billing(make payment): http://localhost:8080/api/billing/process-payment <br>
  <br>
  // Adding a new product and updating the existing product using product id by the seller side
* Add-Product: http://localhost:8080/api/product
* Update-Product: http://localhost:8080/api/user/products/{productId}


### Non-Functional-APIs
* Order-History: http://localhost:8080/api/billing/process-payment


### Note
After proceeding to billing for a user once, User is unable to make bill again for the same checkoutId and When user is making payment, Payment is getting successfull and billing receipt is also generated but order history is not updating.

