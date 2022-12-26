import io.kotlintest.matchers.collections.shouldContainExactly
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class StreamSequenceTest : StringSpec() {

    /**
     * 코틀린의 컬렉션 대상 확장 함수들은 기본적으로 컬렉션 to 컬렉션이기 때문에
     * 루프 퓨전, 쇼트 서킷의 장점을 누릴 수 없다.
     *
     * 기본적으로 시퀀스 혹은 스트림을 사용해야 지연 연산이 이뤄지기 때문이다.
     * 여기의 출력 값은 List 가 아니라 Pipeline 으로 나온다. (익명 객체)
     * 왜냐하면 최종 연산이 이뤄지지 않았기 때문이다.
     *
     * 시퀀스는 내부적으로 익명 클래스 객체로 생성되어 인라인 처리된다.
     *
     * 코틀린의 시퀀스와 스트림은 자바 8 의 스트림과 같은 개념이다.
     * 그러나 자바의 스트림은 JDK 8 이상 버전에서만 사용 가능하다.
     * 반면 코틀린은 JDK 6 부터 사용 가능한 시퀀스가 있으며, 코틀린 1.1 에 스트림이 추가되어 계속 진화중이다.
     * 현재 코틀린은 버전 1.7.21 까지 나왔으며, java 의 parallel stream 을 지원하지 않는다. -> 직접 사용해야 한다.
     *
     */
    init {
        "1" {
            val map = listOf(1, 2, 3, 4, 5).stream()
                .map { it }
            println(map)
        }

        "2" {
            listOf(1, 2).asSequence()
                .sum()
        }

        /**
         * generateSequence 의 첫 인자는 시작인자, 두 번째 인자는 다음 값을 어떻게 결정할지
         *
         * takeWhile 은 nextVal 이 조건을 만족할 때 까지만 생성해라
         *
         */
        "3" {
            val seq1 = generateSequence(0) { it + 1 }
//            println(seq1.toList()) // 이러면 바로 outOfMemory 생김. 왜 ? 조건이 없이 계속 sequence 를 생성하기 때문에

            val seq2 = seq1.takeWhile { it <= 5 }

            println(seq2.toList())
        }

        "4" {
            val seq = sequenceOf(1, 2, 3, 4, 5)
            seq.sum() shouldBe 15
        }
    }
}
