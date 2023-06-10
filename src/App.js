import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginPage from './login/login';
import MainPage from './MainPage';


// function App() {
//   return (
//     <div className="App">
//       {/* <LoginPage /> */}
//       <Router>
//         <Routes>        
//           <Route path="/login" exact={true} element={<LoginPage />} />
//           <Route path="/main" element={<div><NavBar/><Layout/></div>} />
//           <Route path="*" exact={true} element={<LoginPage />} />
//         </Routes>
//       </Router>
//     </div>


//   );
// }

// export default App;
function App() {
  return (
    <div className="App">
      <Router>
        <Routes>        
          <Route path="/login" exact={true} element={<LoginPage />} />
          <Route path="/main" element={<MainPage />} />
          <Route path="*" exact={true} element={<LoginPage />} />
        </Routes>
      </Router>
    </div>
  );
}



export default App;
