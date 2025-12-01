import Item from "./Item";

export default function List({todos, onToggle, onRemove}){

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
