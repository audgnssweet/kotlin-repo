import io.kotlintest.specs.StringSpec

class CustomGetterSetterTest : StringSpec() {

    class Person {

        /**
         * field - backing field
         * custom getter 혹은 setter 에서
         * 재귀호출 문제를 방지할 수 있도록 해줌
         *
         * 프로퍼티가 아니라 값을 나타낸다
         */
        var name: String = ""
            get() {
                println("이름은 $field 입니다")
                return field
            }
            set(value) {
                println("setter 호출")
                field = value
            }

        constructor(name: String) {
            this.name = name
        }
    }

    init {
        "custom getter setter 사용하기" {
            val person = Person("jeong")

            println("이름은 ${person.name} 입니다")

            person.name = "kim"

            println("이름은 ${person.name} 입니다")
        }
    }
}
