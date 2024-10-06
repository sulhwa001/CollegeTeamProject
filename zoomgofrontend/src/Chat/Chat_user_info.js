import style from "./Chat_user_info.module.css"
import avatar from "../image/avatar.png"
import more from "../image/more.png"
import video from "../image/video.png"
import edit from "../image/edit.png"

const Chat_user_info = () => {
    return(
        <div className={style.user_info}>
            <div className={style.user}>
                <img src={avatar} alt=""/>
                <h2>박 재찬</h2>
            </div>
            <div className={style.icons}>
                <img src={more} alt=""/>
                <img src={video} alt=""/>
                <img src={edit} alt=""/>
            </div>
        </div>
    )
}

export default Chat_user_info