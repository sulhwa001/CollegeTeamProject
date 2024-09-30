import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import MainPage from './component/main.js'; // MainPage 컴포넌트 임포트
import RegistrationPage from './component/registration.js'; // RegistrationPage 컴포넌트 임포트
import Categorie from './component/categorie.js';
import Header from './component/Header.js'; 
import ProductPage from './component/detailpage.js'
import AdminPage from './component/admin.js';


function App() {
    return (
        <Router>
            <div>
                {/* 라우트 설정 */}
                <Routes>
                    <Route path="/" element={<MainPage />} />
                    <Route path="/registration" element={<RegistrationPage />} />
                    <Route path="/categorie" element={<Categorie />} />
                    <Route path="/detailpage" element={<ProductPage />} />
                    <Route path="/admin" element={<AdminPage />} />
                       

                </Routes>
            </div>
        </Router>
    );
}

export default App;
