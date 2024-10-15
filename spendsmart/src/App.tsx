import './index.css'
import { Register } from "./components/Register"
import {Route,BrowserRouter as  Router, Routes } from 'react-router-dom'
import { SignIn } from './components/Singn in'

function App() {
  return (
    <div>
      <Router>
      <Routes>
      <Route path="/Register" Component={Register} />
      <Route path='/SignIn' Component={SignIn}></Route>
    </Routes>
  </Router></div>
  )
}

export default App
