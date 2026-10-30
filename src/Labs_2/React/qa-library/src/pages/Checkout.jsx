import { useState } from 'react';

const basketStorageKey = 'qa-library-basket';
const productsEndpoint = 'http://localhost:3000/products';

function loadBasketItems() {
    try {
        const items = JSON.parse(localStorage.getItem(basketStorageKey) ?? '[]');
        return Array.isArray(items) ? items : [];
    } catch {
        return [];
    }
}

function Checkout({ onBasketCountChange }) {
  const [basketItems, setBasketItems] = useState(loadBasketItems);
  const [checkoutError, setCheckoutError] = useState('');
  const [checkoutComplete, setCheckoutComplete] = useState(false);
  const [isSubmitting, setIsSubmitting] = useState(false);
  const total = basketItems.reduce((sum, item) => sum + item.unitPrice * item.quantity, 0);

  async function handleBuyNow() {
    if (basketItems.length === 0) {
      setCheckoutError('Your basket is empty. Please add items before checking out.');
      return;
    }

    setIsSubmitting(true);
    setCheckoutError('');
    setCheckoutComplete(false);

    try {
      for (const item of basketItems) {
        const response = await fetch(`${productsEndpoint}/${item.id}`, {
          method: 'PATCH',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({
            UnitsInStock: item.unitsInStock - item.quantity,
          }),
        });

        if (!response.ok) {
          throw new Error(`Could not update stock for ${item.productName}.`);
        }
      }

      localStorage.removeItem(basketStorageKey);
      setBasketItems([]);
      onBasketCountChange(0);
      setCheckoutComplete(true);
    } catch (error) {
      setCheckoutError(error.message);
    } finally {
      setIsSubmitting(false);
    }
  }

  return (
    <div>
      <h1>Checkout</h1>
      {checkoutError && <p role="alert">{checkoutError}</p>}
      {checkoutComplete && <p role="status">Purchase complete. Product stock has been updated.</p>}
      {(basketItems.length === 0) ? (
        <p>Your basket is empty.</p>
      ) : (
        <ul>
          {basketItems.map((item) => (
            <li key={item.id}>
              {item.productName} x {item.quantity} - {(item.unitPrice * item.quantity).toFixed(2)}
            </li>
          ))}
        </ul>
      )}

      <p><strong>Total: {total.toFixed(2)}</strong></p>
      <div className="checkout-actions">
        <button className="btn btn-success" onClick={handleBuyNow} disabled={isSubmitting || basketItems.length === 0}>
          {isSubmitting ? 'Processing...' : 'Buy Now'}
        </button>
      </div>
    </div>
  );
}

export default Checkout
