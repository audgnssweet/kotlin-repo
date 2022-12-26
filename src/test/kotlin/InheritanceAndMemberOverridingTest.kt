import io.kotlintest.specs.StringSpec

class InheritanceAndMemberOverridingTest : StringSpec() {
}

open class Father(open val hairColor: String, open val eyeColor: String)

//아래와 같이 정의하는 것은 안되며, 오버라이딩이 필요하다
//class Child(var hairColor: String, var eyeColor: String) : Father(hairColor, eyeColor)

//슈퍼 클래스의 주생성자를 바로 달아줌
//그리고 이런식으로 override 를 하면, 아예 새로운 필드로 취급되기 때문에
//부모 영역의 hairColor 와 eyeColor 에 접근하려면 super 키워드를 통해서 접근해야 한다.
class Child(override val hairColor: String, override val eyeColor: String) : Father(hairColor, eyeColor)

class Child2 : Father {
    override var hairColor: String
        get() = super.hairColor
        set(value: String) {
            field = value
        }

    override var eyeColor: String

    //아래 생성자에서는, 일단 프로퍼티들을 전부 오버라이딩 했기 때문에
    //부모 영역의 프로퍼티와 자식 영역의 프로퍼티를 동시에 초기화한다.
    constructor(hairColor: String, eyeColor: String) : super(hairColor, eyeColor) {
        this.hairColor = hairColor
        this.eyeColor = eyeColor
    }
}

//오버라이딩 하지 않고 주생성자를 사용하는 경우
class Child3(hairColor: String, eyeColor: String, val grade: Int) : Father(hairColor, eyeColor)

class Child4 : Father {
    constructor(hairColor: String, eyeColor: String) : super(hairColor, eyeColor)
}
