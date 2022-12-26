import io.kotlintest.specs.StringSpec

/**
 * 코틀린도 자바와 마찬가지로 예외 상속 구조가 있다.
 *
 * 하지만 차이점은 코틀린에는 checked 예외가 없다.
 * 즉 throws 와 같은 키워드라던가, 반드시 try catch 를 사용해야 하는 경우는 없다.
 */
class CustomExceptionTest : StringSpec() {

    init {
        try {
            throw MyException()
        } catch (e: MyException) {
            e.printStackTrace()
        }
    }
}

class MyException : Throwable()

/**
 * 여기서는 Throwable() 이 안되는데,
 * 그 이유는 MyException2 의 보조 생성자로 Throwable 을 초기화 하기 때문이다.
 */
class MyException2 : Throwable {
    constructor(): super()
    constructor(msg: String) : super(msg)
}