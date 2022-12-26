import io.kotlintest.specs.StringSpec

class PropertyAndFieldTest : StringSpec() {

    init {
        "" {
            //지역변수로 선언된 것들은 필드 자체 접근임을 잊지 말자
            val a = 100
        }
    }
}

//최상위 수준에 선언했기 때문에, 필드가 아닌 프로퍼티로 선언된다.
//프로퍼티 = 필드 + getter, setter
//프로퍼티는 반드시 getter 와 setter 를 통해서 접근된다.
//비록 . 을 통해서 호출할지라도...
//그래서 기본적으로 접근 제한자가 private 로 선언됨에 유의하자
var pro1 = 100
val pro2 = 200

//클래스 멤버 변수들은 필드가 아닌 프로퍼티로 선언된다.
class MyFriend(var name: String, var tel: String, var type: Int) {
    init {
        this.type = if (type < 4) type else 4
    }
}