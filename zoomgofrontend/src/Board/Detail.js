import style from "./Detail.module.css";
import { Link } from "react-router-dom";
import trade from "../image/trade.jpg"

const Datail = () => {
  return (
    <div className={style.datail_container}>
      <Link to="/" className={style.link}>
        <div className={style.board_type}>홈 &gt; 자유게시판</div>
      </Link>

      <hr className={style.divider}/>

      <div className={style.post_detail}>
        <div className={style.post_title}>거래 좋았습니다</div>
        <div className={style.views}>조회수 : 1,469</div>
        <div className={style.post_details}>
          <div className={style.writer}>조은준</div>
          <div className={style.date}>2024-05-14</div>
        </div>
      </div>

      <div className={style.button_group}>
        <button className={style.update_button}><span>수정</span></button>
        <button className={style.delete_button}><span>삭제</span></button>
      </div>

      <img src={trade} alt="" className={style.image}/>
      <div className={style.post_content}>거래 잘 했습니다.</div>

      <div className={style.recommend_button_container}>
        <button className={style.recommend_button}>
          <span className={style.recommend_text}>추천</span>
          <span className={style.recommend_count}>20</span>
        </button>
      </div>

      <hr className={style.divider} />
      <div class={style.comments}>
            <h3>전체 댓글 (4)</h3>
            <hr className={style.divider} />
            <div class={style.comment}>
                <p><strong>박재찬</strong></p>
                <p>댓글 테스트</p>
                <span>2024.06.07 15:55</span>
            </div>
            <div class={style.comment}>
                <p><strong>박찬욱</strong></p>
                <p>댓글 테스트</p>
                <span>2024.06.07 15:57</span>
            </div>
            <div class={style.reply}>
                <p><strong>조은준 (작성자)</strong></p>
                <p>대댓글 테스트</p>
                <span>2024.06.07 16:40</span>
            </div>
            <div class={style.comment}>
                <p><strong>김민규</strong></p>
                <p>댓글 테스트</p>
                <span>2024.06.07 15:58</span>
            </div>
      </div>

      
      <div className={style.comment_input}>
        <div className={style.comment_write}>댓글 작성</div>
        <textarea className={style.input_placeholder} rows={4}/>
      </div>
      <div className={style.input_button_group}>
          <button className={style.input_button}><span>등록</span></button>
      </div>
      
    </div>
  );
};

export default Datail;
