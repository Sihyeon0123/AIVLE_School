import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css' // App.js 로 부터 App 을 불러 온다.
import App from './App.jsx' // App.js 로 부터 App 을 불러 온다.

//어떤걸 그릴까?, 어디에 그릴까?(index.html 의 id=root)
createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
