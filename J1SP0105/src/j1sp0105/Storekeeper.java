package j1sp0105;

public class Storekeeper {

    private String name;

    public Storekeeper() {
    }

    public Storekeeper(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
