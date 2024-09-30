import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import icon1 from './icon/icon1.png';
import list from './icon/listicon.png';
import './Header.css'; 

function Header() {
    const navigate = useNavigate();
    const [showCategories, setShowCategories] = useState(false);

    // 마우스가 들어왔을 때 카테고리를 표시
    const handleMouseEnter = () => {
        setShowCategories(true);
    };

    // 마우스가 나갔을 때 카테고리를 숨김
    const handleMouseLeave = () => {
        setShowCategories(false);
    };

    return (
        <header className="header">
            {/* 상단 메뉴 */}
            <div className="top-menu">
                <a href="#" className="switch-page active">중고</a>
                <a href="#" className="switch-page">고수</a>
            </div>

            {/* 로고 */}
            <div className="logo" onClick={() => navigate('/')}>
                ZOOMGO
            </div>

            {/* 네비게이션 바 */}
            <nav className="nav">
                <div 
                     onClick={() => navigate('/categorie')} id="category" className="nav-link"
                    onMouseEnter={handleMouseEnter} 
                    onMouseLeave={handleMouseLeave}
                >
                상품 카테고리
                    {showCategories && (
                        <div className="category-dropdown">
                            <ul>
                                <li>패션의류</li>
                                <li>전자제품</li>
                                <li>생활용품</li>
                                <li>도서</li>
                            </ul>
                        </div>
                    )}
                </div>
                <input type="text" id="search" placeholder="어떤 상품이 필요하신가요?" />
                <div className="button">
                    <a href="#">채팅</a>
                    <span className="badge">14</span>
                    <a href="#"><img src={icon1} alt="mypage" onClick={() => navigate('/admin')}/></a>
                    <a href="#"><img src={list} alt="list" /></a>
                </div>
            </nav>
        </header>
    );
}

export default Header;
