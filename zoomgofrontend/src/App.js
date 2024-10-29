import Login from './login';
import Main from './main';
import Profile from './profile';
import ProfileInput from './profile.input';
import Regist from './regist';
// import findInfo from './findInfo'
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import AskEstimate from './ask_estimate';
import CategoryPortfolio from './category_portfolio';
import ExportEstimate from './exportEstimate';
import ReceiveAsk from './gosu_receive_ask';
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
        <Route path='/ExportEstimate' element={<ExportEstimate />} />
        <Route path="/ProfileInput" element={<ProfileInput />} />
        <Route path="/Profile" element={<Profile />} />
        <Route path="/Portfolio" element={<Portfolio />} />
        <Route path="/PortfolioInput" element={<InputPortfolio />} />
        <Route path="/categoryPorfolio" element={<CategoryPortfolio />} />
        <Route path="/askEstimate" element={<AskEstimate />} />
        <Route path="/receiveAsk" element={<ReceiveAsk />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
