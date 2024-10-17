import style from "./Chat_input.module.css"
import avatar from "../image/avatar.png"
import keyboadrdImg from "../image/keyboard.jpeg"
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
        endRef.curent?.scrollIntoview({behavior:"smooth"})
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
                        <span>박 재찬</span>
                        <p>좋네요, 거래 하면 될 것 같아요</p>
                    </div>
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
                        <img src={keyboadrdImg} alt=""/>
                        <p>키보드 상태 입니다.</p>
                        <span>1 분 전</span>
                    </div>
                </div>
                <div className={style.messege}>
                    <img src={avatar} alt=""/>
                    <div className={style.texts}>
                        <p>좋네요, 거래 하면 될 것 같아요</p>
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