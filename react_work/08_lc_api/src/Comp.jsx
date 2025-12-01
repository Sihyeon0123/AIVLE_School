import {useEffect, useState} from "react";

export default function Comp({cnt}) {

    const [number, setNumber] = useState(parseInt(cnt));

    /* 렌더링 하면 무조건 호출 된다. -> 어떤 버튼을 눌러도 반응 한다.
    useEffect(() => {
        console.log('렌더링되면 호출');
    });
    */

    useEffect(()=>{
        /* 언제 호출 되는지 console 에 적어보자! */
        console.log('');
    },[]);

    useEffect(()=>{
        /* 언제 호출 되는지 console 에 적어보자! */
        console.log('');
    },[number]); //[a,b]a나 b가 변경되어 컴포넌트가 재렌더링된 이후 실행

    useEffect(()=>{
        console.log('최초 호출');
        return ()=>{
            /* 언제 호출 되는지 console 에 적어보자! */
            console.log('');
        }
    },[]);

    const handleIncrease=() => {
        setNumber(number+1);
    };

    const handleDecrease=()=>{
        setNumber(number-1);
    };

    return (
    <div>
        <h1>COUNTER : {number}</h1>
        <button onClick={handleIncrease} > + </button>
        <button onClick={handleDecrease}> - </button>
    </div>);
}