import {Link, Route, Routes, useParams} from 'react-router-dom';

export default function Topics() {

    return(
        <div>{/*BrowerRouter 는 앱당 한번만 사용 가능 하다.*/}
            <h2>Topics</h2>
            <ul>
                <li><Link to="/topics/component">Component</Link></li>
                <li><Link to="/topics/props_v_state">Props vs State</Link></li>
            </ul>
            <Routes>
                <Route path='/:topicId' element={<Topic/>} />
            </Routes>
        </div>);
}

// 하나의 jsx 파일에 여러 Component 사용이 가능하다.
function Topic(){
    console.log(useParams());
    let {topicId} = useParams();
    return <h3>Requested topic ID: {topicId}</h3>;
}
