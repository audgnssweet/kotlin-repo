import io.kotlintest.specs.StringSpec

class InterfaceOverridingTest : StringSpec() {

    //멤버들은 자동으로 open + abstract (함수면)
    interface PlayMusic {

        //선언과 동시에 초기화는 문법적으로 불가능하다. 오버라이딩이 목적이기 때문에
        //val musicalInstrument: String = ""
        val musicalInstrument: String

        //custom getter setter 구성 가능
        val instrumentType: Int
            get() = 1

        fun play(mi: String)
    }

    class Professional : PlayMusic {
        //프로퍼티도 기본적으로 오버라이딩 하지 않으면 안된다.
        //부모 클래스에서 적어도 getter setter 를 지정하지 않았다면.
        override val musicalInstrument: String = ""

        override fun play(mi: String) {
            TODO("Not yet implemented")
        }
    }

}

fun main() {
    val p = InterfaceOverridingTest.Professional()

    println(p.musicalInstrument)
    println(p.instrumentType) //getter 만 지정되어있지만, 호출 가능.
    println(p.play(p.musicalInstrument))
}


