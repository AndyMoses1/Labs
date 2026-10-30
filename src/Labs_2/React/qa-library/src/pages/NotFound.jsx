import { Link } from "react-router-dom";

function NotFound() {
    return (
        <>
            <div>Sorry page not found</div>
            <Link to="/">back to home...</Link>
        </>
    );
}

export default NotFound;
