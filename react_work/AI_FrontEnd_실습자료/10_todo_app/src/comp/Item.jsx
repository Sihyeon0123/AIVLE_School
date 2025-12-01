export default function Item({done,done_yn,onToggle,onRemove,children}){

    let class_name = `text ${done_yn}`;
    return(
        <div className="item">
            <input type="checkbox" checked={done} onChange={onToggle}/>
            <div className={class_name}>{children}</div>
            <div className="delete" onClick={onRemove}>[삭제]</div>
        </div>
    );

}