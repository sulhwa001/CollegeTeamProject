import { Link } from "react-router-dom";
import style from "./Input.module.css"

const InputText = () => {
  return (
    <div className={style.container}>

      {/* 홈 > 자유게시판 */}
      <Link to="/" className={style.link}>
        <div className={style.board_type}>
          홈 &gt; 자유게시판
        </div>
      </Link>

      {/* 구분선 */}
      <hr className={style.divider}/>

      {/* 제목 입력 */}
      <div className={style.input_group}>
        <input className={style.input_title} placeholder="제목을 입력해주세요."/>
      </div>

      {/* 작성자 정보 */}
      <div className={style.author_info}>작성자: 조은준</div>

      {/* 내용 입력 */}
      <div className={style.input_group}>
        <textarea
          className={style.input_content}
          placeholder="내용을 입력 해주세요."
        />
      </div>

      <div className={style.file_upload_container}>
        <div className={style.file_upload_text}/>
        <button className={style.upload_button}>
          <span>파일 첨부</span>
        </button>
      </div>

      {/* 파일 첨부 */}
      <div className={style.file_preview_section}>
        <div className={style.file_preview_container}>
          <div className={style.file_preview}/>
          <div className={style.file_preview}/>
        </div>
      </div>

      {/* 버튼들 */}
      <div className={style.action_buttons}>
        <button className={style.submit_button}>
          <span>작성</span>
        </button>
        <Link to="/" className={style.link}>
          <button className={style.cancel_button}>
            <span>취소</span>
          </button>
        </Link>
      </div>
    </div>
  );
};

export default InputText;


  