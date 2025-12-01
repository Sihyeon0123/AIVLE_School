//Props에는 상위 컴포넌트에서 전달받은 값이 담겨있으며 변경 불가능하다.
const PropBtn = ({name})=>{//App 에서 전달 해준 name 값을 {name} 형태로 받을 수 있다.
    const sendMsg = (name) => {
        alert(`Your name is ${name}`);
    }
    return(
        <div style={{margin:10}}>
            <button onClick={()=>sendMsg(name)}>Click Me</button>
            {name}
        </div>
    );
}

export default PropBtn;