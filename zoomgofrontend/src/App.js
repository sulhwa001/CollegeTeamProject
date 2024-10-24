
import './App.css';
import Header from './header/Header.js';
import Registpage from './registpage/Registpage.js';
import Loginpage from './loginpage/Loginpage.js';
import Forgotpassword from './forgotpassword/forgotpassword.js';
import Userinfo from './userinfo';
import Agreement from './agreement/agreement.js';
import Mypagemain from './mypagemain/Mypagemain.js';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

function App() {
  return (
    <Router>
      <div className="App">
      <Header />
        <Routes>
          <Route path="/" element={<Loginpage />} />
          <Route path="/regist" element={<Registpage />} />
          <Route path="/forgotpassword" element={<Forgotpassword />} />
          <Route path="/userinfo" element={<Userinfo />} />
          <Route path="/agreement" element={<Agreement/>} />
          <Route path="/mypagemain" element={<Mypagemain/>} />
          
        </Routes>
      </div>
    </Router>
  );
}

export default App;
