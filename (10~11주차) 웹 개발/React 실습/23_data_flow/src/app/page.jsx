export default function App(){
    return (
        <div>
            {/*item 을 Third 에 전달하는 과정*/}
            <First item="App Data" />
            <Island item="App Data"/>
        </div>
    );
}

function First({item}){
    return (
        <>
            <div>First Component / 거쳐가는 곳1 : {item}</div>
            <Second item={item} />
        </>
    );
}

function Second({item}) {
    return (
        <>
            <div>Second Component / 거쳐가는 곳2 : {item}</div>
            <Third item={item} />
        </>
    );
}

function Third({item}) {
    return (<div>Third Component / 최종 도착지 : {item}</div>);
}

function Island({item}){
    return (<div>Island Component / 최종 도착지 : {item}</div>);
}