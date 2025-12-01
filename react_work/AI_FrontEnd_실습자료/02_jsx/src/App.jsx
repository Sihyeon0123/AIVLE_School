export default function App(){

    let name = '김지훈';
    const gender = '남자';  //코드블록 영역의 상수
    let age = 30;           //코드 블록 영역의 변수

    return(
        <>{/*요소를 div 로 감싸는것이 싫다면 <> 를 사용 할 수 있다.*/}
            <div className="App">{/*class 는 className 으로...*/}
                <h3>안녕하세요 리액트에 잘 오셨어요</h3>
            </div>
            <div>
                {name}/{gender}/{age}{/*자바스크립트 코드는 {} 안에 넣을 수 있다.*/}
                <br/>{/*태그는 닫히지 않으면 에러가 난다.*/}
            </div>
            <div>
                {/* 항상 참 또는 거짓인 조건식을 의도적으로 허용하기 위해 아래 내용이 추가 되어야 한다. */}
                {/* eslint-disable-next-line no-constant-condition */}
                {/*조건문을 추가해 봅시다.*/}
            </div>
        </>
    );
}