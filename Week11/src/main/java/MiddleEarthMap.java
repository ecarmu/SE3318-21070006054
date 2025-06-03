import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

/**
 * Class representing the map of Middle-Earth with predefined locations and navigation.
 */
public class MiddleEarthMap {

    /** Map of location names to Location objects. */
    private Map<String, Location> locations;

    /**
     * Constructs the Middle-Earth map and initializes locations and paths.
     */
    public MiddleEarthMap() {
        locations = new HashMap<String, Location>();
        initializeLocations();
        initializePaths();
    }

    /**
     * Initializes locations like Shire, Mordor, Rivendell.
     */
    private void initializeLocations() {
        locations.put("Shire", new Location("Shire"));
        locations.put("Mordor", new Location("Mordor"));
        locations.put("Rivendell", new Location("Rivendell"));
        locations.put("Moria", new Location("Moria"));
        locations.put("Lothlorien", new Location("Lothlorien"));
    }

    /**
     * Initializes paths between locations.
     */
    private void initializePaths() {
        getLocation("Shire").addPath(getLocation("Rivendell"));
        getLocation("Rivendell").addPath(getLocation("Moria"));
        getLocation("Moria").addPath(getLocation("Lothlorien"));
        getLocation("Lothlorien").addPath(getLocation("Mordor"));
        // Secret passage from Shire to Moria
        getLocation("Shire").addPath(getLocation("Moria"));
    }

    /**
     * Gets a Location by name.
     *
     * @param name Name of the location.
     * @return Location object or null if not found.
     */
    public Location getLocation(final String name) {
        return locations.get(name);
    }

    /**
     * Checks if there is a path between two locations.
     *
     * @param from Name of starting location.
     * @param to   Name of destination location.
     * @return true if reachable, false otherwise.
     */
    public boolean canNavigate(final String from, final String to) {
        Location start = getLocation(from);
        Location end = getLocation(to);
        if (start == null || end == null) {
            return false;
        }
        // Simple BFS
        Queue<Location> queue = new LinkedList<Location>();
        Set<Location> visited = new HashSet<Location>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            Location current = queue.poll();
            if (current.equals(end)) {
                return true;
            }
            for (Location neighbor : current.getAdjacent()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}
