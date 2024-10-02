import Login from './login';
import Main from './main';
import Profile from './profile';
import ProfileInput from './profile.input';
import Regist from './regist';
// import findInfo from './findInfo'
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Portfolio from './portfolio';
import InputPortfolio from './portfolio_input';

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path='/Login' element={<Login />} />
        <Route path='/regist' element={<Regist />} />
        <Route path='/Login' element={<Login />} />
        <Route path="/ProfileInput" element={<ProfileInput />} />
        <Route path="/Profile" element={<Profile />} />
        <Route path="/Portfolio" element={<Portfolio />} />
        <Route path="/PortfolioInput" element={<InputPortfolio />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
