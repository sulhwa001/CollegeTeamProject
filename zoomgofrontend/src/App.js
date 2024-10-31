import MainPage from './component/main.js'; // MainPage 컴포넌트 임포트
import RegistrationPage from './component/registration.js'; // RegistrationPage 컴포넌트 임포트
import Categorie from './component/categorie.js';
// import Header from './component/Header.js'; 
import ProductPage from './component/detailpage.js'
import AdminPage from './component/admin.js';
//import Header from './header/Header.js';
import Registpage from './registpage/Registpage.js';
import Loginpage from './loginpage/Loginpage.js';
import Forgotpassword from './forgotpassword/forgotpassword.js';
//import Userinfo from './userinfo';
import Agreement from './agreement/agreement.js';
import Mypagemain from './mypagemain/Mypagemain.js';
import './App.css';
import './index.css';
import BoardList from './Board/Board_List.js';
import InputText from './Board/Input.js';
import Detail from './Board/Detail.js';
import Recommand from './review/Recommand_modal.js';
import GosuReview from './review/Gosu_review.js';
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
      <div className="App">
      <BrowserRouter>
        <Routes>
          {/* <Route path="/" element={<Loginpage />} /> */}
          <Route path="/regist" element={<Registpage />} />
          <Route path="/forgotpassword" element={<Forgotpassword />} />
          {/* <Route path="/userinfo" element={<Userinfo />} /> */}
          <Route path="/agreement" element={<Agreement/>} />
          <Route path="/mypagemain" element={<Mypagemain/>} />
          <Route path="/boardlist" element={<BoardList/>}/>
          <Route path='/write' element={<InputText/>}/>
          <Route path='/detail' element={<Detail/>}/>
          <Route path='/recommand' element={<Recommand/>}/>
          <Route path='/gosu_review' element={<GosuReview/>}/>
          <Route path="/" element={<MainPage />} />
          <Route path="/registration" element={<RegistrationPage />} />
          <Route path="/categorie" element={<Categorie />} />
          <Route path="/detailpage" element={<ProductPage />} />
          <Route path="/admin" element={<AdminPage />} />
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
    </div>
  );
}

export default App;
