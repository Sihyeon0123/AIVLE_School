'use client'
import {store} from "@/redux/store";
import {useSelector} from "react-redux";

export default function Home(){

    const upHit = () => {
        /*dispatch 를 통해 increment 리듀서를 호출 해 보자*/
        store.dispatch({type: 'counter/increment'});
    };

    const downHit = () => {
        /*dispatch 를 통해 decrement 리듀서를 호출 해 보자*/
        store.dispatch({type: 'counter/decrement'});
    }

    let count = useSelector((state) => {// store 에 등록된 모든 slice의 state 정보
        //console.log(state);/
        /* counter 에 관련된 state 값을 받아오는 코드를 추가해 주자 */
            
        return state.counter.value;
    });

    return (
        <div>
            <h3>COUNT : {count}</h3>
            <button onClick={upHit}>증가</button>
            <button onClick={downHit}>감소</button>
        </div>
    );
}