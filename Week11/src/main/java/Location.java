import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a location in Middle-Earth. Each location has a name and adjacent paths.
 */
public class Location {

    /** Name of the location. */
    private String name;

    /** Adjacent locations reachable from this location. */
    private List<Location> adjacent;

    /**
     * Constructs a Location with a name.
     *
     * @param name Name of the location.
     */
    public Location(final String name) {
        this.name = name;
        this.adjacent = new ArrayList<Location>();
    }

    /**
     * Adds a bidirectional path between this location and another.
     *
     * @param location Location to connect.
     */
    public void addPath(final Location location) {
        if (!adjacent.contains(location)) {
            adjacent.add(location);
            location.addPath(this);
        }
    }

    /**
     * Gets the name of the location.
     *
     * @return name of the location.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of adjacent locations.
     *
     * @return list of adjacent locations.
     */
    public List<Location> getAdjacent() {
        return adjacent;
    }
}
