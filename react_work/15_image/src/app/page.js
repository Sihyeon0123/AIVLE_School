import Image from "next/image";

export default function Page(props) {
  return (
      <div>
        <img src="/incheon.jpg" width={1027} height={768} alt="incheon image" />
        <hr/>
        {/* Image 태그를 활용하여 이미지를 노출해 보자 */}
        <Image src="/incheon.jpg" width={1027} height={768} alt="incheon image" 
        placeholder="blur" blurDataURL="/incheon.jpg" />
      </div>
  );
}