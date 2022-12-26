import io.kotlintest.specs.StringSpec

class StringTest : StringSpec() {

    init {
        "string literal" {
            val a = """
                안녕하세요
                정명훈입니다
            """.trimIndent()

            //둘의 출력 결과가 다름에 주의
            print(a)
            println(a)
        }

        "string template" {
            val count = 77
            val s1 = "카운트 = $count"
            val s2 = "$s1 의 길이는 ${s1.length}"

            println(s1)
            println(s2)
        }
    }
}