import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.File;


import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import shelter.Shelter;
import shelter.Animal;
import shelter.Dog;
import shelter.DogBreed;
import shelter.Cat;
import shelter.CatBreed;
import shelter.Gender;

public class MainWin extends JFrame {// implements ActionListener {
    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();
        
        JMenu     file       = new JMenu("File");
        JMenuItem Open       = new JMenuItem("Open Shelter");
        JMenuItem Shelter    = new JMenuItem("New Shelter");
        JMenuItem Save       = new JMenuItem("Save");
        JMenuItem SaveAs     = new JMenuItem("Save As");
        JMenuItem quit       = new JMenuItem("Quit");
        JMenu     animal     = new JMenu("Animal");
        JMenuItem newDog     = new JMenuItem("New Dog");
        JMenuItem newCat     = new JMenuItem("New Cat");
        JMenu     help       = new JMenu("Help");
        JMenuItem rules      = new JMenuItem("Rules");
        JMenuItem about      = new JMenuItem("About");
        
        quit    .addActionListener(event -> onQuitClick());
        newDog  .addActionListener(event -> onNewDogClick());
        newCat  .addActionListener(event -> onNewCatClick());
        about   .addActionListener(event -> onAboutClick());
        Save    .addActionListener(event ->  onSaveClick());
            
       
        SaveAs  .addActionListener(event ->  onSaveAsClick());
            
        
        Open    .addActionListener(event -> onOpenShelterClick());
        Shelter .addActionListener(event -> onNewShelterClick());
        

        file  .add(quit);
        animal.add(newDog);
        animal.add(newCat);
        help  .add(about);
        file  .add(Open);
        file  .add(Save);
        file  .add(SaveAs);
        
        menubar.add(file);
        menubar.add(animal);
        menubar.add(help);
        setJMenuBar(menubar);
        
        
        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("MASS Commands");

        // A "horizontal strut" is just a space of the specified pixel width
        // toolbar.add(Box.createHorizontalStrut(25));
        
        // Create the 3 buttons using the icons provided
        JButton buttonNewDog  = new JButton(new ImageIcon("new_dog.png"));
          buttonNewDog.setActionCommand("New dog");
          buttonNewDog.setToolTipText("Add a new dog");
          toolbar.add(buttonNewDog);
          buttonNewDog.addActionListener(event -> onNewDogClick());

        JButton buttonNewCat  = new JButton(new ImageIcon("new_cat.png"));
          buttonNewCat.setActionCommand("New dog");
          buttonNewCat.setToolTipText("Add a new dog");
          toolbar.add(buttonNewCat);
          buttonNewCat.addActionListener(event -> onNewCatClick());

        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        
        
        // /////////////////////////// ////////////////////////////////////////////
        // D A T A   D I S P L A Y
        // Provide a text entry box to show data
        data = new JLabel();
        data.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(data, BorderLayout.CENTER);

        // Just for fun, a cute dog / cat splash image 
        //   (removed on first data, see updateDisplay())
        try {
            data.setHorizontalAlignment(JLabel.CENTER);
            BufferedImage pic = ImageIO.read(new File("cat-and-dog.jpg"));
            ImageIcon icon = new ImageIcon(pic);
            data.setIcon(icon);
        } catch(IOException e) {
        }

        // S T A T U S   B A R   D I S P L A Y //
        msg = new JLabel();
        add(msg, BorderLayout.PAGE_END);

        // Make everything in the JFrame visible
        setVisible(true);
        
