export default function Input({value, onChange, onInsert}) {

    const keyUpHandler = (e) => {
        if(e.key === 'Enter') {
            onInsert();
        }
    }

    return (
        <div>
            <h2>해야 할 일</h2>
            <hr/>
            <input type="text" onChange={onChange} value={value} onKeyUp={keyUpHandler}/>
            <button onClick={onInsert}>추가</button>
        </div>
    );

}