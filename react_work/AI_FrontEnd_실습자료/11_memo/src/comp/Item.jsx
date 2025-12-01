import {useMemo} from "react";

export default function Item({done,done_yn,onToggle,onRemove,children}){

    //let class_name = `text ${done_yn}`;//취소선을 위해 className 생성
    //console.log('children : ',children); //태그와 태그 사이 값

    // done 의 값이 변경되지 않으면 랜더링 하지 않는다.
    let class_name = useMemo(()=>{
        return `text ${done_yn}`;
    },[done]);

    return(
        <div className="item">
            <input type="checkbox" checked={done} onChange={onToggle}/>
            <div className={class_name}>{children}</div>
            <div className="delete" onClick={onRemove}>[삭제]</div>
        </div>
    );

}