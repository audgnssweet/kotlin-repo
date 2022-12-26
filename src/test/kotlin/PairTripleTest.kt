import io.kotlintest.specs.StringSpec

class PairTripleTest : StringSpec() {

    init {
        val (a1, b1) = Pair(1, "페어")
        val (a2, b2, c2) = Triple(2, "트리플", listOf(1, 2))
    }
}