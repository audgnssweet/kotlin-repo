import io.kotlintest.specs.StringSpec

class SetAndMutableSetTest : StringSpec() {

    /**
     * Set 은 객체 중복을 허용하지 않는다.
     * 코틀린에서는 두 객체가 있을 때 == (equals) 로 비교한다. (nullable type 도 마찬가지)
     *
     * HashSet -> 해시 테이블. 추가 삭제 탐색 O(1)
     * LinkedHashSet -> 자료의 저장순서 보장. 해싱 사용
     * TreeSet -> 트리 구조
     *
     * HashSet, LinkedHashSet 에서는 hashCode() 를 통해서 해시 코드 산출
     * Any 에 정의되어 있다.
     * 오버라이딩 한다면 다음 두 조건을 만족해야 한다.
     * 1. 두 번 이상 호출되어도 결과 동일
     * 2. == 라면 hashCode 도 동일해야 한다.
     *
     * Set 과 MutableSet 은 기본적으로 Collection 인터페이스를 상속받기 때문에 제공하는 함수가 매우 비슷하나,
     * Set 은 인덱스를 지원하지 않기 때문에 인덱스 관련 함수는 전부 제외한다고 생각하면 된다.
     * (elementAt, component1, 비구조화, subList, asReversed, addFirst, addLast 등)
     */
    init {
        "user" {
            setOf(1, 2, 3, 4).forEach { println(it) }
        }
    }
}