import style from "./Chat_input.module.css"
import avatar from "../image/avatar.png"
import info from "../image/info.png"
import emoji from "../image/emoji.png"
import img from "../image/img.png"
import EmojiPicker from "emoji-picker-react"
import { useEffect, useState, useRef } from "react"

const Chat_input = () => {
    
    const [open,setOpen] = useState(false);
    const [text,setText] = useState("");

    const endRef = useRef(null);

    useEffect(() => {
        endRef.currnt?.scrollIntoview({behavior:"smooth"})
    })

    const handleEmoji = e => {
        setText(prev => prev + e.emoji);
        setOpen(false);
    }

    return(
        <div className={style.input}>
            <div className={style.top}>
                <div className={style.user}>
                    <img src={avatar} alt=""/>
                    <div className={style.texts}>
                        <span>조 은준</span>
                        <p>재찬아, 빨리 빨리 좀 다녀라!!!!</p>
                    </div>
                </div>
                <div className={style.icons}>
                    <img src={info} alt=""/>
                </div>
            </div>
            <div className={style.center}>
                <div className={style.messege_own}>
                    <div className={style.texts}>
                        <p>제발 빨리 빨리 좀 다녀라!!!!!</p>
                        <span>1 분 전</span>
                    </div>
                </div>
                <div className={style.messege}>
                    <img src={avatar} alt=""/>
                    <div className={style.texts}>
                        <p>제발 빨리 빨리 좀 다녀라!!!!!</p>
                        <span>1 분 전</span>
                    </div>
                </div>
                <div className={style.messege_own}>
                    <div className={style.texts}>
                        <p>제발 빨리 빨리 좀 다녀라!!!!!</p>
                        <span>1 분 전</span>
                    </div>
                </div>
                <div className={style.messege}>
                    <img src={avatar} alt=""/>
                    <div className={style.texts}>
                        <p>제발 빨리 빨리 좀 다녀라!!!!!</p>
                        <span>1 분 전</span>
                    </div>
                </div>
                <div className={style.messege_own}>
                     <div className={style.texts}>
                        <img src={avatar} alt=""/>
                        <p>제발 빨리 빨리 좀 다녀라!!!!!</p>
                        <span>1 분 전</span>
                    </div>
                </div>
                <div className={style.messege}>
                    <img src={avatar} alt=""/>
                    <div className={style.texts}>
                        <p>제발 빨리 빨리 좀 다녀라!!!!!</p>
                        <span>1 분 전</span>
                    </div>
                </div>
                <div ref={endRef}></div>
            </div>
            <div className={style.bottom}>
                <div className={style.icons}>
                    <img src={img} alt=""/>
                </div>
                <input type="text" placeholder="채팅을 입력해주세요..."  value={text} onChange={e => setText(e.target.value)}/>
                <div className={style.emoji}>
                    <img src={emoji} alt="" onClick={() => setOpen(prev => !prev)}/>
                    <div className={style.picker}>
                      <EmojiPicker open={open} onEmojiClick={handleEmoji}/>
                    </div>
                </div>
                <button className={style.sendButton}>보내기</button>
            </div>
        </div>
    )
}

export default Chat_input