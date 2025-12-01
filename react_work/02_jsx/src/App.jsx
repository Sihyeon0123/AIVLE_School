export default function App(){

    let name = '양시현';
    const gender = '남자';  //코드블록 영역의 상수
    let age = 25;           //코드 블록 영역의 변수

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
                {1+1 === 2 ? <p>맞아요</p> : <p>틀려요</p>}{/*삼항연산자도 사용 가능*/}
                {
                 (()=>{
                    if(age <= 11){
                        return <div>어린이</div>
                    }
                    else if(age >= 20 && age < 65){
                        return <div>성인</div>
                    }
                    else if(age >= 65){
                        return <div>노인</div>
                    }
                 })()
                }
            </div>
        </>
    );
}