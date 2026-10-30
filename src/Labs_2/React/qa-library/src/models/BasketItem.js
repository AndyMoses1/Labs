export class BasketItem {
    constructor(id, ProductName, UnitPrice, UnitsInStock, quantity = 1) {
      this.id = id
      this.productName = ProductName
      this.unitPrice = UnitPrice
      this.unitsInStock = UnitsInStock   // stored so the basket page can enforce the limit
      this.quantity = quantity
    }

    get lineTotal() {
      return this.unitPrice * this.quantity
    }
  }
