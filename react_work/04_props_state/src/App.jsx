import PropBtn from './component/PropBtn.jsx'
import StateBtn from './component/StateBtn.jsx'

const App = ()=>(
    <div>
        {/*선언된 컴포넌트는 태그 형식으로 사용 할 수 있다.*/}
        <PropBtn name="This is Prop button"/>
        <StateBtn name="This is State Button"/>
    </div>
);


export default App;
