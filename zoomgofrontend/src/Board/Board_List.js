import { useEffect, useState } from 'react';
import style from './Board_List.module.css';
import { Link } from 'react-router-dom';
import axios from 'axios';

const Test = () => {

  const [data, setData] = useState({dtoList:[]})

  let page = 1

  useEffect(() => {
    axios.get("http://localhost:8080/zoomgo/board/list",{
      params: {communityType: "자유",
                page: page
      }
    })
    .then(res => {
      setData(res.data);
      })
    .catch(err => console.log(err))
  },[]);

  let count = data.dtoList.length

  let resultPage = data.totalPage

  console.log(data)

  return (
    <div className={style.container}>
      <Link to="/" className={style.link}>
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
                      {post.title} [{post.replyCnt}]
                    </td>
                  </Link>
                  <td>{post.memberNickname}</td>
                  <td>{new Date(post.createdDate).toLocaleDateString()}</td>
                  <td>{post.views}</td>
                  <td>{post.recommands}</td>
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
        <span className={`${style.page_button} ${!data.prev && style.disabled}`}> 이전 </span>
        <span>1  2  3  4  5</span>
        <span className={style.page_button}> 다음 </span>
      </div>

      <div className={style.actions}>
        <Link to="/write" className={style.link}>
          <button className={style.board_write_button}>
            <span>글쓰기</span>
          </button>
        </Link>
        <div className={style.board_search}>
          <select className={style.board_search_select}>
            <option selected>제목</option>
            <option>내용</option>
            <option>작성자</option>
          </select>
          <input className={style.board_search_input} />
          <button className={style.board_search_button}>검색</button>
        </div>
      </div>
    </div>
  );
};

export default Test;