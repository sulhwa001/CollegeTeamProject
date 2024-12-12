import Agreement from "./agreement/agreement.js";
import "./App.css";
import BoardList from "./Board/Board_List.js";
import Detail from "./Board/Detail.js";
import InputText from "./Board/Input.js";
import AdminPage from "./component/admin.js";
import Categorie from "./component/categorie.js";
import ProductPage from "./component/detailpage.js";
import MainPage from "./component/main.js"; // MainPage 컴포넌트 임포트
import RegistrationPage from "./component/registration.js"; // RegistrationPage 컴포넌트 임포트
import Forgotpassword from "./forgotpassword/forgotpassword.js";
import Login from "./gosu/login.js";
import Main from "./gosu/main.js";
import ProfileInput from "./gosu/profile.input.js";
import Profile from "./gosu/profile.js";
import Regist from "./gosu/regist.js";
import "./index.css";
import Loginpage from "./loginpage/Loginpage.js";
import Mypagemain from "./mypagemain/Mypagemain.js";
import Registpage from "./registpage/Registpage.js";
import GosuReview from "./review/Gosu_review.js";
import Recommand from "./review/Recommand_modal.js";
// import Userinfo from "./userinfo";
// import findInfo from './findInfo'
import { BrowserRouter, Route, Routes } from "react-router-dom";
import AskEstimate from "./gosu/ask_estimate.js";
import CategoryPortfolio from "./gosu/category_portfolio.js";
import ExportEstimate from "./gosu/exportEstimate.js";
import ReceiveAsk from "./gosu/gosu_receive_ask.js";
import Portfolio from "./gosu/portfolio.js";
import InputPortfolio from "./gosu/portfolio_input.js";
import ProfileUpdate from "./gosu/profile_update.js";
function App() {
 
  return (
    <div className="App">
      <BrowserRouter>
        {/* <Header /> */}
        <Routes>
          <Route path="/gosupage" element={<Main />} />
          <Route path="/login" element={<Loginpage />} />
          <Route path="/registEmail" element={<Registpage />} />
          <Route path="/forgotpassword" element={<Forgotpassword />} />
          
        <Route path="/agreement" element={<Agreement />} />
          <Route path="/mypagemain" element={<Mypagemain />} />
          <Route path="/boardlist" element={<BoardList />} />
          <Route path="/write" element={<InputText />} />
          <Route path="/detail" element={<Detail />} />
          <Route path="/recommand" element={<Recommand />} />
          <Route path="/gosu_review" element={<GosuReview />} />
          <Route path="/" element={<MainPage />} />
          <Route path="/registration" element={<RegistrationPage />} />
          <Route path="/categorie" element={<Categorie />} />
          <Route path="/detailpage" element={<ProductPage />} />
          <Route path="/admin" element={<AdminPage />} />
          <Route path="/Login" element={<Login />} />
          <Route path="/regist" element={<Regist />} />
          <Route path="/Login" element={<Login />} />
          <Route path="/ExportEstimate" element={<ExportEstimate />} />
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
