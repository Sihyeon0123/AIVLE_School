export default async function page(props){ //params, searchParams
    // props.params : path variable parameter
    const param = await props.params;
	// [slug] 로 생성후 [...slug] 로 변경해 보자
    console.log(param); // 폴더명이  [...slug] 이면 이후 모든 경로를 배열로 받는다.
    // 그리고 url 로 테스트 해 보자!
    // blog/11				slug:[11]
    // blog/food/11			slug:[food,11]
    // blog/food/2025/04/15	slug:[food,2025,04,15]

    let list = <li key={param.slug}>{param.slug}</li>;
    /* 폴더명이 [...slug] 로 변화하게 되면 받는 형식이 달라져야 한다.
    if(Array.isArray(param.slug)){
        list = param.slug.map((item, idx) => {
            console.log(item);
            return <li key={idx}>{item}</li>
        });
    }
    */

    return (
        <>
            <p>경로로 받아온 params</p>
            <ul>{list}</ul>
        </>
    );
}