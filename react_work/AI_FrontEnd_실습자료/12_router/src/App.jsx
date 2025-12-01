//npm install react-router-dom

import {BrowserRouter, Link, Route, Routes} from "react-router-dom";
import Home from "./Home.jsx";
import First from "./First.jsx";
import Second from "./Second.jsx";
import Topics from "./Topics.jsx";

// Link to -> Route path -> 특정 Component
// Link to : a href
// Route : 이런 요청이 왔을 경우 이걸 불러와라
export default function App() {
    return (
        <BrowserRouter>
            <div>
                <ul>
                    {/* Link === a href */}
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="/first">First</Link></li>
                    <li><Link to="/second">Second</Link></li>
                    <li><Link to="/topics">Topic</Link></li>
                </ul>
            </div>
            <Routes>
                {/* 위 링크를 통해 특정 컴포넌트로 이동되는 내용을 작성하시오 */}
            </Routes>
        </BrowserRouter>
    );
}