import React from "react";

/*
클릭을 3번 한 후 SHOW ALERT 을 누르고 그동안 Click me 를 열심히 눌러보자!!
열심히 눌러봐야 alert 에는 3번만 클릭 한 것으로 나타날 것이다.

이 현상은 reder() 함수 영향이다.
alert() 이 실행되는 순간 render() 함수는 막히게 된다.
function 의 경우 render 함수 가 그자체 이기 때문에  alert() 으로 인해 render() 가 막히게 되면
값을 가져 올수가 없게 되는 것이다.
*/
export default function Comp(){

    const [count, setCount] = React.useState(0);
    const refVal = React.useRef(0);

    const btnStyle = {margin:'5px'};

    function updateCount(){
        setCount(count+1);//state 는 랜더링 상황에서만 영향을 준다.
        refVal.current = count;//ref 는 render 와 관계없이 값을 변화 시킨다.
    }

    const alertCount=() => {
        setTimeout(() => {
            alert("You clicked ON : "+count);// 그래서 alert 이 되는 순간 값을 업데이트 하지 못한다.
            /* alert 이후에도 값이 update 되도록 코드를 작성해 보자 */
        }, 3000);
    }

    return (
        <div>
            <h3>You Click {count} times</h3>
            <button style={btnStyle} onClick={updateCount}>Click me</button>
            <button style={btnStyle} onClick={alertCount}>Show Alert me</button>
        </div>
    );
}