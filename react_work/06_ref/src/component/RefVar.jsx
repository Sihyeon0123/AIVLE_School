import React from "react";

export default function RefVar(){

    //useRef 안에 새로운 속성도 추가 할 수 있다.
    //useRef 는 컴포넌트의 전 생애주기 동안 값이 유지되며 렌더링 상황에 영향 받지 않는다.
    const [stateVal,setStateVal] = React.useState(0); //React 가 붙으면 useState import 안 해와도 된다.
    const refVal = React.useRef(0);

    function updataState(){ //state 는 값 변화시 렌더링에 반영 된다
        /* 버튼(1) 을 누를 때 마다 값이 update 되는 코드를 추가해 보자*/
        setStateVal(stateVal + 1);
    }

    // 값이 변해도 렌더링이 다시 되지 않아 표현 되지 않는다.
    function updateRef(){
        /* 버튼(2) 을 눌러 증가된 값이 refVal 에 적용되도록 코드를 추가해 보자 */
        setStateVal(refVal.current += 1);
    }


    return(
        <div>
            <button onClick={updataState}>state count : {stateVal}</button>
            <button onClick={updateRef}>ref count : {refVal.current}</button>
        </div>
    );
}