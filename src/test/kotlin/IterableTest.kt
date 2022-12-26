import io.kotlintest.specs.StringSpec

/**
 * Iterable 은 컬렉션 최상위 인터페이스이다. (Map 제외)
 * 코틀린에서는 당연히 MutableIterable 도 존재한다.
 *
 * 저장된 요소 전체를 대상으로 검색하거나, 합계를 구하거나, 요소가 있는지 확인해주는 등
 *
 * 컬렉션의 요소를 반복 처리할 때는 반복자 (iterator) 를 사용한다.
 * iterator 인터페이스로 정의되어 있다.
 */
class IterableTest : StringSpec() {

    init {
        "use" {
            val ar = listOf(1, 2, 3, 4, 5, 6)

            //iterator() 를 호출하면 컬렉션의 iterator 객체를 반환한다.
            val iterator = ar.iterator()
            while (iterator.hasNext()) {
                println("item = ${iterator.next()}")
            }
            println()

            //코틀린에서는 for 루프에서 자동으로 iterator 를 생성하여 지원한다.
            for (i in ar) {
                println("item = $i")
            }

            //CharRange 도 iterator 대상
            for (i in 'a'..'g') {

            }

            //String 도 iterator 대상
            for (ch in "This is String") {

            }
        }
    }
}