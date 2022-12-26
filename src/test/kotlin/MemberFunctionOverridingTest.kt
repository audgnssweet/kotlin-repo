class MemberFunctionOverridingTest {

    open class Father(open var hairColor: String, open var eyeColor: String) {
        open fun changeHairColor(hairColor: String) {
            this.hairColor = hairColor
        }
    }

    class Child: Father {
        override var hairColor: String
        override var eyeColor: String
        var others: String

        constructor(hairColor: String, eyeColor: String, others: String) : super(hairColor, eyeColor) {
            this.hairColor = hairColor
            this.eyeColor = eyeColor
            this.others = others
        }

        override fun changeHairColor(hairColor: String) {
            this.hairColor = hairColor
        }

        fun printHairColor() = println("Child 모발색은 ${this.hairColor} 입니다.")

        fun changeHairColorSuper(hairColor: String) {
            super.hairColor = hairColor
            super.changeHairColor(hairColor)
        }

        fun printHairColorSuper() = println("Father 모발색은 ${super.hairColor} 입니다.")
    }
}

