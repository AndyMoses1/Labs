import ProductCard from './ProductCard';
import '../assets/css/products.css';
import '../assets/css/buttons.css';

function ProductsList({ products, handleAddToBasket, basketItems = [] }) {
	if (products.length === 0) {
		return <p>No products found.</p>;
	}

	return (
		<div className="products-list">
			{products.map((product) => {
				const basketItem = basketItems.find((item) => item.id === product.id);
				const quantityInBasket = basketItem?.quantity ?? 0;
				const noMoreProducts = quantityInBasket >= product.UnitsInStock;

				return <ProductCard key={product.id}>
                    <div className="product-details">
                        <h2>{product.ProductName}</h2>
                        <p>Price: {product.UnitPrice}</p>
                    </div>
                    <div className="product-actions">
						{noMoreProducts ? (
							<p role="status">No more product</p>
						) : (
							<button className="btn btn-primary" onClick={() => handleAddToBasket(product)}>Add to Basket</button>
						)}
                    </div>
				</ProductCard>;
			})}
		</div>
	);
}

export default ProductsList;