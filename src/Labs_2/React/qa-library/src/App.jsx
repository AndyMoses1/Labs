import { useState } from 'react'
import './App.css'
import NavBar from './components/NavBar'
import { Routes, Route } from 'react-router-dom'
import Welcome from './pages/Welcome'
import NotFound from './pages/NotFound'
import Basket from './pages/Basket'
import Products from './pages/Products'
import Checkout from './pages/Checkout'

const basketStorageKey = 'qa-library-basket'

function getBasketCount() {
  try {
    const items = JSON.parse(localStorage.getItem(basketStorageKey) ?? '[]')
    return Array.isArray(items)
      ? items.reduce((count, item) => count + (Number(item.quantity) || 0), 0)
      : 0
  } catch {
    return 0
  }
}

function App() {
  const [basketCount, setBasketCount] = useState(getBasketCount)

  return (
    <>
      <NavBar basketCount={basketCount} />
      <main>
        <Routes>
          <Route path="/" element={<Welcome />} />
          <Route path="/products" element={<Products onBasketCountChange={setBasketCount} />} />
          <Route path="/basket" element={<Basket onBasketCountChange={setBasketCount} />} />
          <Route path="/checkout" element={<Checkout onBasketCountChange={setBasketCount} />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </main>
    </>
  )
}

export default App
