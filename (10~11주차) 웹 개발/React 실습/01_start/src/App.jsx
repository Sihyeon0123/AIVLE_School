import './App.css'
// npm run install 이 web storm 에 뜨는지 확인해서 눌러주자
// 아니면 직접 설치해 줘야 함 -> 이후 dev run 버튼 누름 -> 이 부분 추가해 줘야 할 듯
const html = (<div>Hello, React.js</div>);

function App() {
    return (
        <div>
            {html}
        </div>
    );
}

export default App
