import React, { useEffect, useState } from 'react';
import './css/registration.css';
import { useNavigate, useParams } from 'react-router-dom';
import Header from './Header';
import axios from 'axios';

function UpdatePage() {
    const { id } = useParams(); // URL에서 상품 ID 가져오기
    const [title, setTitle] = useState('');
    const [categoryId, setCategoryId] = useState('');
    const [address, setAddress] = useState('');
    const [price, setPrice] = useState('');
    const [contents, setContents] = useState('');
    const [transStatus, setTransStatus] = useState('');
    const [transType, setTransType] = useState('');
    const [view, setView] = useState(0);
    const [cost, setCost] = useState('');
    const [file, setFile] = useState(null);
    const navigate = useNavigate();

    // 기존 데이터 로드
    useEffect(() => {
        const fetchProduct = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/products/${id}`);
                const product = response.data;

                // 초기값 설정
                setTitle(product.title);
                setCategoryId(product.category?.categoryId || '');
                setAddress(product.address);
                setPrice(product.price);
                setContents(product.contents);
                setTransStatus(product.transStatus);
                setTransType(product.transType);
                setView(product.view);
                setCost(product.cost);
            } catch (error) {
                console.error('Failed to fetch product data:', error);
                alert('상품 정보를 불러오지 못했습니다.');
            }
        };

        fetchProduct();
    }, [id]);

    const handleCategorySelect = (categoryId) => {
        setCategoryId(categoryId);
    };

    const handleFileChange = (e) => {
        setFile(e.target.files[0]);
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (!title || !categoryId || !address || !price || !contents || !transStatus || !transType) {
            alert('모든 필드를 입력해주세요.');
            return;
        }

        const productData = {
            postId: id, // 수정할 상품 ID
            title,
            contents,
            memberId: 2, // 예시로 하드코딩된 사용자 ID
            category: { categoryId, categoryName: categoryId === 1 ? '전자제품' : '' },
            address,
            transStatus,
            transType,
            view,
            cost: cost || 0,
            price,
        };

        const formData = new FormData();
        formData.append('boardDTO', JSON.stringify(productData));
        if (file) formData.append('image', file);

        try {
            const response = await axios.put(`http://localhost:8080/api/products/${id}`, formData, {
                headers: { 'Content-Type': 'multipart/form-data' },
            });

            if (response.status === 200) {
                alert('상품이 수정되었습니다.');
                navigate(`/detailpage`); // 수정 후 상세 페이지로 이동
            }
        } catch (error) {
            console.error('상품 수정 실패:', error);
            alert('상품 수정에 실패했습니다. 다시 시도해주세요.');
        }
    };

    return (
        <div>
            <Header />
            <main className="main-content">
                <form onSubmit={handleSubmit}>
                    <div className="input-group">
                        <input
                            type="text"
                            id="title"
                            placeholder="상품명"
                            value={title}
                            onChange={(e) => setTitle(e.target.value)}
                        />
                    </div>
                    <div className="custom-select">
                        <div
                            className="selected"
                            onClick={() => handleCategorySelect(1)} // 카테고리 선택 예제
                        >
                            {categoryId === 1 ? '전자제품' : '카테고리 선택'}
                        </div>
                    </div>
                    <div className="input-group">
                        <input
                            type="text"
                            id="address"
                            placeholder="거래장소를 입력 해 주세요."
                            value={address}
                            onChange={(e) => setAddress(e.target.value)}
                        />
                    </div>
                    <div className="input-group">
                        <input
                            type="text"
                            id="price"
                            placeholder="가격"
                            value={price}
                            onChange={(e) => setPrice(e.target.value)}
                        />
                    </div>
                    <div className="input-group">
                        <input
                            type="text"
                            id="cost"
                            placeholder="택배비"
                            value={cost}
                            onChange={(e) => setCost(e.target.value)}
                        />
                    </div>
                    <div className="input-group">
                        <textarea
                            id="contents"
                            rows="4"
                            placeholder="상품설명"
                            value={contents}
                            onChange={(e) => setContents(e.target.value)}
                        />
                    </div>
                    <div className="input-group">
                        <input
                            type="text"
                            id="transStatus"
                            placeholder="거래 상태"
                            value={transStatus}
                            onChange={(e) => setTransStatus(e.target.value)}
                        />
                    </div>
                    <div className="input-group">
                        <input
                            type="text"
                            id="transType"
                            placeholder="거래 유형"
                            value={transType}
                            onChange={(e) => setTransType(e.target.value)}
                        />
                    </div>
                    <div className="input-group">
                        <label htmlFor="file" className="file-upload-label">
                            파일 업로드
                        </label>
                        <input
                            type="file"
                            id="file"
                            onChange={handleFileChange}
                            className="file-upload-input"
                        />
                    </div>
                    <button type="submit" className="submit-btn">수정하기</button>
                </form>
            </main>
        </div>
    );
}

export default UpdatePage;
