import style from './Board_List.module.css';
import { Link } from 'react-router-dom';

const Test = () => {
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
            <tr>
              {/* <Link to="/detail" className="link"> */}
              <td>4</td>
              <td className={style.board_community_title}>게시글 테스트 [4]</td>
              <td>조은준</td>
              <td>2024-05-14</td>
              <td>1,469</td>
              <td>20</td>
              {/* </Link> */}
            </tr>
            <tr>
              {/* <Link to="/detail" className="link"> */}
              <td>3</td>
              <td className={style.board_community_title}>게시글 테스트 [4]</td>
              <td>조은준</td>
              <td>2024-05-14</td>
              <td>1,469</td>
              <td>20</td>
              {/* </Link> */}
            </tr>
            <tr>
              {/* <Link to="/detail" className="link"> */}
              <td>2</td>
              <td className={style.board_community_title}>게시글 테스트 [4]</td>
              <td>조은준</td>
              <td>2024-05-14</td>
              <td>1,469</td>
              <td>20</td>
              {/* </Link> */}
            </tr>
            <tr>
              
              <td>1</td>
              <Link to="/detail" className={style.link}>
              <td className={style.board_community_title}>게시글 테스트 [4]</td>
              </Link>
              <td>조은준</td>
              <td>2024-05-14</td>
              <td>1,469</td>
              <td>20</td>
              
            </tr>
          </tbody>
        </table>
      </div>

      <hr className={style.divider} />

      <div className={style.page}>
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