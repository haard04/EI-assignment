
import java.util.HashMap;
import java.util.Map;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
 class Organisation {//creating class which is using type
    private int x;
    private int y;
    private orgType type;

    public Organisation(int x, int y, orgType type) {//constructor
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void create(Graphics g) {
        type.create(g, x, y);
    }
}

 class orgType {//creating type
    private String name;
    private Color color;
    private String otherOrganisationData;

    public orgType(String name, Color color, String otherOrganisationData) {
        this.name = name;
        this.color = color;
        this.otherOrganisationData = otherOrganisationData;
    }

    public void create(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x - 1, y, 3, 5);
        g.setColor(color);
        g.fillOval(x - 5, y - 10, 10, 10);
    }
}

 class OrganisationFactory {
    static Map<String, orgType> orgTypes = new HashMap<>();

    public static orgType getorgType(String name, Color color, String otherOrganisationData) {
        orgType result = orgTypes.get(name);
        if (result == null) {
            result = new orgType(name, color, otherOrganisationData);
            orgTypes.put(name, result);
        }
        return result;
    }
}

 class Market extends JFrame {//GUI
    private List<Organisation> Organisations = new ArrayList<>();

    public void createOrg(int x, int y, String name, Color color, String otherOrganisationData) {
        orgType type = OrganisationFactory.getorgType(name, color, otherOrganisationData);
        Organisation Organisation = new Organisation(x, y, type);
        Organisations.add(Organisation);
    }

    @Override
    public void paint(Graphics graphics) {
        for (Organisation Organisation : Organisations) {
            Organisation.create(graphics);
        }
    }
}

public class Main {
    static int CANVAS_SIZE = 500;
    static int Organisations_TO_CREATE = 1000000;
    static int TREE_TYPES = 2;

    public static void main(String[] args) {
        Market market = new Market();
        for (int i = 0; i < Math.floor(Organisations_TO_CREATE / TREE_TYPES); i++) {
            market.createOrg(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Summer Oak", Color.GREEN, "Oak texture stub");
            market.createOrg(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Autumn Oak", Color.ORANGE, "Autumn Oak texture stub");
        }
        market.setSize(CANVAS_SIZE, CANVAS_SIZE);
        market.setVisible(true);

        System.out.println(Organisations_TO_CREATE + " Organisations Created");
        System.out.println("---------------------");
        System.out.println("Memory usage:");
        System.out.println("Organisation size (8 bytes) * " + Organisations_TO_CREATE);
        System.out.println("+ orgTypes size (~30 bytes) * " + TREE_TYPES + "");
        System.out.println("---------------------");
        System.out.println("Total: " + ((Organisations_TO_CREATE * 8 + TREE_TYPES * 30) / 1024 / 1024) +
                "MB (instead of " + ((Organisations_TO_CREATE * 38) / 1024 / 1024) + "MB)");
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}