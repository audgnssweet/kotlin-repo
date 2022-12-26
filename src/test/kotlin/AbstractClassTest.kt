class AbstractClassTest {

    /**
     * 추상 클래스는 자바와 마찬가지로 인스턴스화 불가능하다
     *
     * 일반 함수와 속성을 가질 수 있다. (선언과 동시 초기화도 가능)
     *
     * 추상 클래스의 프로퍼티는 기본적으로 final 이다.
     * abstract 로 지정된 추상 함수는 기본적으로 open 이다.
     */
    abstract class PlayMusic {
        val musicalInstrument: String = "피아노"
        val instrumentType: Int
            get() = 1

        abstract fun play(mi: String)
        fun sing() {}
    }

    class Professional : PlayMusic() {
        override fun play(mi: String) {
            TODO("Not yet implemented")
        }
    }

}
