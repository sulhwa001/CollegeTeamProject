import React from 'react';
import { useNavigate } from 'react-router-dom';
import icon1 from './icon/icon1.png';
import list from './icon/listicon.png';
import Header from './Header'; 
import './main.css';
function MainPage() {
    const navigate = useNavigate();

    const createProductItem = (name, price) => (
        <div className="mainproduct-item" key={name}>
            <div className="mainproduct-image"></div>
            <p className="mainproduct-name">{name}</p>
            <p className="mainproduct-price">{price}</p>
        </div>
    );

    return (
        <div>
            <Header />
            <main className="main-content">
                {/* 첫 번째 상품 섹션 */}
                <section className="mainproduct">
                    <div className="section-header">
                    <h2>최근 올라온 상품</h2>
                    </div>
                    <div className="mainproduct-list" onClick={() => navigate('/detailpage')}>
                        {createProductItem("상품1", "10,000원")}
                        {createProductItem("상품2", "10,000원")}
                        {createProductItem("상품3", "10,000원")}
                        {createProductItem("상품4", "10,000원")}
                    </div>
                </section>

                {/* 두 번째 상품 섹션 */}
                <section className="mainproduct-section">
                    <h2>지금 인기있는 상품</h2>
                    <div className="mainproduct-list">
                        {createProductItem("상품1", "10,000원")}
                        {createProductItem("상품2", "10,000원")}
                        {createProductItem("상품3", "10,000원")}
                        {createProductItem("상품4", "10,000원")}
                    </div>

                    <button className="write-btn" onClick={() => navigate('/registration')}>
                        글쓰기
                    </button>
                </section>
            </main>
        </div>
    );
}

export default MainPage;
