import io.kotlintest.specs.StringSpec

class LetFunctionTest : StringSpec() {

    init {
        fun getUserID(): String? = "user01"
        fun sendNotification(userID: String) {
            println("$userID 에게 알림을 보냅니다")
        }

        /**
         * let 은 전달된 람다식이나 함수를 실행하고 그 결과를 return 해주는 inline 함수이다
         * (inline 이란 let 자리가 함수로 직접 대체된 채로 바이트코드가 생성되는 것을 의미한다 - 크기는 좀 커져도 성능은 향상됨)
         *
         * let 함수 왼쪽의 것과 무관한 함수를 호출할 때 사용하는 것이다.
         * 직접 참조로 호출할 수 없는 함수들
         */
        "사용해보기" {
            val userID: String? = getUserID()

//            sendNotification(userID) //컴파일 에러

            if (userID != null) sendNotification(userID)

            userID?.let { userID -> sendNotification(userID) }

            userID?.let { sendNotification(it) }

            userID?.let {
                println("$userID 님께 메시지를 보냈습니다.")
                println("$it 님께 메시지를 보냈습니다.")
            }
        }
    }
}