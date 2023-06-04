import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginPage from './login/login';
import HeaderArea from './HeaderArea/HeaderArea';

function App() {
  return (
    <div className="App">
      {/* <LoginPage /> */}
      <Router>
        <Routes>
          
          <Route path="/login" exact={true} element={<LoginPage />} />
          <Route path="/Headerarea" element={<HeaderArea />} />
          <Route path="*" exact={true} element={<LoginPage />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
