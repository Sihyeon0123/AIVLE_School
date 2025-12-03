export default function Blog(props){
    console.log(props);
    let {posts} = props; // 비구조할당
    console.log(posts);

    const style = {
        borderBottom: '1px solid lightgray',
    }

    // 반복되는 요소에는 유니크한 값을 넣도록 권장한다.
    // 안타깝게도 Symbol() 은 사용 할 수 없다.
    const list = posts.map((post) => {
        return (<div style={style} key={post.id}>
            <h3>{post.id}: {post.title}</h3>
            <p>카테고리: {post.category}</p>
        </div>);
    })
    return <>{list}</>

}