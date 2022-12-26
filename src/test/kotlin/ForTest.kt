import io.kotlintest.specs.StringSpec

class ForTest : StringSpec() {

    init {

        "case 1" {
            val arr = listOf("a", "b", "c")

            for (a in arr) println(a)
        }

        "case 2" {
            val arr = listOf("a", "b", "c")

            for (i in arr.indices) println("index = $i, value = ${arr[i]}")
        }

        "case 3" {
            for (i in 1..5) println(i)
            //until 은 최종값을 포함하지 않는다.
            for (i in 1 until 5) println(i)
            //step 은 몇 개씩 건너뛸지 결정할 수 있다.
            for (i in 1..10 step 2) println(i)
            //작아지는 값에는 downTo 를 지정해준다.
            for (i in 10 downTo 1) println(i)
            for (i in 10 downTo 1 step 2) println(i)
        }
    }
}