import io.kotlintest.specs.StringSpec

class SmartCastTest : StringSpec() {

    /**
     * 스마트 캐스트 - 컴파일러가 자동으로 형변환 해주는 것
     * 두 가지 경우에 발생
     * 1. 변수 값이 null 인지 확인했을 때 -> non-nullable type 으로 캐스팅
     * 2. is 나 !is 로 변수 타입을 확인했을 때 -> 해당 type 으로 캐스팅
     *
     * 주의 할 점은,
     * 변수의 null 여부나 type 을 확인하는 코드와 사용하는 코드 사이에서
     * 변수 값이 변경된다면 스마트 캐스트를 해줄 수 없음
     *
     * 하지만 위 얘기는 참조를 변경할 수 있는 var 에서만 해당되는 얘기고,
     * val 은 전부 가능
     */
    init {

        "non-null casting" {
            var a: String? = "코틀린을 배우자"

//            println(a.length) // null check 없으면 컴파일 에러 발생

            if (a != null) {
                println(a.length)
            }
        }

        fun isCast(t: Any) {
            //is 로 체크시 캐스팅
            if (t is String) {
                println("t = ${t.length}")
            }

            //is 로 체크시 마찬가지로 캐스팅돼서 else 블록에서 사용 가능
            if (t !is String) {
                return
            } else {
                println("t = ${t.length}")
            }

            // and 왼쪽에서 체크시 오른쪽에서 캐스팅 된다.
            if ((t is String) and (t.length > 0)) {
                println("t = ${t.length}")
            }

            //or 왼쪽에서 체크시 오른쪽에서 캐스팅 된다
            if ((t !is String) or (t.length == 0)) {
                return
            }

            //when 왼쪽에서 체크시 -> 오른쪽에서 캐스팅된다
            when (t) {
                is Int -> println(t + 1)
                is String -> println(t.length + 1)
                is IntArray -> println(t.sum())
            }
        }
    }
}