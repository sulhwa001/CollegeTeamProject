import { Link, useNavigate } from "react-router-dom";
import style from "./Input.module.css"
import trade from "../image/trade.jpg"
import { useState } from "react";
import axios from "axios";

const InputText = () => {

  const navigate = useNavigate();

  const [title, setTitle] = useState("");

  const [post, setPost] = useState("");

  const handleTitleChange = (e) => {
      setTitle(e.target.value);
  }

  const handlePostChange = (e) => {
    setPost(e.target.value);
  }

  const handlePostWrite = (title, post) => {
    axios.post("http://localhost:8080/zoomgo/board/regist",{
      memberNo: 1,
      communityType: "자유",
      title: title,
      memberNickname: "지각쟁이",
      post: post,
      photoURL: null,
      replyCnt: 0,
      views: 0,
      recommand: 0
    })
    .then((res) => {
      console.log("게시글 작성 성공: ",res);
    })
    .catch(err => console.log("게시글 작성 실패: ",err))
    navigate("/boardlist")
  }

  return (
    <div className={style.container}>

      {/* 홈 > 자유게시판 */}
      <Link to="/boardlist" className={style.link}>
        <div className={style.board_type}>
          홈 &gt; 자유게시판
        </div>
      </Link>

      {/* 구분선 */}
      <hr className={style.divider}/>

      {/* 제목 입력 */}
      <div className={style.input_group}>
        <input className={style.input_title} placeholder="제목을 입력해주세요." onChange={handleTitleChange}/>
      </div>

      {/* 작성자 정보 */}
      <div className={style.author_info}>작성자: 조은준</div>

      {/* 내용 입력 */}
      <div className={style.input_group}>
        <textarea
          className={style.input_content}
          placeholder="내용을 입력 해주세요."
          onChange={handlePostChange}
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
          <img className={style.file_preview} src={trade}/>
          <img className={style.file_preview} src={trade}/>
        </div>
      </div>

      {/* 버튼들 */}
      <div className={style.action_buttons}>
        <button className={style.submit_button} onClick={() => handlePostWrite(title, post)}>
          <span>작성</span>
        </button>
        <Link to="/boardlist" className={style.link}>
          <button className={style.cancel_button}>
            <span>취소</span>
          </button>
        </Link>
      </div>
    </div>
  );
};

export default InputText;


  