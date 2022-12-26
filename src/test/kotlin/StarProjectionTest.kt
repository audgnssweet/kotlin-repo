import io.kotlintest.specs.StringSpec

class StarProjectionTest : StringSpec() {

    /**
     * 코틀린에서는 List 자체 원시타입만으로 사용 불가능하고, 반드시 타입지정을 해야한다.
     * 하지만 타입을 결정할 수 없을 때 스타 프로젝션을 하면 된다.
     *
     * * 로 표현하며, 해당 시점에는 타입 인자를 알 수 없음을 의미한다.
     * 분명히 List<Any> 와는 다르다. List<Any> 는 어떤 타입의 객체든 요소로 저장할 수 있다는 것이고,
     * List<*> 은 해당 시점에서는 타입 인자를 알 수 없음을 의미한다. (아무거나 저장 안됨)
     *
     * 컴파일러가 추론할 수 없는 상황에서는 변경 함수가 아예 적용 불가능하다.
     *
     * 인자 타입이 중요하지 않은 함수에 사용하면 유용하다.
     */
    init {
        "1" {
            val l1: MutableList<Any>

//            l1 = mutableListOf<Int>() // 얘는 공변이 아니니 당연히 안된다.

            val l2: MutableList<out Any>
            l2 = mutableListOf<Int>() // 얘는 당연히 된다.

            var l3: MutableList<*>
            l3 = mutableListOf<Int>()
            l3 = mutableListOf<String>()
        }

        fun star(l: MutableList<*>) {
            println(l.size)
            println(l)
            l.add(1, 1) //얘는 컴파일 에러. 왜냐하면 무슨 타입인지 모르므로, set 하는게 안된다. 컴파일러가 추론할 수 없다면
        }
    }
}