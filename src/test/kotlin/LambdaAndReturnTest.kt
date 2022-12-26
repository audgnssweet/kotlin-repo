import io.kotlintest.specs.StringSpec

/**
 * 람다식에서는 기본적으로 return 을 사용할 수 없음. 마지막 문장이 람다식의 return 이기 때문에
 * 하지만 람다식을 인자로 받는 고차함수가 inline function 인 경우에는 가능하다.
 */
class LambdaAndReturnTest : StringSpec() {

    data class Friend(val name: String, val age: Int, val tel: String)

    init {
        "일반 for 문" {
            /**
             * 여기서는 홍씨를 찾으면 바로 return
             * 홍씨 찾기가 종료됨이 실행 X
             */
            fun findHong(fList: List<Friend>) {
                for (friend in fList) {
                    if (friend.name.substring(0, 1) == "홍") {
                        println("홍씨를 찾았음")
                        return
                    }
                }
                println("홍씨 찾기가 종료됨")
            }
        }

        "일반 forEach" {
            /**
             * forEach 는 inline 고차 function 이기 때문에, return 문 사용이 가능하다.
             * 하지만 마찬가지로 바로 종료되어
             * 박씨 찾기가 종료됨이 출력되지 않는다.
             */
            fun findPark(fList: List<Friend>) {
                fList.forEach {
                    if (it.name.substring(0, 1) == "박") {
                        println("박씨를 찾았음")
                        return
                    }
                }
                println("박씨 찾기가 종료됨")
            }
        }

        "inline 에서 바로 종료시키지 않는 방법" {
            fun findPark(fList: List<Friend>) {
                fList.forEach {
                    if (it.name.substring(0, 1) == "박") {
                        println("박씨를 찾았음")
                        return@forEach //for each 만 탈출한다.
                    }
                }
                println("박씨 찾기가 종료됨")
            }
        }
    }

}