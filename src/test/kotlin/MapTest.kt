import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class MapTest : StringSpec() {

    init {

        data class Friend(val name: String, val age: Int)

        val map = mutableMapOf(
            1 to Friend("kim", 20),
            Pair(2, Friend("lee", 25)),
            3.to(Friend("jeong", 30))
        )

        "1" {
            for ((k, v) in map) {
                println("key = $k, value = $v")
            }

            map.forEach { k, v -> println("key = $k, value = $v") }
        }

        "2" {
            map.size shouldBe 3
        }

        "3" {
            map.isEmpty() shouldBe false
            map.isNotEmpty() shouldBe true
            map.none() shouldBe false
        }

        "4" {
            map.contains(2) shouldBe true
            map.containsKey(1) shouldBe true
            map.containsValue(Friend("lee", 25)) shouldBe true
        }

        "5" {
            map.count() shouldBe 3
            map.count { it.value.age >= 25 } shouldBe 2
        }

        "6" {
            map.get(2)
            map[2]
        }

        "7" {
            map.put(4, Friend("oh", 40))
            map[5] = Friend("nam", 13)
        }

        /**
         * plus 하면 요소 추가하고 새로운 맵 만들어서 반환
         */
        "8" {
            val newMap = map.plus(6 to Friend("ku", 11))
        }

        /**
         * getOrPut 하면 새로운 value put 하고 put 한 value 반환함
         */
        "9" {
            val putValue = map.getOrPut(10) { Friend("kang", 10) }
        }

        "10" {
            map.remove(10)
        }

        /**
         * 람다식을 적용한 키 혹은 값 으로 구성된 새로운 Map 을 반환한다.
         */
        "11" {
            val keyMap = map.mapKeys { it.value.age }
            val valueMap = map.mapValues { it.value.name }
        }

        /**
         * 키만 가지고 필터링, value 만 가지고 필터링
         */
        "12" {
            map.filterKeys { it > 5 }
            map.filterValues { it.age > 25 }

            map.filter { it.key > 5 }
        }

        "13" {
            map.toList()
            map.toMutableMap()
            map.toMap()
            map.toSortedMap()
        }
    }
}