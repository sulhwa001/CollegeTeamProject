import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios'; // axios 설치 필요: npm install axios
import Header from './Header';
import './css/main.css';

function MainPage() {
    const navigate = useNavigate();

    // 상태 변수 선언
    const [recentProducts, setRecentProducts] = useState([]); // 최근 상품
    const [popularProducts, setPopularProducts] = useState([]); // 인기 상품
    const [loading, setLoading] = useState(true); // 로딩 상태

    // 데이터 가져오기 함수
    const fetchProducts = async () => {
        try {
            // 최근 올라온 상품 API 호출
            const recentResponse = await axios.get('http://localhost:8080/api/products/latest?page=0&size=4');
            setRecentProducts(recentResponse.data.content);

            // 인기 상품 API 호출 (예: 조회수 순 정렬된 데이터)
            const popularResponse = await axios.get('http://localhost:8080/api/products/most?page=0&size=4');
            setPopularProducts(popularResponse.data.content);

            setLoading(false);
        } catch (error) {
            console.error("상품 데이터를 가져오는 중 오류가 발생했습니다:", error);
            setLoading(false);
        }
    };

    // 컴포넌트 마운트 시 데이터 로드
    useEffect(() => {
        fetchProducts();
    }, []);

    const formatDateWithoutYear = (dateString) => {
        const date = new Date(dateString);
        return `${date.getMonth() + 1}월 ${date.getDate()}일`;
    };

    // 상품 아이템 생성
    const createProductItem = (product, type) => (
        <div
            className="mainproduct-item"
            key={product.id}
            onClick={() => navigate(`/detailpage/${product.id}`)}
        >
            <div
                className="mainproduct-image"
                style={{ backgroundImage: `url(${product.file || 'default-image.png'})` }}
            ></div>
            <p className="mainproduct-name">{product.title}</p>
            <p className="mainproduct-price">{product.price ? `${product.price.toLocaleString()}원` : '가격 미정'}</p>
            {type === 'recent' ? (
                <p className="mainproduct-date">{formatDateWithoutYear(product.createdAt)}</p>
            ) : (
                <p className="mainproduct-views">view:{product.view || 0}</p>
            )}
        </div>
    );

    // 로딩 화면 처리
    if (loading) {
        return <div>로딩 중...</div>;
    }

    return (
        <div>
            <Header />
            <main className="main-content">
                {/* 최근 올라온 상품 섹션 */}
                <section className="mainproduct">
                    <div className="section-header">
                        <h2>최근 올라온 상품</h2>
                    </div>
                    <div className="mainproduct-list">
                        {recentProducts.map((product) => createProductItem(product, 'recent'))}
                    </div>
                </section>

                {/* 지금 인기 있는 상품 섹션 */}
                <section className="mainproduct-section">
                    <h2>지금 인기있는 상품</h2>
                    <div className="mainproduct-list">
                        {popularProducts.map((product) => createProductItem(product, 'popular'))}
                    </div>
                </section>

                <button className="write-btn" onClick={() => navigate('/registration')}>
                    글쓰기
                </button>
            </main>
        </div>
    );
}

export default MainPage;
