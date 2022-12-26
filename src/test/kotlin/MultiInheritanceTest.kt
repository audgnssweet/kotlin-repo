import io.kotlintest.specs.StringSpec

class MultiInheritanceTest : StringSpec() {
}

open class MusicType {

    open fun sing() {}
}

interface PlayMusic {

    val musicalInstrument: String
    val instrumentType: Int
        get() = 1
    fun play(mi: String)
}

//콤마로 구분한다
class Professional(override val musicalInstrument: String) : MusicType(), PlayMusic {
    override fun play(mi: String) {
        TODO("Not yet implemented")
    }
}
