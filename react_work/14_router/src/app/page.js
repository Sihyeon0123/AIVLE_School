import Link from "next/link";

// 모든 폴더에 대표 컴포넌트는 page 라는이름을 가지고 있어야 한다.
export default function Page(props) {
  //blog 폴더가 있어야 한다.
  return (
      <div>
        <h1>Main Page</h1>
        <p><Link href="/blog">페이지 이동</Link></p>
        <p><Link href="/blog?idx=11&method=detail">query parameter</Link></p>
        <p><Link href="/blog/11">path variable</Link></p>
      </div>
  );
}