import { useEffect, useState } from 'react';
import style from './Board_List.module.css';
import { Link } from 'react-router-dom';
import axios from 'axios';

const Test = () => {

  const token = localStorage.getItem('zoomgo-token');

  //게시글 목록 출력을 위한 준비
  const [data, setData] = useState({dtoList:[]})

  //페이지 번호 기본 번호는 1번으로 출력
  const [currentPage, setCurrentPage] = useState(1);

  const [search, setSearch] = useState(false);

  const [searchPage, setSearchPage] = useState(1);

  const [keyword, setKeyword] = useState("");

  //Page번호를 Param으로 한 게시글 목록 출력
  useEffect(() => {
    axios.get("http://localhost:8080/zoomgo/board/list",{
      params: {
        communityType: "자유",
        page: currentPage
      }
    })
    .then(res => {
      setData(res.data);
      })
    .catch(err => console.log(err))
  },[currentPage]);

  const handleSearchChange = (e) => {
    setKeyword(e.target.value);
  }

  const handleSearchClick = () => {
    setSearch(!search)
    axios.get("http://localhost:8080/zoomgo/board/list/keyword",{
      params: {
        communityType: "자유",
        page: searchPage,
        keyword: keyword
      }
    })
    .then(res => {
      setData(res.data);
      })
    .catch(err => console.log(err))
  }

  const handleWriteMove = () => {
    if(!token){
      alert("로그인이 필요한 기능입니다.");
      window.location.href = "/login";
    }else {
      window.location.href = "/write";
    }
  }

  //게시글 사이즈 저장
  let count = data.dtoList.length

  const [pageGroup, setPageGroup] = useState(1);

  const maxPage = 5;
  const totalPage = data.totalPage; // totalPage는 데이터에서 가져온 총 페이지 수

  const totalPageNumber = Array.from({ length: totalPage }, (_, i) => i + 1);
  const pageNumber = totalPageNumber.slice((pageGroup - 1) * maxPage, pageGroup * maxPage);

  const handlePageClick = (page) => {
    setCurrentPage(page);
    setPageGroup(Math.ceil(page / maxPage));  // 클릭한 페이지에 맞는 페이지 그룹 계산
  };
  
  // 이전 그룹 버튼 클릭
  const handlePrevGroup = () => {
    if (pageGroup > 1) {
      const prevGroup = pageGroup - 1;
      setPageGroup(prevGroup); // 페이지 그룹 감소
      setCurrentPage((prevGroup - 1) * maxPage + 1); // 그룹의 첫 번째 페이지로 이동
    }
  };
  
  // 다음 그룹 버튼 클릭
  const handleNextGroup = () => {
    if (pageGroup * maxPage < totalPage) {
      const nextGroup = pageGroup + 1;
      setPageGroup(nextGroup); // 페이지 그룹 증가
      setCurrentPage(nextGroup * maxPage - (maxPage - 1)); // 다음 그룹의 첫 번째 페이지로 이동
    }
  };

  console.log(data)

  return (
    <div className={style.container}>
      <Link to="/boardlist" className={style.link}>
        <div className={style.board_type}>
          홈 &gt; 자유게시판
        </div>
      </Link>

      <hr className={style.divider}/>

      <div className={style.board_container}>
        <table className={style.board_list}>
          <thead>
            <tr>
              <th>No</th>
              <th className={style.board_title}>제목</th>
              <th>작성자</th>
              <th>작성일</th>
              <th>조회수</th>
              <th>추천</th>
            </tr>
          </thead>
          <tbody>
            {data.dtoList && data.dtoList.length > 0 ? (
              data.dtoList.map((post) => (
                <tr key={post.postNo}>
                  <td>{count--}</td>
                  <Link to={`/detail/?postNo=${post.postNo}`} className={style.link}>
                    <td className={style.board_community_title}>
                      {post.title}
                    </td>
                  </Link>
                  <td>{post.memberNickname}</td>
                  <td>{new Date(post.createdDate).toLocaleDateString()}</td>
                  <td>{post.views}</td>
                  <td>{post.recommends}</td>
                </tr>
              ))
            ):(
              <tr>
                  <td colSpan="6">게시글이 없습니다.</td>
              </tr>
            )}
          </tbody>
        </table>
      </div>

      <hr className={style.divider} />

      <div className={style.page}>
        <span className={`${style.page_button} ${pageGroup === 1 && style.disabled}`} onClick={handlePrevGroup}>이전</span>
        <span>
          {pageNumber.map((page) => (
            <span key={page} className={`${style.page_number} ${currentPage === page && style.active}`} onClick={() => handlePageClick(page)}>
              {page}
            </span>
          ))}
        </span>
        <span className={`${style.page_button} ${pageGroup * maxPage >= totalPage && style.disabled}`} onClick={handleNextGroup}>다음</span>
      </div>

      <div className={style.actions}>
          <button className={style.board_write_button} onClick={handleWriteMove}>
            <span>글쓰기</span>
          </button>
        <div className={style.board_search}>
          <input className={style.board_search_input} onChange={handleSearchChange}/>
          <button className={style.board_search_button} onClick={handleSearchClick}>검색</button>
        </div>
      </div>
    </div>
  );
};

export default Test;