import io.kotlintest.specs.StringSpec

class InvokeOperatorTest : StringSpec() {

    class InvokeOperator(val message: String) {
        operator fun invoke(message: String) {
            println("hi im instance!! my message = ${this.message} and message = $message")
        }
    }

    init {

        "인스턴스 대상으로 invoke 호출" {
            val invokeOperator = InvokeOperator("message1")

            invokeOperator("message2")
        }

    }
}