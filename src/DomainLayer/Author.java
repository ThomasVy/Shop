package DomainLayer;

public class Author {
    private String name;
    private char sex;
    private int age;
    private String location;

    public Author(String name) {
        this.name = name;
    }

    public String getName(){ return name; }
}
