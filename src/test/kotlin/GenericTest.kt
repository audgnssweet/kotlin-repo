import io.kotlintest.specs.StringSpec

class GenericTest : StringSpec() {

    /**
     * 클래스와 인터페이스 또는 함수의 타입을 미리 지정하지 않고 정의해둔 뒤, 사용하는 시점에서 정할 수 있도록 하는 것이 제네릭
     * 타입 매개변수 형태로 받아서 타입을 지정한다. -> 코드 중복 제거 + 컴파일 타임에서 타입 안전성 검사
     *
     * 타입 매개변수의 표준 명칭
     * E - 컬렉션 저장 요소
     * K - 키
     * N - 숫자
     * T - 타입 (Any?)
     * V - 값
     *
     * 제네릭 타입 클래스의 타입은 (원시 타입 + 제네릭 타입) 이다.
     * List<Int> 에서 List 를 원시타입, Int 를 제네릭 타입이라고 한다.
     * ArrayList<Int> 는 ArrayList<Number> 의 하위 타입이 아니다. 제네릭 타입이 다르므로.
     * 하지만 ArrayList<Int> 는 List<Int> 의 하위 타입이다. 제네릭 타입이 같은데 원시 타입이 상하위 관계이므로.
     * ArrayList<Int> 와 List<Int> 는 변형 제한자를 지정해야 상 하위 타입으로 사용할 수 있다.
     *
     * 타입 매개변수를 제한하지 않으면, 기본적으로 Any? 타입이다.
     *
     */
    init {
        /**
         * T 는 제네릭으로, 타입 매개변수를 나타낸다.
         * 이 함수를 호출할 때 <> 안에 특정 타입을 집어넣을 수 있음을 의미한다.
         * 이 함수가 호출될 때 지정된 타입으로 대체된다.
         */
        fun <T> newList(vararg ts: T): ArrayList<T> {
            val result = ArrayList<T>()
            for (t in ts) {
                result.add(t)
            }
            return result
        }

        /**
         * <Int> 를 타입 인자 라고 하며, 타입 매개변수가 타입 인자로 대체된다.
         * 기입하지 않더라도 컴파일러가 추론해준다.
         */
        "use" {
            newList<Int>(1, 2, 3)

            /**
             * 자바와는 달리 인터페이스 날탕으로 사용 못하고 반드시 타입을 지정해주거나 혹은 컴파일러가 타입을 추론할 수 있는 상황이어야 한다.
             */
//            val l : List = listOf(1, 2, 3)
        }

        /**
         * 상계 (upper bound)
         * 상위 타입을 제한한다.
         * Number 의 하위 타입밖에 올 수 없다.
         */
        fun <T : Number> sum(vararg ts: T): Double {
            var result = 0.0
            for (t in ts) {
                result += t.toDouble()
            }
            return result
        }

        fun <T : Comparable<T>> min(first: T, second: T): T {
            return if (first < second) first else second
        }

    }

    /**
     * 클래스 혹은 인터페이스도 마찬가지로 사용할 수 있다.
     */
    class Box<E>
    interface IBox<E>

    /**
     * 타입 소거.
     * 제네릭은 JDK 5 에서 추가되었는데, 그 이상 버전에서는 제네릭으로 지정된 타입 매개변수의 정보를 바이트코드에 추가가 된다.
     * 하지만 5 이전 버전은 그게 안돼서 호환성 때문에 타입 소거를 시킨다. -> 원시 타입만으로 처리된다.
     *
     * 그래서 런타임시에 JVM은 List<Int> 인지 List<String> 인지 알 길이 없다.
     * 그래서 컴파일러가 타입 변환과 확인을 해주는 코드를 추가하여 바이트 코드를 생성한다.
     *
     * 아래 두 메서드 시그니쳐는 충돌한다. 왜? 위에서 말했듯이 런타임에는 메서드 시그니쳐가 완전히 같아지기 때문에
     * 그래서 @JvmName 어노테이션을 붙여줘야 한다. -> 바이트 코드에서 이름이 printInt 로 바뀐다.
     *
     * @JvmStatic 은 Object 로 선언된 객체 혹은 동반 객체의 함수나 속성 앞에 지정할 수 있는데,
     * 코틀린 컴파일러가 해당 함수나 속성을 JVM static 으로 만들어서
     * 자바 코드에서 코틀린 클래스를 사용할 때 INSTANCE 혹은 Companion 을 사용하지 않아도 된다.
     */
    @JvmName("printInt")
    fun print(ls: List<Int>) {

    }

    fun print(ls: List<String>) {

    }

    /**
     * 아래는 컴파일 에러.
     * 타입 소거 때문에 런타임에는 왼쪽 피연산자가 원시 타입만 남아서 타입 비교가 불가능하다.
     */
    fun <T> checkType(s: Any) {
//        if (s is T) // 컴파일 에러
    }

    /**
     * 아래는 가능하다.
     * 타입 매개변수 실체화 때문이다.
     *
     * inline + reified 를 사용하면 된다.
     * 타입 매개변수를 타입 참조로 교체하여 바이트 코드를 생성한다.
     */
    inline fun <reified T> checkTypeReified(s: Any) {
        if (s is T) {

        }
    }
}