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
import "./index.css";
import Login from "./login";
import Loginpage from "./loginpage/Loginpage.js";
import Main from "./main";
import Mypagemain from "./mypagemain/Mypagemain.js";
import Profile from "./profile";
import ProfileInput from "./profile.input";
import Regist from "./regist";
import Registpage from "./registpage/Registpage.js";
import GosuReview from "./review/Gosu_review.js";
import Recommand from "./review/Recommand_modal.js";
// import Userinfo from "./userinfo";
// import findInfo from './findInfo'
import { BrowserRouter, Route, Routes } from "react-router-dom";
import AskEstimate from "./ask_estimate";
import CategoryPortfolio from "./category_portfolio";
import ExportEstimate from "./exportEstimate";
import ReceiveAsk from "./gosu_receive_ask";
import Portfolio from "./portfolio";
import InputPortfolio from "./portfolio_input";

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
          {/* <Route path="/userinfo" element={<Userinfo />} /> */}
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
