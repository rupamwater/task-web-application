import { useState } from 'react'
import './App.css'
import ListProjectComponent from './components/ListProjectComponent'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import {BrowserRouter } from 'react-router-dom'


function App() {
  const [count, setCount] = useState(0)

  return (
    <>
       <HeaderComponent/>
       <ListProjectComponent/>
       <FooterComponent/>
    </>
  )
}

export default App
