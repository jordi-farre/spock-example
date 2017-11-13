package testing;

public class NameService {

    private NameRepository nameRepository;

    public String getName() {
        return this.nameRepository.getName();
    }

}
