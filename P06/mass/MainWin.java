import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

public class MainWin extends JFrame {

    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setSize(width, height);

        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu animal = new JMenu("Animal");
        JMenu help = new JMenu("Help");
        JMenuItem quit = new JMenuItem("Quit");
        JMenuItem addDog = new JMenuItem("New Dog");
        JMenuItem addCat = new JMenuItem("New Cat");
        JMenuItem about = new JMenuItem("About");

        addDog.addActionListener(event -> onNewDogClick());
        addCat.addActionListener(event -> onNewCatClick());
        quit.addActionListener(event -> onQuitClick());
        about.addActionListener(event -> onAboutClick());

        file.add(quit);
        animal.add(addDog);
        animal.add(addCat);
        help.add(about);

        menubar.add(file);
        menubar.add(animal);
        menubar.add(help);

        setJMenuBar(menubar);
        setVisible(true);

    }

    public void onNewCatClick() {
        JLabel cat = new JLabel("Cat");
        String[] catOptions = { "BENGAL", "SIAMESE", "MUNCHKIN" };
        breeds = new JComboBox<String>(catOptions);
        breeds.setEditable(true);
        // Name of animal
        JLabel name = new JLabel("<HTML><br/>Name</HTML>");
        names = new JTextField(20);

        // Gender of animal
        JLabel gender = new JLabel("<HTML><br/>Gender</HTML>");

        String[] gender_text = { "Male", "Female" };
        genders = new JComboBox<String>(gender_text);
        // Age of animal
        JLabel age = new JLabel("<HTML><br/>Age</HTML>");

        SpinnerModel range = new SpinnerNumberModel(0, 0, 100, 1);
        ages = new JSpinner(range);
        Object[] objects = { // Array of widgets to display
                cat, breeds,
                name, names,
                gender, genders,
                age, ages };
        int button = JOptionPane.showConfirmDialog( // Show the dialog
                this,
                objects,
                "New Animal",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (button == JOptionPane.OK_OPTION) // Show data
            JOptionPane.showMessageDialog(
                    this,
                    names.getText() + " ("
                            + genders.getSelectedItem() + " "
                            + breeds.getSelectedItem()
                            + " age " + ages.getValue() + ")");
    }

    public void onNewDogClick() {
        {
            JLabel dog = new JLabel("Dog");
            String[] dogOptions = { "CORGI", "Husky", "SIBERIAN" };
            breeds = new JComboBox<String>(dogOptions);
            breeds.setEditable(true);
            // Name of animal
            JLabel name = new JLabel("<HTML><br/>Name</HTML>");
            names = new JTextField(20);

            // Gender of animal
            JLabel gender = new JLabel("<HTML><br/>Gender</HTML>");

            String[] gender_text = { "Male", "Female" };
            genders = new JComboBox<String>(gender_text);
            // Age of animal
            JLabel age = new JLabel("<HTML><br/>Age</HTML>");

            SpinnerModel range = new SpinnerNumberModel(0, 0, 100, 1);
            ages = new JSpinner(range);
            Object[] objects = { // Array of widgets to display
                    dog, breeds,
                    name, names,
                    gender, genders,
                    age, ages };
            int button = JOptionPane.showConfirmDialog( // Show the dialog
                    this,
                    objects,
                    "New Animal",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (button == JOptionPane.OK_OPTION) // Show data
                JOptionPane.showMessageDialog(
                        this,
                        names.getText() + " ("
                                + genders.getSelectedItem() + " "
                                + breeds.getSelectedItem()
                                + " age " + ages.getValue() + ")");
        }
    }

    public void onQuitClick() {
        System.exit(1);
    }

    public void onAboutClick() {
        JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("Mavs Animal Shelter Software");
        try {
            BufferedImage myPicture = ImageIO.read(new File("CuteDog.jpeg"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            about.add(logo);
        } catch (IOException e) {
            // ignore if no logo
        }
        JLabel title = new JLabel("<html>"
                + "<p><font size +=4>Mass</font></p>"
                + "</html>");
        about.add(title);
        JLabel cr = new JLabel("<html>"
                + "<p>Version 1.0</p>"
                + "<p>Copyright 2022 by Brendan Sophabmixay</p>"
                + "<p>Licensed under GNU GPL 3.0</p>"
                + "<p>Logo by Kristesoro, CC0 Public Domain </p>"
                + "<p>https://www.shutterstock.com/image-photo/bernese-mountain-dog-taking-journey-on-1962819784</p>");
        about.add(cr);
        about.setSize(450, 400);
        about.setVisible(true);
    }

    private JComboBox breeds; // Types of animals
    private JTextField names; // Name of new animal
    private JComboBox genders; // Gender of new animal
    private JSpinner ages; // Age of new animal // Types of animals

    private final static int width = 450;
    private final static int height = 115;
}