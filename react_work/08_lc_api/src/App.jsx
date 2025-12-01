import Comp from "./Comp.jsx";
import {useState} from "react";

export default function App() {

    const [comp, setComp] = useState(<Comp cnt={1}/>);

    return<div>
        {comp}
        {/*강제로 Component 지워보기*/}
        <button onClick={()=>{setComp(null)}}>component 삭제</button>
    </div>
}