import io.kotlintest.matchers.collections.shouldContainExactly
import io.kotlintest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotlintest.matchers.maps.shouldContainKey
import io.kotlintest.matchers.maps.shouldContainKeys
import io.kotlintest.matchers.maps.shouldNotContainKey
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.util.LinkedList

/**
 * 일반적으로 배열은 언어 구성 요소에 포함되지만, 코틀린은 Array 클래스를 제공한다.
 *
 * 코틀린은 컬렉션을 사용하는데 필요한 모든것
 * 인터페이스, 클래스, 속성, 최상위수준 함수, 확장 함수까지 kotlin.collections 패키지에 있어서 import 가 필요 없다.
 *
 * 컬렉션의 기능들은 인터페이스에 정의되어 있다.
 * 그리고 각 구체 클래스들에서 각 특성에 맞는 구조를 가지며 기능들을 구현한다.
 *
 * 대표적인 인터페이스는
 * Iterable -> Collection
 * -> List -> (구현) -> ArrayList, LinkedList
 * -> Set -> (구현) -> HashSet, LinkedHashSet, TreeSet
 * Map -> (구현) -> HashMap, LinkedHashMap, TreeMap
 *
 * Iterable 은 Collection 의 상위 인터페이스로서, 자료구조의 순회를 기본 기능으로서 정의한다.
 *
 * 위 인터페이스들은 이름만 똑같이 코틀린에서 새로 정의한 것인데, 이유는 가변과 불변을 나누기 위해서다.
 * 위 인터페이스들은 기본적으로 가변이라서 몇 개의 메서드를 제외해야 했기 때문이다.
 *
 * 코틀린에서는 Collection 을 두 가지 종류로 나눈다.
 * 변경 가능한 컬렉션과, 변경 불가능한 컬렉션이다.
 * 변경 가능한 컬렉션들은 Prefix 로 Mutable 이 붙는다.
 *
 * 타입으로 직접 생성해주면, 타입에 따라서 컴파일러가 변경 가능한 컬렉션인지 아닌지 추론해서 생성해준다.
 *
 * 매번 타입을 신경 쓰면서 정의하면 귀찮기 때문에
 * 코틀린에서는 컬렉션을 쉽게 생성할 수 있는 함수를 제공한다.
 * listOf(), mutableListOf() 이런거.
 *
 * 컬렉션을 생성할때는 코틀린에서 제공하는 메서드들로 생성하는 편이 좋다.
 * 그리고 타입을 직접 지정해서 생성하게 된다면,
 * 적어도 변수의 타입은 상위타입, 즉 Mutable 혹은 NON-Mutable 로 지정하는 편이 좋다.
 *
 * 또한 컬렉션 인터페이스들에는 코틀린의 여러 확장 함수들이 정의되어 있다.
 * 대표적으로 filter 가 있는데,
 * 이건 해당 리스트를 필터링해서 새로운 리스트로 반환한다.
 * 즉, 자바의 스트림을 대상으로 하는 그것과는 다른 것이다. -> 주의해야 한다.
 *
 * 읽기 전용 컬렉션이라도, 단순히 인터페이스로서만 변경을 제한하고 있기 때문에
 * 자바 코드로 컬렉션을 넘길 때는 주의해야 한다.
 * -> 코틀린 컴파일러가 자바 코드를 검사할 수는 없는 노릇이기에...
 *
 */
class CollectionTest : StringSpec() {

    init {
        "list 사용해보기" {
            val ls = listOf(1, 2, 3, 4) // array list 로 만든다
            // ls.set(0, 5) - 불변 컬렉션이므로 컴파일 에러

            val ml = mutableListOf(1, 2, 3, 4) // array list 로 만든다.
            ml.set(0, 5)
            ml.first() shouldBe 5
            ml[0] = 6
            ml.first() shouldBe 6
            ml.remove(6)
            ml.first() shouldBe 2

            //linked list 는 확장함수 차원에서 제공하지 않는다.
            val ll = LinkedList<Int>()
            ll.add(1)
            ll.add(2)
            ll.removeFirst()
            ll.first() shouldBe 2

            //not null 로 선언하면, null 값을 허용하지 않는다. - 그냥 제외시켜버림
            val nl = listOfNotNull(1, 2, null, 4, 5, null)
            nl shouldContainExactly listOf(1, 2, 4, 5)
        }

        "set 사용해보기" {
            val st = setOf(3, 2, 1, 3, 2) // linked hash set 으로 생성
            // st.remove(1) - 불변 컬렉션 이므로 컴파일 에러

            val ms = mutableSetOf(3, 2, 1, 3, 2) // linked hash set 으로 생성
            ms.remove(3)
            ms shouldContainExactly listOf(2, 1)

            val hs = hashSetOf(3, 2, 4, 3, 2, 1)
            hs.remove(3) // hash set 은 기본적으로 가변
            hs shouldContainExactlyInAnyOrder listOf(1, 2, 4)

            val lk = linkedSetOf(3, 2, 4, 3, 2, 1)
            lk.remove(2) // 가변
            lk shouldContainExactly listOf(3, 4, 1)

            val sr = sortedSetOf(Comparator { o1, o2 -> o2 - o1 }, 2, 3, 1, 4)
            sr shouldContainExactly listOf(4, 3, 2, 1)
        }

        "map 사용해보기" {
            val mp = mapOf(Pair("사과", 1), Pair("귤", 5), Pair("키위", 2)) //기본적으로 linked hash map
            // mp.remove("사과") - 읽기 전용이기에 컴파일 에러

            // to 는 infix - 중위 함수이다.
            val mt = mutableMapOf("사과" to 1, "귤" to 5, "키위" to 2) //마찬가지로 linked hash map
            mt.remove("사과")
            mt.shouldContainKeys("귤", "키위")
            mt.shouldNotContainKey("사과")

            val hm = hashMapOf("사과" to 1, "귤" to 5, "키위" to 2)
            hm.remove("사과")

            val sm = sortedMapOf({ k1, k2 -> k1.compareTo(k2) }, "사과" to 1, "귤" to 5)
            sm["키위"] = 3
            sm.shouldContainKey("키위")
            sm.firstKey() shouldBe "귤"
        }
    }
}