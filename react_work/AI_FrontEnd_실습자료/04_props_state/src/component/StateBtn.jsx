import {useState} from 'react';

const StateBtn=() => {

    /*count 변수와 setCount 함수를 지정하여 초기 값을 100으로 지정해 보자*/
    const[count,setCount] = null;

    let updateCount = () => {
        /*setCount 를 사용해 기존 count 에서 1을 감소시켜 보자*/
    }

    return(
        <div style={{margin: 10}}>
            <button onClick={()=>{updateCount()}}>down count : {count}</button>
        </div>
    );

}

export default StateBtn;