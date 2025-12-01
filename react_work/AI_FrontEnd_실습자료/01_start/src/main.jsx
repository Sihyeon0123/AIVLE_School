import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css' //App.js 로 부터 App 을 불러 온다.

//어떤걸 그릴까?, 어디에 그릴까?(index.html 의 id=root)
createRoot(document.getElementById('root')).render(
  <StrictMode>
   {/* App 컴포넌트를 불러오는 코드를 작성 하세요 */}
  </StrictMode>,
)
