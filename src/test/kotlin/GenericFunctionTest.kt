import io.kotlintest.specs.StringSpec

class GenericFunctionTest : StringSpec() {

    /**
     * 제네릭은 일반화.
     * 코드의 중복 제거.
     *
     * 컬렉션과 같은 저장소에 저장하는 자료형을 컴파일 시점에 알 수 있어서, 에러 사전에 방지 가능
     *
     * 코드가 컴파일될 때 사용하는 쪽에서 T 가 해당타입으로 교체된다.
     */
    fun <T> newList(vararg ts: T): ArrayList<T> {
        val result = ArrayList<T>()
        for (t in ts) {
            result.add(t)
        }
        return result
    }
}