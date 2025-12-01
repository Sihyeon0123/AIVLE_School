import './App.css'
import Input from "./comp/Input.jsx";
import {useEffect, useRef, useState} from "react";
import List from "./comp/List.jsx";

export default function App() {

    const [input, setInput] = useState('');
    const [list,setList] = useState([]);

    //실제로 데이터를 받아온다고 가정하고 받아온 데이터를 통해 리스트를 만들자
    useEffect(() => {
        setList([
            {id:0,text:'Spring 공부하기',done:true},
            {id:1,text:'React.js 공부하기',done:false},
            {id:2,text:'REDUX 공부하기',done:false},
        ]);
    },[])

    const onchangeHandler=(e) => {
        const {value} = e.target;
        setInput(value);
    };

    const id = useRef(2);//ref 로 저장하지 않으면 계속 초기화 됨

    // 할일 추가
    const onInsertHandler=() => {
        // id 증가
        // id, text, done을 state 에 추가
    };

    // 할일 처리(체크, 취소선 처리)
    const onToggleHandler=(id) => {
        // list 에서 클릭한 id 값과 동일한 값이 있는 인덱스를 찾아서
        // state 값을 변경한다.
        // 그리고 변경된 값을 저장
    };

    const onDeleteHander=(id) => {        
        // id 값에 해당하는 state 값 검색
        let index= list.findIndex((item)=>item.id === id);
        let copy_list = [...list];
        // 해당 state 값 삭제
        copy_list.splice(index,1);
        setList(copy_list);
    };


    return(
        <div className="App">
            <Input onChange={onchangeHandler} onInsert={onInsertHandler} value={input}/>
            <List todos={list} onToggle={onToggleHandler} onRemove={onDeleteHander}/>
        </div>
    );

}