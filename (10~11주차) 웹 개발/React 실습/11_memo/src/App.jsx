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

    // App.js 에서 입력 받은 내용을 Prop 을 통해 TodoInput.js 로 전달 시킨다.
    const onchangeHandler=(e) => {
        const {value} = e.target;
        setInput(value);
    };

    const id = useRef(2);//ref 로 저장하지 않으면 계속 초기화 됨

    const onIntertHandler=() => {
        console.log(input+' insert!');
        id.current++;
        // key, 할일, 처리여부
        let todo = {id:id.current,text:input,done:false};
        console.log(todo);
        setList([...list,todo]);//spread 로 기존 list 는 복사하여 놔두고 뒤에 새로운 객체를 붙인다.
        setInput('');
    };

    const onToggleHandler=(id) => {
        //console.log(id);
        // 1. list 에서 클릭한 id 값과 동일한 값이 있는 인덱스를 찾아서
        let index= list.findIndex((item)=>item.id === id);
        // state 값을 변경한다.
        let copy_list = [...list]; // 안전하게 하기 위해 복사
        copy_list[index].done = !copy_list[index].done; // 해당 인덱스의 done 값을 반전
        //그리고 변경된 값을 저장장
        setList(copy_list);
    };

    const onDeleteHander=(id) => {
        // 해당 아이디를 찾아서 list 에서 지우면 된다.
        let index= list.findIndex((item)=>item.id === id);
        let copy_list = [...list];
        copy_list.splice(index,1);
        setList(copy_list);
    };


    return(
        <div className="App">
            <Input onChange={onchangeHandler} onInsert={onIntertHandler} value={input}/>
            <List todos={list} onToggle={onToggleHandler} onRemove={onDeleteHander}/>
        </div>
    );

}