/**
 * Dresser as a metaphor for a dynamically sized array.
 *
 * @version 20220909.1700
 *
 */

public class DresserBlueprint {


    static final int DEFAULT_DRAWERS = 4;
    static final int DEFAULT_COLUMNS = 1;
    static final String DEFAULT_WOOD = "Pine";
    static final String DEFAULT_COLOR = "Natural Stain";
    // Upgrade factor: multiplier for old dresser size
    public static final int UPGRADE_FACTOR = 2;

    // Number of drawers
    static int totalDrawers;

    // Number of columns
    static int numberOfColumns;

    // Type of wood - private for structured inheritance
    private static String typeOfWood;

    // Color of dresser - private for structured inheritance
    private static String color;

    // Number of drawers used
    static int usedDrawers = 0;

    // The dresser
    static String[] ourDresser;

    /**
     * Default Constructor
     *
     */
    DresserBlueprint() {
        this.totalDrawers = DEFAULT_DRAWERS;
        this.numberOfColumns = DEFAULT_COLUMNS;
        this.typeOfWood = DEFAULT_WOOD;
        this.color = DEFAULT_COLOR;
        this.ourDresser = new String[this.totalDrawers];
    }  // Constructor DresserBlueprint

    /**
     * Custom Constructor
     *
     */
    DresserBlueprint(int x1,
                     int x2,
                     String x3,
                     String x4) {
        totalDrawers = x1;
        numberOfColumns = x2;
        typeOfWood = x3;
        color = x4;
        ourDresser = new String[totalDrawers];
    }  // Constructor DresserBlueprint

    /**
     * Color getter - String
     *
     */
    public static String getColor() {
        return color;
    }  // getter getColor

    /**
     * Number of total drawers getter - int
     *
     */
    public static int getTotalDrawers() {
        return totalDrawers;
    } // getter getTotalDrawers

    /**
     * Type of wood getter - String
     *
     */
    public static String getTypeOfWood() {
        return typeOfWood;
    }  // getter getTypeOfWood

    /**
     * Used drawer count getter - int
     *
     */
    public static int getUsedDrawers() {
        return usedDrawers;
    }

    /**
     * Adds an item to a drawer; each drawer can contain only one kind of items.
     * If there is a previous gap in the drawer it will fill that one first.
     *
     * @param item String with kind of items contained in drawer.
     */
    public static void addToDrawer(String item) {
        // Make sure there is still empty drawers in the dresser
        if (usedDrawers == totalDrawers) {
            // upgrade dresser
            upgradeDresser();
        }
        // checks if there is a gap and adds item in gap first
        boolean nullFinder = false;
        for(int i = 0; i < ourDresser.length-1; i++) {
            if(ourDresser[i] == null && ourDresser[i+1] != null) {
                ourDresser[i] = item;
                System.out.println(ourDresser[i] + " is being inserted in Drawer " + (i+1) + "\n");
                nullFinder = true;
            }
        }
        // add the new item to a drawer if there is no gap
        if(nullFinder == false) {
            ourDresser[usedDrawers] = item;
            System.out.println(ourDresser[usedDrawers] + " is being inserted in Drawer " + (usedDrawers+1) + "\n");
            // increment the count of used drawers
            usedDrawers++;
        }
    }  // method addToDrawer

    /**
     * Resizes the dresser.
     *
     */
    public static void upgradeDresser() {
        // Create a new dresser that is larger than the old dresser
        String[] newDresser = new String[UPGRADE_FACTOR*ourDresser.length];
        totalDrawers = UPGRADE_FACTOR*ourDresser.length;
        // Copy items from old dresser to new dresser
        for (int i = 0; i < ourDresser.length; i++) {
            newDresser[i] = ourDresser[i];
        }
        // Replace current dresser with new dresser
        ourDresser = newDresser;
    }  // method upgradeDresser


    /**
     * Clears the most recently used drawer.
     *
     * Method checks first that there is at least one drawer used.
     *
     */
    public static void clearDrawer() {
        // Make sure that there is at least one drawer used.
        if (usedDrawers > 0) {
            // Empty the contents of the most recently used drawer
            System.out.println(ourDresser[usedDrawers-1] + " is being taken out of Drawer " + (usedDrawers));
            ourDresser[usedDrawers-1] = null;
            System.out.println("");
            // Reduce the number of used drawers
            usedDrawers--;
        }
    }  // method clearDrawer

    /**
     * Removes item from specific drawer.
     *
     * Method finds desired drawer and nullifies it.
     *
     * @param int drawer - Drawer number being emptied
     */
    public static void clearDrawer(int drawer) {
        //Prints update showing the item being taken out and the drawer it's coming from
        System.out.println(ourDresser[drawer] + " is being taken out of Drawer " + (drawer+1));
        //Nullifies the drawer specified
        ourDresser[drawer] = null;
        System.out.println("");
    }  // method clearDrawer


    /**
     * Displays contents of dresser
     */
    public static void showContents() {
        System.out.printf("Your dresser has %d drawers with the following items:\n", totalDrawers);
        for (int i = 0; i < ourDresser.length; i++) {
            System.out.printf("\tDrawer %d: %s\n", i + 1, ourDresser[i]);
        }
        System.out.print("\n");
    }  // method showContents

    /**
     * Displays details of dresser
     */
    public static void showDetails() {
        System.out.println("Your dresser has the following details:"+
                "\n\tTotal Drawers: " + totalDrawers+
                "\n\tTotal Columns: " + numberOfColumns+
                "\n\tType of wood : " + typeOfWood+
                "\n\tColor        : " + color + "\n");
    }

    /**
     * Clears contents of dresser
     */
    public static void clearDresser() {
        for(int i = 0; i < ourDresser.length; i++) {
            ourDresser[i] = null;
        }
    }

    /**
     * Test code
     */
    public static void main(String[] args) {
        addToDrawer("Socks");
        addToDrawer("Tee-shirts");
        addToDrawer("Cufflinks");
        addToDrawer("Bowties");
        addToDrawer("Neckties");
        showContents();
    }  // method main

} // class Dresser