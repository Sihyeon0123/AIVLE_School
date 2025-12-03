import Item from "./Item";
import {useMemo} from "react";

export default function List({todos, onToggle, onRemove}){


    /* 아래 내용을 useMemo 를 활용하여 보다 효율적으로 동작하도록 변경해 보자 */
    const list = todos.map(item=>{
        console.log('rendering'); // 입력, 체크 등 UI 에 변화가 생길때 마다 계속 재 호출
        return(
            <Item key={item.id}
                  done={item.done}
                  done_yn={item.done === true ? "done" : "yet"}
                  onToggle={()=>{onToggle(item.id)}}
                  onRemove={()=>{onRemove(item.id)}}
            >
                {item.text}
            </Item>
        );
    });


    return(<div>{list}</div>);
}
