/** @type {import('next').NextConfig} */
/*
	Next.js를 실행할 때 왼쪽 하단에 뜨는 "N" 버튼은 Next.js 14 이후 버전에서 도입된
	**Turbopack의 개발 도구 오버레이(UI)**입니다.
	이건 개발 환경에서만 보이는 디버깅용 UI 요소.(npm run dev 에만)
	일반 사용자에게는 보이지 않습니다.
*/
const nextConfig = {
    reactStrictMode:false
};

export default nextConfig;
