export default async function Page(props) {

    // /blog/11 의 경우 blog 폴더 밑에 11 폴더를 찾으므로 404 발생
    // ?idx=11&req=detail 의 경우 ? 뒤는 파라메터이기 떼문에 searchParams 로 받아낼 수 있다.
    /*
    props.searchParams.then(val=> console.log('searchParams',val));
    */

    const search = await props.searchParams;
    console.log('search',search);


    const item = Object.keys(search).map(key => {
        console.log(key+' : '+search[key]);
        return <li key={key}>{key}:{search[key]}</li>;
    });

    return (
        <div>
            <h1>Blog/Page.jsx</h1>
            <ul>{item}</ul>
        </div>);
}