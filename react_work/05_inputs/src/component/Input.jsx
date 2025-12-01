import {useState} from "react";

export default function Input(){

    const [text,setText] = useState('');//(2)

    function getText(e){
        console.log(e.target.value);
        /* 입력내용이 표시되도록 코드를 작성해 보자*/
        setText(e.target.value);
    }

    return(
        <div>
            <h3>입력내용 : {text}</h3>
            <input id='inputStr' type='text'
                   placeholder='아무거나 입력 하세요' value={text} 
                   onChange={(e)=>{getText(e)}}/>
            <input id='init' type='button' value='초기화' onClick={()=>{setText('')}}/>
            
        </div>
    );
}