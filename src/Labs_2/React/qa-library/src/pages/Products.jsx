import React, { useState } from 'react';
import '../assets/css/products.css';
import ProductsList from '../components/ProductsList';
import useProducts from '../services/productApi';
import { BasketItem } from '../models/BasketItem';

const basketStorageKey = 'qa-library-basket';

function Products({ onBasketCountChange }) {
    const { products, loading, error } = useProducts();
    const [addedMessage, setAddedMessage] = useState('');
    const [basketItems, setBasketItems] = useState(() => {
        try {
            const savedItems = JSON.parse(localStorage.getItem(basketStorageKey) ?? '[]');
            return Array.isArray(savedItems) ? savedItems : [];
        } catch {
            return [];
        }
    });

    function handleAddToBasket(product) {

        const existingItem = basketItems.find((item) => item.id === product.id);
        let updatedItems;
        let quantity;
        if (existingItem) {
            if (existingItem.quantity >= existingItem.unitsInStock) return;
            quantity = existingItem.quantity + 1;
            updatedItems = basketItems.map((item) => item.id === product.id
                ? { ...item, quantity }
                : item);
        } else {
            if (product.UnitsInStock < 1) return;
            quantity = 1;
            updatedItems = [...basketItems, new BasketItem(
                product.id,
                product.ProductName,
                product.UnitPrice,
                product.UnitsInStock,
            )];
        }

        localStorage.setItem(basketStorageKey, JSON.stringify(updatedItems));
        setBasketItems(updatedItems);
        onBasketCountChange(updatedItems.reduce((count, item) => count + item.quantity, 0));
        setAddedMessage(`${product.ProductName} added to basket (quantity ${quantity}).`);
    }

    return (
        <div className="products">
            <section className="products-heading">
                <h1>Products</h1>
                <p className="basket-message" role="status" aria-live="polite">{addedMessage}</p>
            </section>
            {loading && <p>Loading products...</p>}
            {error && <p role="alert">Could not load products: {error}</p>}
            {!loading && !error && <ProductsList products={products} handleAddToBasket={handleAddToBasket} basketItems={basketItems} />}
        </div>
    );
}

export default Products;