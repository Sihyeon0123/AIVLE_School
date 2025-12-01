import '../App.css'


//default 란 해당 js 호출시 기본으로 보여줄 Component 를 의미함

export default function MyStyle() {
    const styles = {
        /* 결과 화면처럼 나오도록 스타일을 추가해 보자 */
    };

    return(
        <div>
            <h1 style={{color:'red'}}>Hello Inline style</h1>{/*직접 스타일 부여*/}
            <p style={styles}>JavaScript Object Style</p>	{/*자바스크립트 객체에 스타일 부여*/}
            <span>Use Style Sheet</span>					{/*css 로 특정 태그에 부여*/}
            <h1 className="App-title">Use ClassName</h1>	{/*클래스 이름으로 부여*/}
        </div>
    );
}