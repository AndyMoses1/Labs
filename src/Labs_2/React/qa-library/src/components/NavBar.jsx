import { Link } from "react-router-dom";
import '../assets/css/navbar.css';

function NavBar({ basketCount }) {
    return (
        <nav>

            <ul>
                <li><Link to='/'>Home</Link></li>
                <li><Link to='/products'>Products</Link></li>
                <li>
                    {basketCount > 0
                        ? <Link className="basket-nav-link" to='/basket'><span>Basket</span><span className="basket-count">{basketCount}</span></Link>
                        : <span className="nav-disabled basket-nav-link" aria-disabled="true"><span>Basket</span><span className="basket-count">{basketCount}</span></span>}
                </li>
                <li><Link to='/checkout'>Checkout</Link></li>
            </ul>
        </nav>
    );
}

export default NavBar;