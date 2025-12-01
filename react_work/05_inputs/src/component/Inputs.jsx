import { useState } from "react";

export default function Inputs() {

    const [inputs, setInputs] = useState({nick:'',name:''});
    /* input 안에는 {name:'',nick:''} 의 값이 있다.
    본래
    let name = input.name;
    let nick = input.nick;
    비구조할당
    let {name} = inputs;
    let {nick} = inputs;
    */
    const {name, nick} = inputs; // 이렇게 하나의 객체에서 복수개의 값을 받아 낼 수도 있다.

    const typing=(key,e) => {
        let val = e.target.value;
        console.log(key+" : "+val);
        /*setInput 함수를 활용 하여 inputs 를 복사 후 키:값 형태로 추가해 보자*/
        setInputs({});
    }

    const resetProc=(e) => {
        console.log(e);
        setInputs({name:'',nick:''});
    }


    return(
        <div>
            아이디: <input type='text' placeholder="아이디" onChange={(e)=>{typing('name',e)}} value={name}/><br/>
            닉네임: <input type='text' placeholder="닉네임" onChange={(e)=>{typing('nick',e)}} value={nick}/><br/>
            <button onClick={resetProc}>초기화</button>
            <p>아이디 : {name} / 닉네임:{nick}</p>
        </div>
    );

}