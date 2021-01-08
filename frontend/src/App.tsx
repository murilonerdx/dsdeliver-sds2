import React from 'react';
import './App.css';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Navbar from './Navbar';
import Routes from './Routes';
function App() {
  return (
    <>
      <Routes/>
      <ToastContainer/>
    </>
  );
}

export default App;
