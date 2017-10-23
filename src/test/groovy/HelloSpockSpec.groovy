import testing.Test

class HelloSpockSpec extends spock.lang.Specification {

    def tester = Mock(Test)

    def "length of Spock's and his friends' names"() {
        expect:
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
    }

    def "test must return true"() {
        when:
        def result = tester.execute()

        then:
        1 * tester.execute() >> true
        result == true

    }

}