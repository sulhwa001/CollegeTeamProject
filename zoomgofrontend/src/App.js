//기본 임포트
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import './index.css';

//중고 거래 임포트
import Categorie from './component/categorie.js';
import MainPage from './component/main.js'; // MainPage 컴포넌트 임포트
import RegistrationPage from './component/registration.js'; // RegistrationPage 컴포넌트 임포트
// import Header from './component/Header.js'; 
import AdminPage from './component/admin.js';
import ProductPage from './component/detailpage.js';

//로그인 & 회원 가입 임프토
// import Header from './header/Header.js';
import Forgotpassword from './forgotpassword/forgotpassword.js';
import Loginpage from './loginpage/Loginpage.js';
import Registpage from './registpage/Registpage.js';

//마이페이지 임포트
// import Userinfo from './userinfo';
import Agreement from './agreement/agreement.js';
import Mypagemain from './mypagemain/Mypagemain.js';

//게시판 임포트
import BoardList from './Board/Board_List.js';
import Detail from './Board/Detail.js';
import Modify from './Board/Modify_Post.js';
import InputText from './Board/Input.js';

//리뷰 임포트
import GosuReview from './review/Gosu_review.js';
import Recommand from './review/Recommand_modal.js';

//채팅 임포트
import Chat from './Chat/Chat_main.js';

//고수 기능 임포트
import GosuMain from './gosu/main.js';
import ProfileInput from './gosu/profile.input.js';
import Profile from './gosu/profile.js';
import ProfileUpdate from './gosu/profile_update.js';
// import findInfo from './findInfo'
import AskEstimate from "./gosu/ask_estimate.js";
import CategoryPortfolio from "./gosu/category_portfolio.js";
import ExportEstimate from "./gosu/exportEstimate.js";
import ReceiveAsk from "./gosu/gosu_receive_ask.js";
import Portfolio from "./gosu/portfolio.js";
import InputPortfolio from "./gosu/portfolio_input.js";
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
            <Route path="/detailpage" element={<ProductPage />} />

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
            <Route path="/ProfileInput/:userNo" element={<ProfileInput />} />
            <Route path="/Profile/:gosuId" element={<Profile />} />
            <Route path="/ProfileUpdate/:gosuId" element={<ProfileUpdate />} />
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
