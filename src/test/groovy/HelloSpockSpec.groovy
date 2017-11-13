import spock.lang.Specification
import spock.lang.Unroll
import testing.NameRepository
import testing.NameService

class HelloSpockSpec extends Specification {

    def "length of Spock's and his friends' names"() {
        expect:
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
    }

    def "length of Spock's and his friends' names in another way"() {
        expect:
        name.size() == length

        where:
        name << ["Spock", "Kirk", "Scotty"]
        length << [5, 4, 6]
    }

    @Unroll
    def "unrolled length of Spock's and his friends' names"() {
        expect:
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
    }

    def nameRepository = Mock(NameRepository)
    def nameService = new NameService(nameRepository: nameRepository)

    def "test mocking class collaborator"() {
        when:
        def name = nameService.getName()

        then:
        1 * nameRepository.getName() >> "test name"
        name == "test name"

    }

}