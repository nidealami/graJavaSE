public enum Direction {
    N("polnoc"), S("poludnie"), W("zachod"), E("wschod");


    private String directionDescription;

    Direction(String directionDescription) {
        this.directionDescription = directionDescription;
    }

    public String getDirectionDescription() {
        return directionDescription;
    }
}
