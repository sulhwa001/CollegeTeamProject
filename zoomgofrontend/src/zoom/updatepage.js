import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import './css/registration.css';
import axios from 'axios';
import Header from './Header';

const ProductPage = () => {
    const [title, setTitle] = useState('');
    const [categoryId, setCategoryId] = useState('');
    const [categoryName, setCategoryName] = useState('');
    const [address, setAddress] = useState('');
    const [price, setPrice] = useState('');
    const [contents, setContents] = useState('');
    const [transStatus, setTransStatus] = useState('');
    const [transType, setTransType] = useState('');
    const [cost, setCost] = useState('');
    const [file, setFile] = useState(null);
    const [fileName, setFileName] = useState('');
    const { id } = useParams();
    const navigate = useNavigate();

    const categories = [
        { id: 1, name: '전자제품' },
        { id: 2, name: '가구' },
        { id: 3, name: '의류' },
        { id: 4, name: '책' },
    ];

    useEffect(() => {
        const fetchProduct = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/products/${id}`);
                const product = response.data;
                setTitle(product.title);
                setCategoryId(product.category?.categoryId || '');
                setCategoryName(product.category?.categoryName || '');
                setAddress(product.address);
                setPrice(product.price);
                setContents(product.contents);
                setTransStatus(product.transStatus);
                setTransType(product.transType);
                setCost(product.cost);
            } catch (error) {
                console.error('Error fetching product data:', error);
            }
        };

        fetchProduct();
    }, [id]);

    const handleCategorySelect = (id, name) => {
        setCategoryId(id);
        setCategoryName(name);
    };

    const handleFileChange = (e) => {
        const selectedFile = e.target.files[0];
        if (selectedFile) {
            setFile(selectedFile);
            setFileName(selectedFile.name);
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        const productData = {
            title,
            contents,
            category: { categoryId, categoryName },
            address,
            transStatus,
            transType,
            cost,
            price,
        };

        const formData = new FormData();
        formData.append('boardDTO', JSON.stringify(productData));
        if (file) formData.append('image', file);

        try {
            await axios.put(`http://localhost:8080/api/products/${id}`, formData, {
                headers: { 'Content-Type': 'multipart/form-data' },
            });
            alert('상품이 수정되었습니다.');
            navigate(`/detailpage/${id}`);
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
                            placeholder="상품명"
                            value={title}
                            onChange={(e) => setTitle(e.target.value)}
                        />
                    </div>
                    <div className="custom-select">
                        <div className="selected">
                            {categoryName || '카테고리 선택'}
                        </div>
                        <div className="dropdown">
                            {categories.map((category) => (
                                <div
                                    key={category.id}
                                    className="dropdown-item"
                                    onClick={() => handleCategorySelect(category.id, category.name)}
                                >
                                    {category.name}
                                </div>
                            ))}
                        </div>
                    </div>
                    <div className="input-group">
                        <input
                            type="text"
                            placeholder="거래 장소"
                            value={address}
                            onChange={(e) => setAddress(e.target.value)}
                        />
                    </div>
                    <div className="input-group">
                        <input
                            type="text"
                            placeholder="가격"
                            value={price}
                            onChange={(e) => setPrice(e.target.value)}
                        />
                    </div>
                    <div className="input-group">
                        <input
                            type="text"
                            placeholder="택배비"
                            value={cost}
                            onChange={(e) => setCost(e.target.value)}
                        />
                    </div>
                    <div className="input-group">
                        <textarea
                            rows="4"
                            placeholder="상품 설명"
                            value={contents}
                            onChange={(e) => setContents(e.target.value)}
                        />
                    </div>
                    <div className="input-group">
                        <input
                            type="text"
                            placeholder="거래 상태"
                            value={transStatus}
                            onChange={(e) => setTransStatus(e.target.value)}
                        />
                    </div>
                    <div className="input-group">
                        <input
                            type="text"
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
                        {fileName && <span className="file-name-preview">{fileName}</span>}
                    </div>
                    <button type="submit" className="submit-btn">수정하기</button>
                </form>
            </main>
        </div>
    );
};

export default ProductPage;
