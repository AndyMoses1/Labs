import { Link } from "react-router-dom";

function MainNavigation() {

    return (
        <nav>

            <ul>
                <li><Link to='/'>All blogs</Link></li>
                <li><Link to='/qa/pics/1'>Pics 1</Link></li>
                <li><Link to='/qa/pics/2'>Pics 2</Link></li>
                <li><Link to='/new'>Create new Blog</Link></li>
            </ul>

        </nav>
    );
}

export default MainNavigation;
