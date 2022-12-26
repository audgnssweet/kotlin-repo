import io.kotlintest.specs.StringSpec

class LambdaAndItTest : StringSpec() {

    init {

        /**
         * it 키워드 사용의 두 가지 조건
         *
         * 인자가 반드시 한개여야 한다
         * 인자의 타입을 추론할 수 있어야 한다.
         */
        "it 키워드" {
            val lambda: (Int) -> Int = { it * 2 }

            listOf("a", "b").forEach { println(it) }
        }

        "여러 형태로 사용해보기" {
            val fList = listOf("a", "b", "c")

            //String::length 처럼 클래스의 프로퍼티로 참조한다면 필드가 아닌 프로퍼티기 때문에 속성이 getter 를 통해 참조된다.
            fList.filter { it.startsWith("a") }
                .map { String::length }

            //위와 달리 그냥 it 으로 참조하는 것도 당연히 가능하다
            fList.filter { it.startsWith("a") }
                .map { it::length }
        }
    }

}