import io.kotlintest.matchers.collections.shouldContainExactly
import io.kotlintest.specs.StringSpec

class ArrayTest : StringSpec() {

    init {

        "arrayOf 배열선언" {
            val arr = arrayOf("a", "b", "c")

            println(arr) //주소값 출력
            println(arr.toString()) //마찬가지로 주소값 출력
        }

        "arrayOfNulls 배열선언" {
            val narr = arrayOfNulls<String>(2)

            println(narr) //주소값 출력
            println(narr.toString()) //마찬가지로 주소값 출력
        }

        "iteration" {
            val fruit = arrayOf("사과", "배", "포도")

            for (f in fruit) {
                println(f)
            }
        }

        "선언과 동시에 초기화" {
            //아래 두 식은 같음
            val arr = Array(5) { i -> i.toString() }
            val arr2 = Array(5, { i -> i.toString() })

            arr contentDeepEquals arr2
        }

        "primitive type array" {
            //아래 두 개는 다르다. 위는 wrapper 클래스로 감싸지 않고, 아래는 감싼다.
            intArrayOf(1, 2, 3)
            arrayOf(1, 2, 3)
        }

        "인덱스 사용" {
            val arr = arrayOf("a", "b")
            println("arr 의 2번째 요소 = ${arr[1]}")
        }
    }
}