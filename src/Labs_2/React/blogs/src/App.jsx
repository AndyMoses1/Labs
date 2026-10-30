import './App.css'
import Blogs from './components/Blogs'
import MainNavigation from './components/MainNavigation'
import { Routes, Route } from 'react-router-dom'
import NotFound from './components/NotFound'
import NewBlog from './components/NewBlog'
import QAPics from './components/QAPics'

function App() {
  return (
    <>
      <MainNavigation />
      <Routes>
        <Route path='/' element={<Blogs />} />
        <Route path="/new" element={<NewBlog />} />
        <Route path="/qa/pics/:id" element={<QAPics />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </>
  )
}

export default App