        shelter = new Shelter("UTA Animal Friends");
    }
    protected void onSaveAsClick() {
        final JFileChooser fc = new JFileChooser(filename);
        FileFilter massFiles = new FileNameExtensionFilter(NAME + " files", EXT);
        fc.addChoosableFileFilter(massFiles);
        fc.setFileFilter(massFiles);
        
        int result = fc.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fname = fc.getSelectedFile();
            if(!fname.getAbsolutePath().endsWith("." + EXT))
                fname = new File(fname.getAbsolutePath() + "." + EXT);
            filename = fname; 
            onSaveClick();
        }
    }
    protected void onSaveClick() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            bw.write(FLAG + '\n');
            bw.write(FILE_VERSION + '\n');
            shelter.save(bw);
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Unable to save" + filename + '\n'+ e, "Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
    protected void onOpenShelterClick(){
        final JFileChooser fc = new JFileChooser(filename);
        FileFilter massFiles = new FileNameExtensionFilter(NAME + " files", EXT);
        fc.addChoosableFileFilter(massFiles);
        fc.setFileFilter(massFiles);

        int result = fc.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            File fname = fc.getSelectedFile();

            try(BufferedReader br = new BufferedReader(new FileReader(filename))){
                String flag = br.readLine();
                if(!flag.equals(FLAG)){
                    throw new RuntimeException("Not a " + NAME + "file");
                }
                String fileVersion = br.readLine();
                if(!fileVersion.equals(FILE_VERSION)){
                    throw new RuntimeException("Incompatible " + NAME + "file format" + fileVersion);
                }

                Shelter newShelter = new Shelter(br);
                shelter = newShelter;
                filename = fname;
            } catch(Exception e){
                JOptionPane.showMessageDialog(this, "Unable to open "+ filename + "\n" + e, "Failed" , JOptionPane.ERROR_MESSAGE);
            }
            updateDisplay();
        }
    }
    protected void onNewShelterClick(){
        String newshelterName = "Mass";
        if(shelter!=null){
            newshelterName = JOptionPane.showInputDialog(this, "New shelter?");
        }
        if(newshelterName!=null){
            shelter = new Shelter("Mass");
            filename = new File("Untitled.mass");
        }
        updateDisplay();
    }
    
    // Generic animal dialog

    // Listeners
    private JLabel breed = new JLabel("Breed");

    private JLabel name = new JLabel("<HTML><br/>Name</HTML>");
    private JTextField names = new JTextField(20);
        
    private JLabel gender = new JLabel("<HTML><br/>Gender</HTML>");
    private JComboBox genders = new JComboBox(Gender.values());
        
    private JLabel age = new JLabel("<HTML><br/>Age</HTML>");
    private SpinnerModel range = new SpinnerNumberModel(0, 0, 100, 1);
    private JSpinner ages = new JSpinner(range);
        
    protected void onNewDogClick() { 
        JComboBox breeds = new JComboBox(DogBreed.values());
        
        Object[] objects = { // Array of widgets to display
            breed, breeds, name, names, gender, genders, age, ages};
        
        int button = JOptionPane.showConfirmDialog( // Show the dialog
            this,
            objects,
            "New Dog",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.OK_OPTION) 
            shelter.addAnimal(
                new Dog((DogBreed) breeds.getSelectedItem(), names.getText(), 
                        (Gender) genders.getSelectedItem(), (int) ages.getValue()
                )
            );
        updateDisplay();
    }
            
    protected void onNewCatClick() { 
        JComboBox breeds = new JComboBox(CatBreed.values());
        
        Object[] objects = { // Array of widgets to display
            breed, breeds, name, names, gender, genders, age, ages};
        
        int button = JOptionPane.showConfirmDialog( // Show the dialog
            this,
            objects,
            "New Cat",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.OK_OPTION) 
            shelter.addAnimal(
                new Cat((CatBreed) breeds.getSelectedItem(), names.getText(), 
                        (Gender) genders.getSelectedItem(), (int) ages.getValue()
                )
            );
        updateDisplay();
    }
    protected void onAboutClick() {                 // Display About dialog
        JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("Mav's Animal Shelter Software");
        
        try {
            BufferedImage pic = ImageIO.read(new File("doggo.jpg"));
            JLabel logo = new JLabel(new ImageIcon(pic));
            about.add(logo);
        } catch(IOException e) {
        }
        
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.PAGE_AXIS));
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>MASS</font></p>"
          + "</html>");
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        info.add(titlePanel);

        JLabel subtitle = new JLabel("<html>"
          + "<p><font size=+1>Mavs Animal Shelter Software</font></p>"
          + "</html>");
        JPanel subtitlePanel = new JPanel();
        subtitlePanel.add(subtitle);
        info.add(subtitlePanel);

        JLabel artists = new JLabel("<html></br>"
          + "<p>NOTE: Suggested Solution Adopted for the Purposes of P07.</p>"
          + "<p>Version 1.0</p>"
          + "<p>Copyright 2022 by Brendan Sophabmixay</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "<p>Logo by Anna Langova, CC0 Public Domain</p>"
          + "<p><font size=-2>https://www.publicdomainpictures.net/<br/>en/view-image.php?image=24076</font></p>"
          + "<br/>"
          + "<p><a href=\"https://www.flaticon.com/free-icons/dog\" title=\"dog icons\">Dog icons created by Freepik - Flaticon</a></p>"
          + "<p><a href=\"https://www.flaticon.com/free-icons/cat\" title=\"cat icons\">Cat icons created by justicon - Flaticon</a></p>"  
          + "<br/><br/></html>");
        info.add(artists); 

        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        JPanel okPanel = new JPanel();
        okPanel.add(ok);
        info.add(okPanel);
        
        about.add(info);
        
        about.pack();
        about.setVisible(true);
     }
    protected void onQuitClick() {
        System.exit(0);
    }

    // Update the data display in the main window
    private void updateDisplay() {
        
        

        data.setIcon(null);  // remove the splash image if present
        data.setHorizontalAlignment(JLabel.LEFT);
        data.setVerticalAlignment(JLabel.TOP);
        data.setText("<html>" + shelter.toString()
                                       .replaceAll("<","&lt;")
                                       .replaceAll(">", "&gt;")
                                       .replaceAll("\n", "<br/>")
                              + "</html>");
        data.revalidate(); // Not usually required
    }
    protected enum Display{ANIMALS, SHELTER};
    private final String NAME = "MASS";
    private final String EXT = "mass";
    private final String FILE_VERSION = "1.0";
    private final String FLAG = "ʝąɗ玉";
    private Shelter shelter;
    
    private JLabel data;                    // Display of data
    private JLabel msg;                     // Status message display
    private File filename;
}