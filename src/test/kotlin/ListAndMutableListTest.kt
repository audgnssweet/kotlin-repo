import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec

class ListAndMutableListTest : StringSpec() {

    data class Friend(val name: String, val age: Int)

    fun Friend.speak() = println("my name is $name and age is $age")

    val fList = mutableListOf(Friend("kim", 10), Friend("lee", 20), Friend("lee", 20))

    init {

        "1" {
            fList.size shouldBe 3
            for (idx in fList.indices) {
                println("$idx -> ${fList[idx]}")
            }
        }

        "2" {
            fList.isEmpty() shouldBe false
            fList.isNotEmpty() shouldBe true
            fList.none() shouldBe false //비어있으면 true
        }

        "3" {
            fList.contains(Friend("kim", 10)) shouldBe true
        }

        "4" {
            fList.indexOf(Friend("lee", 20)) shouldBe 1
            fList[1] shouldBe Friend("lee", 20)
            fList.getOrNull(10) shouldBe null
            fList.elementAt(1) shouldBe Friend("lee", 20)
        }

        "5" {
            fList.first() shouldBe Friend("kim", 10)
            fList.last() shouldBe Friend("lee", 20)
        }

        "6" {
            fList.count() shouldBe 3
            fList.distinct().count() shouldBe 2
        }

        "7" {
            fList.component1() shouldBe Friend("kim", 10)
            fList.component2() shouldBe Friend("lee", 20)
            fList.component3() shouldBe Friend("lee", 20)
            shouldThrow<IndexOutOfBoundsException> { fList.component5() }
        }

        "8" {
            val (f1, f2, f3) = fList

            f1 shouldBe Friend("kim", 10)
            f2 shouldBe Friend("lee", 20)
            f3 shouldBe Friend("lee", 20)
        }

        "9" {
            println(fList.joinToString(", "))
        }

        "10" {
            fList.count { it.age >= 20 } shouldBe 2
        }

        "11" {
            for (f in fList) {
                f.speak()
            }
            fList.forEach { it.speak() } // 순회만
            fList.onEach { it.speak() } //순회 후 자기 자신 그대로 반환
        }

        "12" {
            fList.sortedBy { it.name }
            fList.sortedWith(compareBy({ it.name }, { it.age }))
            fList.sortedWith(compareBy(Friend::name, Friend::age))
        }

        "13" {
            fList.filter { it.age > 15 }
        }

        "14" {
            fList.map { Friend::name }
            fList.map { it.name }
        }

        "15" {
            fList.slice(0..1) shouldBe listOf(Friend("kim", 10), Friend("lee", 20))
        }

        /**
         * kotlin 의 reverse list 는 원래 list 와 동기화된다.
         */
        "16" {
            val revList = fList.asReversed()
            revList shouldBe listOf(Friend("lee", 20), Friend("lee", 20), Friend("kim", 10))

            revList.removeFirst()
            revList.size shouldBe 2
            fList.size shouldBe 2
        }

        "17" {
            fList.toMutableList()
            fList.toSet()
            fList.toMutableSet()
            fList.toHashSet()
        }

        "18" {
            val nList = listOf(1, 2, 3, 4, 5)
            nList.min() shouldBe 1
            nList.max() shouldBe 5
            nList.count() shouldBe 5
            nList.sum() shouldBe 15
        }

        /**
         * flatMap 은 여러 리스트를 flat 하여 반환하는데, 아래 그림처럼 사용할 수도 있다.
         */
        "19" {
            val nList = listOf(1, 2, 3, 4, 5)
            nList.flatMap { listOf(it, it + 1) } shouldBe listOf(1, 2, 2, 3, 3, 4, 4, 5, 5, 6)
        }

        /**
         * sort() 는 그것 자체를 정렬해버리고
         * sorted() 는 정렬한 새로운 컬렉션을 반환한다.
         */
        "20" {
            val l = mutableListOf("a5", "a11")

            val sl = l.sorted()
            l.sort()

            println("l = $l")
            println("sl = $sl")
        }
    }
}