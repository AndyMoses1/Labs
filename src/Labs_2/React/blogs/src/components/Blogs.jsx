import { useEffect, useState } from 'react'
import blogData from '../data.json'
import BlogList from './BlogList'

function Blogs() {
  const [data, setData] = useState(null);

  useEffect(() => {
    fetch('http://localhost:4000/data')
      .then(res => {
        return res.json();
      }).then(data => {
        setData(data);
      })
  }, []);

  const deleteBlog = (blogId) => {
    setData((data) => data.filter((blog) => blog.id !== blogId));
  };

  return (
    <>
      <h1>Hello World!</h1>
      <div>This is the data:</div>
      {data && <BlogList blogs={data} deleteBlog={deleteBlog} />}
    </>
  )
}

export default Blogs
