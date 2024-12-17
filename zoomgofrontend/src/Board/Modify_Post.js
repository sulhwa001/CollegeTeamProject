import { Link, useNavigate } from "react-router-dom";
import style from "./Modify_Post.module.css"
import { useSearchParams } from "react-router-dom"
import trade from "../image/trade.jpg"
import { useEffect, useState } from "react";
import axios from "axios";

const ModifyText = () => {

  //Params값 가져오기 위한 준비
  let [query, setQuery] = useSearchParams();

  //게시글 번호 Param값 받아오기
  let detail = query.get("postNo")

  //게시글 Detail 보여주기전 초기화
  const [data, setData] = useState({
    communityType: "",
    createdDate: "",
    memberNickname: "",
    memberNo: null,
    modifiedDate: null,
    photoURL: null,
    post: "",
    postNo: null,
    recommend: 0,
    replyCnt: 0,
    title: "",
    views: 0
  })

  const navigate = useNavigate();

  const [title, setTitle] = useState("");

  const [post, setPost] = useState("");

  const handleTitleChange = (e) => {
    console.log("title change : ", e.target.value)
    setTitle(e.target.value);
  }

  const handlePostChange = (e) => {
    console.log("post change : ", e.target.value)
    setPost(e.target.value);
  }

  console.log(detail)

  useEffect(() => {
    axios.get("http://localhost:8080/zoomgo/board/detail",{
      params: {
                postNo: detail
      }
    })
    .then(res => {
      setData(res.data);
      setTitle(res.data.title);
      setPost(res.data.post);
      })
    .catch(err => console.log(err))
  },[]);

  const handlePostModify = (title,post,photoURL,replyCnt,views,recommand) => {
      axios.put("http://localhost:8080/zoomgo/board/detail",{
        postNo: detail,
        memberNo: 1,
        communityType: "자유",
        title: title,
        memberNickname: "지각쟁이",
        post: post,
        photoURL: photoURL,
        replyCnt: replyCnt,
        views: views,
        recommand: recommand
      })
      .then(res => {
        console.log("수정 완료 : " , res);
        console.log(detail);
        })
      .catch(err => console.log(err))
      navigate(`/detail/?postNo=${detail}`)
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
        <input className={style.input_title} placeholder="제목을 입력해주세요." onChange={handleTitleChange} value={title}/>
      </div>

      {/* 작성자 정보 */}
      <div className={style.author_info}>작성자: 조은준</div>

      {/* 내용 입력 */}
      <div className={style.input_group}>
        <textarea
          className={style.input_content}
          placeholder="내용을 입력 해주세요."
          onChange={handlePostChange}
          value={post}
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
        <button className={style.submit_button} onClick={() => handlePostModify(title,post,data.photoURL,data.replyCnt,data.views,data.recommend)}>
          <span>수정</span>
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

export default ModifyText;


  