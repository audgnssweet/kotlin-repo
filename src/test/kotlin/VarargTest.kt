import io.kotlintest.specs.StringSpec

class VarargTest : StringSpec() {

    fun newIntList(vararg ts: Int): ArrayList<Int> {
        val result = ArrayList<Int>()
        for (t in ts) {
            result.add(t)
        }
        return result
    }

    init {

        /**
         * 여기서 *e 는 확산 (spread) 연산자 로,
         * 배열의 요소를 하나씩 가져와서 인자로 전달하라는 의미이다.
         */
        "가변 인자" {
            val e = intArrayOf(7, 8, 9)
            val list = newIntList(1, 2, 3, *e, 5)
            println(list)

            println(list[2])
            list[0] = 100
            println(list)

            list.add(10)
            println(list)

            list.remove(2)
            println(list)
        }

    }
}