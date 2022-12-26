import io.kotlintest.specs.StringSpec

class PlatformTypeTest : StringSpec() {

    /**
     * 플랫폼 타입 = 자바 클래스
     * 자바에서는 nullable non-nullable 클래스를 구분하지 않기 때문에
     * 코틀린에서 null 값 여부를 확인해야 한다.
     */
    init {
//        fun printJavaClass(jClass: JavaClass) {
//            println(jClass.platformVar.lowercase())
//
//            println((jClass.platformVar ?: "null 입니다!").lowercase()) //여기처럼 작성해줘야 한다
//        }

        "null 로 전달했을 때 문제가 생길 수 있음" {
//            printJavaClass(JavaClass(null))
        }
    }
}