public class Location {
    private String longDescription;
    private String shortDescription;

    public Location(String shortDescription, String longDescription) {
        this.longDescription = longDescription;
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return this.shortDescription + "\n" + this.longDescription;
    }
}
