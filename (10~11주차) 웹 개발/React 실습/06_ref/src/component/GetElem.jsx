import {useRef, useState} from "react";

export default function GetElem() {
    let inputRef = useRef();
    let [val, setVal] = useState('');

    const chgText=(e) => {
        setVal(e.target.value);
    };

    const txtFocus=() => {
        /* 동작 결과를 보고 이 곳을 작성해 봅시다. */
        setVal('');
        inputRef.current.focus();   
    };

    return(
        <div>
            <h3>입력값:{val}</h3>
            {/*ref 를 통해 특정 요소를 담는다.*/}
            <input type="text" value={val} onChange={chgText} ref={inputRef}/>
            <button onClick={txtFocus}>TAB</button>
        </div>
    );
}