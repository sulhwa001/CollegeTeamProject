import style from "./Chat_detail.module.css"
import avater from "../image/avatar.png"
import arrowUp from "../image/arrowUp.png"
import arrowDown from "../image/arrowDown.png"
import download from "../image/download.png"
import keyboardImg from "../image/keyboard.jpeg" 

const Chat_detail = () => {
    return(
        <div className={style.detail}>
            <div className={style.user}>
                <img src={avater}/>
                <h2>박 재찬</h2>
                <p>중고 거래</p>
            </div>
            <div className={style.info}>
                <div className={style.show_items}>
                    <div className={style.items}>
                        <img src={keyboardImg} alt=""/>
                        <span>기계식 키보드</span>
                    </div>
                </div>
                <div className={style.option}>
                    <div className={style.title}>
                        <span>Shared photos</span>
                        <img src={arrowDown}/>
                    </div>
                </div>
                <div className={style.photos}>
                    <div className={style.photoItem}>
                        <div className={style.photoDetail}>
                            <img src={keyboardImg} alt=""/>
                            <span>사진_2024_10.png</span>
                        </div>
                    </div>
                    <div className={style.photoItem}>
                        <div className={style.photoDetail}>
                            <img src={keyboardImg} alt=""/>
                            <span>사진_2024_10.png</span>
                        </div>
                    </div>
                    <div className={style.photoItem}>
                        <div className={style.photoDetail}>
                            <img src={keyboardImg} alt=""/>
                            <span>사진_2024_10.png</span>
                        </div>
                    </div>
                    <div className={style.photoItem}>
                        <div className={style.photoDetail}>
                            <img src={keyboardImg} alt=""/>
                            <span>사진_2024_10.png</span>
                        </div>
                    </div>
                    
                </div>
            </div>
            <div className={style.user_block}>
                <button>유저 차단 하기</button>
                <button>채팅방 나가기</button>
            </div>
        </div>
    )
}

export default Chat_detail