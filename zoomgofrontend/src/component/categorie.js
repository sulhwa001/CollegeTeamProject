import React from 'react';
import './categorie.css'; 
import Header from './Header'; 
import { useNavigate } from 'react-router-dom';


const ProductRegistration = () => {

    const navigate = useNavigate();

    return (
        <div>
         <Header className="zoomheader"/>
            <main className="main-content">
                <section className="search-results">
                    <h2>검색결과</h2>
                    <nav className="breadcrumb">홈  &gt; 의류</nav>
                    <div className="categorieproducts">
                        {Array.from({ length: 8 }, (_, i) => (
                            <div className="categorieproduct" key={i}>
                                <div className="image-placeholder"></div>
                                <p>상품{i + 1}</p>
                                <p>10,000원</p>
                            </div>
                        ))}
                    </div>
                    <div className="pagination">
                        <button className="active">1</button>
                        <button>2</button>
                        <button>3</button>
                        <button>4</button>
                        <button>5</button>
                        <button>6</button>
                        <button className="more-btn" onClick={() => navigate('/registration')}>글쓰기</button>
                    </div>
                </section>
            </main>
        </div>
    );
};

export default ProductRegistration;
