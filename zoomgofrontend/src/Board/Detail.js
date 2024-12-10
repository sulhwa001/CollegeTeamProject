import style from "./Detail.module.css";
import { Link, useNavigate } from "react-router-dom";
import trade from "../image/trade.jpg"
import { useSearchParams } from "react-router-dom"
import { useEffect, useState } from 'react';
import axios from "axios";

const Datail = () => {

  const navigate = useNavigate();

  //Params값 가져오기 위한 준비
  let [query, setQuery] = useSearchParams();

  //게시글 번호 Param값 받아오기
  let detail = query.get("postNo")

  //대댓글 작성을 위해 작성창 보이게 하기 위한 준비
  const [isReplyVisible, setIsReplyVisible] = useState({});

  const [commentNo, setCommentNo] = useState(0);

  //대댓글 버튼 클릭시 숨겨져있던 대댓글 작성창이 표시
  const handleReplyClick = (commentId) => {
    setIsReplyVisible((prevState) =>({
      ...prevState,
      [commentId]: !prevState[commentId],
    }));
  }

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
  
  //댓글 내용 받아오기 위한 준비
  const [commentData, setCommentData] = useState([])

  
  //게시글 Param값인 PostNo를 이용하여 받아오기
  useEffect(() => {
    axios.get("http://localhost:8080/zoomgo/board/detail",{
      params: {
                postNo: detail
      }
    })
    .then(res => {
      setData(res.data);
      })
    .catch(err => console.log(err))
  },[]);

  //게시글 Param값인 PostNo를 이용하여 댓글 리스트 받아오기
  useEffect(() => {
    axios.get("http://localhost:8080/zoomgo/comment/commentList",{
      params: {
                postNo: detail
      }
    })
    .then(res => {
      console.log(res)
      setCommentData(res.data);
      setCommentNo(res.data.length);
      })
    .catch(err => console.log(err))
  },[]);

  //본인이 작성한 댓글만 삭제 버튼이 보이며 클릭시 댓글 삭제
  //삭제후 화면 새로 고침으로 삭제된 것을 확인
  const handleCommentDelete = (commentId) => {
    axios.delete("http://localhost:8080/zoomgo/comment",{
      params: {
        commentId: commentId,
      }
    })
    .then((res) => {
      console.log("삭제 성공: ",res);
    })
    .catch(err => console.log(err))
    window.location.reload();
  }

  //댓글, 대댓글 작성 시 textArea태그의 변화를 저장하기 위한 준비
  const [commentText, setCommentText] = useState("");

  //textArea태그에 변화가 있을시 변화 된 값을 저장
  const handleChange = (e) => {
    setCommentText(e.target.value);
  }

  //댓글, 대댓글 작성
  //작성시 textArea태그 값 초기화 후 화면 새로 고침으로 작성된 댓글 보여주기
  const handleCommentWrite = (commentDept, commentNo) => {
    axios.post("http://localhost:8080/zoomgo/comment",{
      postNo: detail,
      memberNo: 1,
      commentNo: commentNo,
      userNickname: "지각쟁이",
      commentText: commentText,
      commentDept: commentDept
    })
    .then((res) => {
      console.log("등록 성공: ",res);
    })
    .catch(err => console.log("등록 실패: ",err))
    setCommentText("")
    window.location.reload();
  }

  //postNo에 따른 게시글을 삭제
  const hadleDetailDelete = (postNo) => {
    axios.delete("http://localhost:8080/zoomgo/board/detail",{
      params: {
        postNo: postNo
      }
    })
    .then((res) => {
      console.log("삭제 성공: ",res);
      navigate("/boardlist")
    })
    .catch(err => console.log("삭제 실패: ",err))
  }

  console.log(data)
  console.log(commentData)

  //데이터가 로딩 되지않았을 경우 보여주는 화면
  if (!data) {
    return <div>정보를 불러오는 중 입니다...</div>;
  }

  //날짜 값을 형식에 맞게 출력
  const date = new Date(data.createdDate);
  const postFormattedDate = date.toLocaleString('ko-KR',{
    year:"numeric",
    month: "2-digit",
    day: "2-digit",
    hour: "2-digit",
    minute: "2-digit",
    hour12: false
  })

  return (
    <div className={style.datail_container}>
      <Link to="/boardlist" className={style.link}>
        <div className={style.board_type}>홈 &gt; 자유게시판</div>
      </Link>

      <hr className={style.divider}/>

      <div className={style.post_detail}>
        <div className={style.post_title}>{data.title}</div>
        <div className={style.views}>조회수 : {data.views}</div>
        <div className={style.post_details}>
          <div className={style.writer}>{data.memberNickname}</div>
          <div className={style.date}>{postFormattedDate}</div>
        </div>
      </div>

      <div className={style.button_group}>
        <Link to={`/modify/?postNo=${detail}`} className={style.link}>
          <button className={style.update_button}><span>수정</span></button>
        </Link>
        <button className={style.delete_button} onClick={() => hadleDetailDelete(detail)}><span>삭제</span></button>
      </div>

      {data.photoURL &&
      (
      <img src={trade} alt="" className={style.image}/>
      )}
      <div className={style.post_content}>{data.post}</div>

      <div className={style.recommend_button_container}>
        <button className={style.recommend_button}>
          <span className={style.recommend_text}>추천</span>
          <span className={style.recommend_count}>{data.recommands}</span>
        </button>
      </div>

      <hr className={style.divider} />
      <div class={style.comments}>
            <h3>전체 댓글 ({commentData?.length || 0})</h3>
            <hr className={style.divider} />
            {
              commentData.length > 0 ? (
                <div>
                  {commentData.map((comment) => (
                    <div class={comment.commentDept > 1 ? style.reply : style.comment}>
                      <div class={style.comment_box}>
                        <div><strong>{comment.userNickname}</strong></div>
                        <button class={style.replyButton} onClick={()=>handleReplyClick(comment.commentId)}><span>대댓글</span></button>
                        <button class={comment.memberNo !== data.memberNo ? style.disabled : style.comment_delete} onClick={()=>handleCommentDelete(comment.commentId)}><span>x</span></button>
                      </div>
                      <p>{comment.commentText}</p>
                      <span>{new Date(comment.createdDate).toLocaleString('ko-KR',{
                        year:"numeric",
                        month: "2-digit",
                        day: "2-digit",
                        hour: "2-digit",
                        minute: "2-digit",
                        hour12: false
                      })}</span>
                      {isReplyVisible[comment.commentId] && (
                      <div className={style.comment_input}>
                        <div className={style.comment_write}>댓글 작성</div>
                        <textarea className={style.input_placeholder} rows={4} onChange={handleChange}></textarea>
                      </div>
                    )}
                      {isReplyVisible[comment.commentId] && (
                        <div className={style.input_button_group}>
                          <button className={style.input_button} onClick={() => handleCommentWrite(2,comment.commentNo)}>
                            <span>등록</span>
                          </button>
                        </div>
                      )}
                    </div>
                  ))}
                </div>
              ) : (
                <div>
                  <p>댓글이 없습니다.</p>
                </div>
              )
            }
      </div>

      
      <div className={style.comment_input}>
        <div className={style.comment_write}>댓글 작성</div>
        <textarea className={style.input_placeholder} rows={4} onChange={handleChange}/>
      </div>
      <div className={style.input_button_group}>
          <button className={style.input_button} onClick={() => handleCommentWrite(1,commentNo)}><span>등록</span></button>
      </div>
      
    </div>
  );
};

export default Datail;
