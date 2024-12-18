//기본 임포트
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import './index.css';

//중고 거래 임포트
import MainPage from './zoom/main.js'; // MainPage 컴포넌트 임포트
import RegistrationPage from './zoom/registration.js'; // RegistrationPage 컴포넌트 임포트
import Categorie from './zoom/categorie.js';
// import Header from './component/Header.js'; 
import ProductPage from './zoom/detailpage.js'
import AdminPage from './zoom/admin.js';
import UpdatePage from './zoom/updatepage.js';


//로그인 & 회원 가입 임프토
// import Header from './header/Header.js';
import Registpage from './registpage/Registpage.js';
import Loginpage from './loginpage/Loginpage.js';
import Forgotpassword from './forgotpassword/forgotpassword.js';

//마이페이지 임포트
// import Userinfo from './userinfo';
import Agreement from './agreement/agreement.js';
import Mypagemain from './mypagemain/Mypagemain.js';

//게시판 임포트
import BoardList from './Board/Board_List.js';
<<<<<<< HEAD
=======
import Detail from './Board/Detail.js';
import Modify from './Board/Modify_Post.js';
>>>>>>> 8bcfd98a7de83d3a4c31988eaf985df2ec9832ed
import InputText from './Board/Input.js';
import Detail from './Board/Detail.js';

//리뷰 임포트
import Recommand from './review/Recommand_modal.js';
import GosuReview from './review/Gosu_review.js';

//채팅 임포트
import Chat from './Chat/Chat_main.js'

//고수 기능 임포트
import GosuMain from './gosu/main';
import Profile from './gosu/profile';
import ProfileInput from './gosu/profile.input';
// import findInfo from './findInfo'
import AskEstimate from './gosu/ask_estimate';
import CategoryPortfolio from './gosu/category_portfolio';
import ExportEstimate from './gosu/exportEstimate';
import ReceiveAsk from './gosu/gosu_receive_ask';
import Portfolio from './gosu/portfolio';
import InputPortfolio from './gosu/portfolio_input';

//막아놓은 은준씨 기능 임포트
import Login from './gosu/login';
import Regist from './gosu/regist';


function App() {
  return (
      <div className="App">
        <BrowserRouter>
        {/* <Header /> */}
          <Routes>
            {/*중고 거래 기능*/}
            <Route path="/" element={<MainPage />} />
            <Route path="/registration" element={<RegistrationPage />} />
            <Route path="/categorie" element={<Categorie />} />
            <Route path="/detailpage/:id" element={<ProductPage />} />
            <Route path="/updatepage/:id" element={<UpdatePage />} />

            {/*로그인 & 회원 가입*/}
            <Route path="/login" element={<Loginpage />} />
            <Route path="/regist" element={<Registpage />} />
            <Route path="/forgotpassword" element={<Forgotpassword />} />

            {/*마이페이지 기능*/}
            {/* <Route path="/userinfo" element={<Userinfo />} /> */}
            <Route path="/agreement" element={<Agreement/>} />
            <Route path="/mypagemain" element={<Mypagemain/>} />

            {/*게시판 기능*/}
            <Route path="/boardlist" element={<BoardList/>}/>
            <Route path='/write' element={<InputText/>}/>
            <Route path='/detail' element={<Detail/>}/>
            <Route path='/modify' element={<Modify/>}/>

            {/*추천 기능*/}
            <Route path='/recommand' element={<Recommand/>}/>
            <Route path='/gosu_review' element={<GosuReview/>}/>

            {/*채팅 기능*/}
            <Route path="/chat" element={<Chat/>} />
            
            {/*관리자 페이지 기능*/}
            <Route path="/admin" element={<AdminPage />} />

            {/*전문가 매칭 기능*/}
            <Route path="/gosuMain" element={<GosuMain/>} />
            <Route path='/ExportEstimate' element={<ExportEstimate />} />
            <Route path="/ProfileInput" element={<ProfileInput />} />
            <Route path="/Profile" element={<Profile />} />
            <Route path="/Portfolio" element={<Portfolio />} />
            <Route path="/PortfolioInput" element={<InputPortfolio />} />
            <Route path="/categoryPorfolio" element={<CategoryPortfolio />} />
            <Route path="/askEstimate" element={<AskEstimate />} />
            <Route path="/receiveAsk" element={<ReceiveAsk />} />

            {/*은준씨 제작 로그인 & 회원 가입*/}
            {/* <Route path='/Login' element={<Login />} />
            <Route path='/regist' element={<Regist />} />
            <Route path='/Login' element={<Login />} /> */}

        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
