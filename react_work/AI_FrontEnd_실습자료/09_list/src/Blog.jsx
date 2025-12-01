export default function Blog(props){
    console.log(props);
    let {posts} = props; // 비구조할당

    const style = {
        borderBottom: '1px solid lightgray',
    }

    // 반복되는 요소에는 유니크한 값을 넣도록 권장한다.
    // 안타깝게도 Symbol() 은 사용 할 수 없다.
    const list = posts.map((post) => {
        return (<div>
            {/* post 객체에서 값을 꺼내 리스트를 만들어 보자*/}
        </div>);
    })
    return <>{list}</>

}