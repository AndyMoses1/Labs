import { useState } from 'react';
import { Link } from "react-router-dom";
import '../assets/css/buttons.css';
import '../assets/css/basket.css';

const basketStorageKey = 'qa-library-basket';

function loadBasketItems() {
    try {
        const items = JSON.parse(localStorage.getItem(basketStorageKey) ?? '[]');
        return Array.isArray(items) ? items : [];
    } catch {
        return [];
    }
}

function Basket({ onBasketCountChange }) {
    const [items, setItems] = useState(loadBasketItems);
    const total = items.reduce((sum, item) => sum + item.unitPrice * item.quantity, 0);

    function updateQuantity(itemId, change) {
        const updatedItems = items.flatMap((item) => {
            if (item.id !== itemId) return [item];

            const quantity = item.quantity + change;
            if (quantity < 1) return [];
            if (quantity > item.unitsInStock) return [item];

            return [{ ...item, quantity }];
        });

        setItems(updatedItems);
        localStorage.setItem(basketStorageKey, JSON.stringify(updatedItems));
        onBasketCountChange(updatedItems.reduce((count, item) => count + item.quantity, 0));
    }

    return (
        <div className="basket">
            <h1>Basket</h1>
            {items.length === 0 ? (
                <p>Your basket is empty.</p>
            ) : (
                <>
                    <div className="basket-items">
                        {items.map((item) => (
                            <div key={item.id} className="basket-item">
                                <div className="basket-details">
                                    <strong>{item.productName}</strong> x {item.quantity} - {(item.unitPrice * item.quantity).toFixed(2)}
                                </div>

                                <div className="basket-item-actions">
                                    <button
                                        type="button"
                                        className="btn btn-danger"
                                        onClick={() => updateQuantity(item.id, -1)}
                                        aria-label={`Decrease ${item.productName} quantity`}
                                    >-</button>

                                    <button
                                        type="button"
                                        className="btn btn-success"
                                        onClick={() => updateQuantity(item.id, 1)}
                                        disabled={item.quantity >= item.unitsInStock}
                                        aria-label={`Increase ${item.productName} quantity`}
                                    >+</button>
                                </div>
                            </div>
                        ))}
                    </div>
                    <p><strong>Total: {total.toFixed(2)}</strong></p>

                    <div className="basket-actions">
                        <button className="btn btn-danger" onClick={() => {
                            localStorage.removeItem(basketStorageKey);
                            setItems([]);
                            onBasketCountChange(0);
                        }}>
                            Clear Basket
                        </button>
                        <Link className="btn btn-primary" to="/checkout">
                            Checkout
                        </Link>
                    </div>
                </>
            )}
        </div>
    );
}

export default Basket;