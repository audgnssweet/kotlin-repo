class FunctionDefTest {
}

/**
 * 람다
 * 코틀린은 객체지향 뿐 아니라 함수형 프로그래밍도 지원
 *
 * 함수를 따로 정의하지 않고 간결하게 나타낼 수 있으며, 이름을 지정하지 않아도 된다
 * 람다식은 값처럼 처리되므로 변수에 저장하여 실행할 수 있다.
 * 람다식은 다른 함수의 인자로 전달되어 실행되거나 반환될 수 있다.
 *
 * (중요!!!!!!)
 * 아래 코드를 컴파일 하고 나면
 * sum 1, 2 까지는 최상위 레벨 함수 정의이므로, FunctionDefTestKt.class 의 public static final 함수로 정의된다.
 *
 * 아래 3, 4, 5, 6, 7 은 전부 FunctionDefTestKt.class 의 속성 (field) 로 정의된다.
 * 최상위 수준의 익명 함수나 람다식은 그렇게 정의되기 때문이다.
 * 타입은 Function2<Integer, Integer, Integer> 로 정의된다.
 * Function2 는 인자를 2개 받기 때문에 Function2 고, 인자를 몇 개 받냐에 따라서 미리 정의된 인터페이스에 숫자 맞춰서 생성된다.
 * 이것들이 람다식의 인터페이스를 나타낸다.
 * jar 파일을 열어보면 익명함수나 람다는 별개의 익명 클래스로 생성되는데
 * 상위수준클래스$속성명$1.class 의 형태가 된다.
 * (예) - FunctionDefTestKt$sum_5$1.class 의 형식이다.
 *
 * 또한 속성으로 정의되기 때문에 해당 함수에 대한 getter (속성 취급이기 때문에) 가 알아서 생긴다.
 *
 * 하지만 이것은 최상위 수준에 정의되었기 때문이고, 지역 변수로 선언될 경우 프로퍼티가 아니기 때문에 getter 가 생성되지 않는다.
 *
 * 그리고 실제로 호출될 때는 해당 클래스의 인스턴스가 생성되어, 내부에 정의된 invoke() 함수에 의해 실행된다.
 * 아래 경우에는
 * public final int invoke(int, int) 가 실행된다.
 *
 * 그래서 아래 두 코드는 같다.
 * sum_5(10, 20) == sum5.invoke(10, 20)
 *
 * 그래서 정리하면 람다식이 실행될 때마다 익명 클래스가 인스턴스화 되고, 해당 코드의 invoke 가 호출되는 구조인 것이다.
 * 그래서 반복 루프와 같은 곳에 람다식이 있는 경우 무수히 많은 인스턴스가 생성될 수 있으므로 유의해야 한다.
 *
 * 그런 이유로 코틀린에서는 inline 을 제공한다.
 */

//일반적인 함수 정의
//최상위 수준 함수이므로 컴파일러가 FunctionDefTestKt.class 의 JVM static method 로 생성한다.
fun sum_1(a: Int, b: Int): Int {
    return a + b
}

//코틀린 특유의 대입문 형태로 정의
fun sum_2_1(a: Int, b: Int): Int = a + b
fun sum_2_2(a: Int, b: Int) = a + b

//익명 함수로 정의된 함수 (함수 타입을 정의함) -> 익명 함수로 정의하면 함수에 이름을 붙여줄 필요가 없음. 그냥 변수에 바로 담는다.
//실제로는 익명 클래스로 생성된다.
val sum_3_1: (Int, Int) -> Int = fun(x: Int, y: Int): Int { return x + y }
val sum_3_2: (Int, Int) -> Int = fun(x, y): Int { return x + y }
val sum_3_3: (Int, Int) -> Int = fun(x, y) = x + y

//익명 함수로 정의된 함수 (함수 타입을 생략함)
val sum_4_1 = fun(x: Int, y: Int): Int { return x + y }
val sum_4_2 = fun(x: Int, y: Int) = x + y

//람다식으로 정의된 함수 (함수 타입이 지정됨)
val sum_5: (Int, Int) -> Int = { x, y -> x + y }

//람다식으로 정의된 함수 (함수 타입이 생략됨)
val sum_6 = { a: Int, b: Int -> a + b }

//람다식에 여러 개의 표현식을 한 줄에 작성하려면 세미콜론을 넣어야 한다.
//람다식에 여러 표현이 있다면 마지막 표현식의 결과가 반환값이 된다.
val sum_7_1 = { a: Int, b: Int -> println(a + b); a + b }
//Unit 객체가 결과값이 된다.
val sum_7_2 = { a: Int, b: Int -> a + b; println(a + b) }
