import Image from "next/image";

export default function Page(props) {
  return (
      <div>
        {/* 둘의 차이는? Image 가 img 보다 조금 더 효율 적이다. */}
        <img src="/incheon.jpg" width={1027} height={768} alt="incheon image" />
        <hr/>
        {/* 각각 다른이름으로 저장하고 확인해 보자 */}
        <Image src="/incheon.jpg"
               placeholder="blur"
               blurDataURL="/incheon_small.jpg"
               width={1027} height={768}
               alt="incheon.jpg"/>
      </div>
  );
}