import PostList from "./PostList";
import Link from "next/link";

// java -jar server.war
export default function Home() {
  return (
      <div>
        <h3>리스트 가져오기</h3>
        <Link href="/write"><button>글쓰기</button></Link>
        <PostList page={1}/>
      </div>
  );
}
