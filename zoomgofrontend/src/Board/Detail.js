import style from "./Detail.module.css";
import { Link } from "react-router-dom";
import trade from "../image/trade.jpg"
import { useSearchParams } from "react-router-dom"
import { useEffect, useState } from 'react';
import axios from "axios";

const Datail = () => {

  let [query, setQuery] = useSearchParams();

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
  
  const [commentData, setCommentData] = useState([])

  let detail = query.get("postNo")

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

  useEffect(() => {
    axios.get("http://localhost:8080/zoomgo/comment/commentList",{
      params: {
                postNo: detail
      }
    })
    .then(res => {
      console.log(res)
      setCommentData(res.data);
      })
    .catch(err => console.log(err))
  },[]);

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

  console.log(data)
  console.log(commentData)

  if (!data) {
    return <div>정보를 불러오는 중 입니다...</div>;
  }

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
        <button className={style.update_button}><span>수정</span></button>
        <button className={style.delete_button}><span>삭제</span></button>
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
                    <div class={comment.memberNo === data.memberNo ? style.reply : style.comment}>
                      <div class={style.comment_box}>
                        <div><strong>{comment.userNickname}</strong></div>
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
        <textarea className={style.input_placeholder} rows={4}/>
      </div>
      <div className={style.input_button_group}>
          <button className={style.input_button}><span>등록</span></button>
      </div>
      
    </div>
  );
};

export default Datail;
