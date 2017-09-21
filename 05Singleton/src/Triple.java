public class Triple {

    private static Triple[] triples = new Triple[]{
            new Triple(0),
            new Triple(1),
            new Triple(2)
    };

    int id;

    private Triple(int id) {
        this.id = id;
    }

    public static Triple getInstance(int id){
        return triples[id];
    }

    @Override
    public String toString() {
        return "[Triple id= " + id + "]";
    }

}
