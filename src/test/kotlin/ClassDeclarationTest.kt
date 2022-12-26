import io.kotlintest.specs.StringSpec

class ClassDeclarationTest : StringSpec() {

    // 생성자를 하나도 정의하지 않으면, 기본 생성자 (중괄호 전에 선언) 을 컴파일러가 자동선언 해줌
    class A

    class B {}

    // 기본 생성자 안에 프로퍼티 선언하면 이름과 타입이 인자와 동일한 속성을 자동으로 생성하고 초기화 해준다
    class Person(val name: String, val phone: String)

    // 기본 생성자에 접근 제한자 넣으려면 constructor 선언 필요
    class Friend private constructor(val name: String, val phone: String)

    //이런식으로 따로 선언하는 것도 가능
    class Friend2(name: String, tel: String) {
        val name: String = name
        val tel: String = tel
    }

    //초기화 블럭을 통해서 초기화도 가능. 주생성자만 있을 때 특별한 로직이 들어가기 좋음
    class Friend3(name: String, tel: String) {
        val name: String
        val tel: String

        init {
            this.name = name
            this.tel = if (tel == "0000") "1234" else tel
        }
    }

    //주 생성자 없이 보조 생성자만으로 구성하는 것도 가능
    class Friend4 {
        //필드에도 기본값 지정 가능. 대신에 val 이라면 생성자를 통한 값 주입은 받을 수 없다.
        var name: String = ""
        val tel: String

        //생성자에 기본값 지정 가능
        constructor(name: String, tel: String = "") {
            this.name = name
            this.tel = tel
        }

        constructor(name: String) {
            this.name = name
            this.tel = ""
        }
    }

    //주 생성자와 보조 생성자를 함께 구성하는 것도 가능
    class Friend5(val name: String, val tel: String = "") {

        //대신 주생성자를 반드시 호출해야 한다.
        constructor(c_name: String) : this(c_name, "")
    }
}