import { useState } from "react";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";

function NewBlog() {
    const [name, setName] = useState("");
    const [title, setTitle] = useState("");
    const [age, setAge] = useState(0);
    const [message, setMessage] = useState("");
    const history = useNavigate();


    const handleSubmit = (event) => {
        event.preventDefault();
        const data = JSON.stringify({ "author": name, "title": title, "message": message });

        fetch("http://localhost:4000/data", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: data,
        }).then(() => {
            history('/')
        });
    }

    return (
        <>
            <div>New Blog</div>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="name">Name:</label>
                    <input
                        type="text"
                        id="name"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                    />
                </div>
                <div>
                    <label htmlFor="title">Title:</label>
                    <input
                        type="text"
                        id="title"
                        value={title}
                        onChange={(e) => setTitle(e.target.value)}
                    />
                </div>
                <div>
                    <label htmlFor="age">Age:</label>
                    <input
                        type="number"
                        id="age"
                        value={age}
                        onChange={(e) => setAge(Number(e.target.value))}
                    />
                </div>
                <div>
                    <label htmlFor="message">Message:</label>
                    <textarea
                        id="message"
                        value={message}
                        onChange={(e) => setMessage(e.target.value)}
                    />
                </div>
                <button type="submit">Submit</button>
            </form>
        </>
    );
}

export default NewBlog;