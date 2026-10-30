import Card from './Card.jsx'
import '../assets/css/btn.css'

function BlogList(props) {
  return (
    <div>
      {props.blogs.map((blog) => (
        <Card key={blog.id}>
          <h2>{blog.title}</h2>
          <p>By {blog.author}</p>
          <p>{blog.body}</p>
          <button className="btn btn-danger" onClick={() => props.deleteBlog(blog.id)}>Delete</button>
        </Card>
      ))}
    </div>
  );
}

export default BlogList;