import React, { useEffect, useState } from 'react';
import './css/detailpage.css'; // CSS 파일을 불러옴
import dibs from './icon/dibs.png';
import deleteIcon from './icon/delete.png';
import axios from 'axios';
import Header from './Header'; 


const ProductPage = () => {
    const [product, setProduct] = useState(null); // 상품 정보를 저장
    const [loading, setLoading] = useState(true); // 로딩 상태
    const currentUserId = 1; // 하드코딩된 현재 사용자 ID

    useEffect(() => {
        // 백엔드 API 호출
        const fetchProduct = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/products/28'); // 실제 ID로 수정
                setProduct(response.data); // API에서 받은 데이터 저장
                setLoading(false); // 로딩 상태 해제
            } catch (error) {
                console.error('Error fetching product data:', error);
                setLoading(false); // 로딩 상태 해제
            }
        };

        fetchProduct();
    }, []);

    const handleDelete = async () => {
        try {
            await axios.delete(`http://localhost:8080/api/products/${product.postId}`);
            alert('게시글이 삭제되었습니다.');
            // 추가 동작: 목록 페이지로 이동 등
        } catch (error) {
            console.error('Error deleting product:', error);
            alert('게시글 삭제에 실패했습니다.');
        }
    };

    const handleUpdate = () => {
        alert('수정 페이지로 이동합니다.'); // 추후 실제 수정 페이지로 이동
    };

    if (loading) {
        return <div>Loading...</div>; // 로딩 중 표시
    }

    if (!product) {
        return <div>Product not found</div>; // 데이터가 없을 때 표시
    }

    return (
        <div>
            <Header className="zoom-header" />
            <main className="main-content">
                <section className="product">
                    <div className="product-image">
                        {/* 상품 이미지 표시 */}
                        {product.file ? (
                            <img
                                src={`data:image/jpeg;base64,${product.file}`}
                                alt={product.title}
                            />
                        ) : (
                            <p>No Image</p>
                        )}
                    </div>
                    <div className="product-details">
                        <div className="product-channel">
                            <p>홈 &gt; {product.category?.categoryName || '카테고리 없음'}</p>
                            <div className="transaction-status">
                                <div>{product.transStatus || '상태 없음'}</div>
                            </div>
                        </div>
                        <div className="product-name">
                            <h1>{product.title || '상품명 없음'}</h1>
                        </div>
                        <div className="product-price">
                            <h2>
                                {product.price
                                    ? `${product.price.toLocaleString()}원`
                                    : '가격 없음'}
                            </h2>
                        </div>
                        <div className="product-info-extra">
                            <p>
                                {product.createdAt
                                    ? new Date(product.createdAt).toLocaleString()
                                    : '등록 시간 없음'}
                            </p>
                            <p>조회수 {product.view || 0}</p>
                        </div>
                        <div className="product-location">
                            <p>거래 희망 지역: {product.address || '주소 없음'}</p>
                        </div>

                        <section className="product-details-info">
                            <div className="info-item">
                                <p>제품상태</p>
                                <p>{product.conditions || '상태 없음'}</p>
                            </div>
                            <div className="divider"></div>
                            <div className="info-item">
                                <p>거래방식</p>
                                <p>{product.transType || '방식 없음'}</p>
                            </div>
                            <div className="divider"></div>
                            <div className="info-item">
                                <p>배송비</p>
                                <p>
                                    {product.cost
                                        ? `${product.cost.toLocaleString()}원`
                                        : '배송비 없음'}
                                </p>
                            </div>
                        </section>

                        <div className="product-actions">
                            <div className="dibs">
                                <img src={dibs} alt="dibs" />
                            </div>
                            {/* 조건부 렌더링: 작성자인 경우 "수정하기", 작성자가 아닌 경우 "채팅하기" */}
                            {currentUserId === product.memberId ? (
                                <>
                                    <button onClick={handleUpdate} className="update-button">
                                        수정하기
                                    </button>
                                    <button onClick={handleDelete} className="delete-button">
                                        <img src={deleteIcon} alt="Delete" />
                                    </button>
                                </>
                            ) : (
                                <button>채팅하기</button>
                            )}
                        </div>
                    </div>
                </section>

                {/* 임시 정보 유지 */}
                <section className="info">
                    <div className="info-block">
                        <h3>상품 정보</h3>
                        <p>대명동 전동민 앞에서 직거래 가능<br />입금 후 택배 발송합니다.</p>
                    </div>
                    <div className="info-block">
                        <h3>가게 정보</h3>
                        <div className="store-info">
                            <div className="store-image"></div>
                            <div className="store-rating"></div>
                        </div>
                    </div>
                </section>

                {/* 댓글 임시 정보 유지 */}
                <section className="comments">
                    <h3>댓글</h3>
                    <div className="comment">
                        <div className="comment-image"></div>
                        <div className="comment-text">
                            <p>댓글1</p>
                            <p>저희 동네랑 위치가 가까워요!</p>
                        </div>
                    </div>
                </section>

                {/* 추천 상품 임시 정보 유지 */}
                <section className="similar-products">
                    <h3>이런 상품은 어떠세요?</h3>
                    <div className="similar-product">
                        <div className="similar-product-image"></div>
                        <p>상품1 <br /> 10,000원</p>
                    </div>
                </section>
            </main>
        </div>
    );
};

export default ProductPage;
