package P10;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileNameExtensionFilter;

import P10.shelter.Cat;
import P10.shelter.CatBreed;
import P10.shelter.Client;
import P10.shelter.Dog;
import P10.shelter.DogBreed;
import P10.shelter.Gender;
import P10.shelter.Shelter;
import P10.shelter.Turtle;
import P10.shelter.TurtleBreed;



public class MainWin extends JFrame{
    private void setBorder(JComponent component){
        component.setBorder(BorderFactory.createEmptyBorder());
    }
    private enum DisplayView{ANIMALS, CLIENTS};

    public MainWin(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);

        JMenuBar    menubar = new JMenuBar();

        JMenu       file     = new JMenu("File");
        JMenuItem   anew     = new JMenuItem("New");
        JMenuItem   open     = new JMenuItem("Open");
        JMenuItem   save     = new JMenuItem("Save");
        JMenuItem   saveAs   = new JMenuItem("Save As");
        JMenu       client   = new JMenu("Client");
        JMenuItem   newClient= new JMenuItem("New Client");
        JMenuItem   lstClient= new JMenuItem("List Clients");
        JMenuItem   quit     = new JMenuItem("Quit");
        JMenu       animal   = new JMenu("Animal");
        JMenuItem   newDog   = new JMenuItem("New Dog"); 
        JMenuItem   newCat   = new JMenuItem("New Cat");
        JMenuItem   newTurtle= new JMenuItem("New Turtle");
        JMenu       help     = new JMenu("Help");
        JMenuItem   rules    = new JMenuItem("Rules");
        JMenuItem   about    = new JMenuItem("About");

        anew.addActionListener(event -> onNewShelterAsClick());
        lstClient.addActionListener(event -> updateDisplay(DisplayView.CLIENTS));
        newClient.addActionListener(event -> onNewClientClick());
        open.addActionListener(event -> onOpenShelterClick());
        save.addActionListener(event -> onSaveShelterClick());
        saveAs.addActionListener(event -> onSaveShelterAsClick());
        quit.addActionListener(event -> onQuitClick());
        newDog.addActionListener(event -> onNewDogClick());
        newCat.addActionListener(event -> onNewCatClick());
        newTurtle.addActionListener(event -> onNewTurtleClick());
        about.addActionListener(event -> onAboutClick());

        file.add(anew);
        file.add(open);
        file.add(save);
        file.add(saveAs);
        file.add(quit);

        animal.add(newDog);
        animal.add(newCat);
        animal.add(newTurtle);

        help  .add(about);
        help  .add(rules);

        client.add(newClient);
        client.add(lstClient);

        menubar.add(file);
        menubar.add(animal);
        menubar.add(help);
        menubar.add(client);
        setJMenuBar(menubar);
    
        //PAGE_START toolbar
        JToolBar toolbar = new JToolBar("Mass Commands");
        
        //Shelter Icon
        JButton anewB = new JButton(new ImageIcon("P10/resources/new.png"));
        anewB.setActionCommand("New shelter");
        anewB.setToolTipText(("Create a new shelter, discarding any unsaved changes"));
        setBorder(anewB);
        toolbar.add(anewB);
        anewB.addActionListener(event -> onNewShelterAsClick());
        toolbar.add(Box.createHorizontalStrut(4));

        //Open shelter Icon
        JButton openB = new JButton(new ImageIcon("P10/resources/open.png"));
        openB.setActionCommand("Open shelter");
        openB.setToolTipText(("Open an existing shelter"));
        setBorder(openB);
        toolbar.add(openB);
        openB.addActionListener(event -> onOpenShelterClick());

        //Save shelter Icon
        JButton saveB = new JButton(new ImageIcon("P10/resources/save.png"));
        saveB.setActionCommand("Save shelter");
        saveB.setToolTipText(("Save the current shelter"));
        setBorder(saveB);
        toolbar.add(saveB);
        saveB.addActionListener(event -> onSaveShelterClick());

        toolbar.add(Box.createHorizontalStrut(4));

        //SaveAs shelter Icon
        JButton saveAsB = new JButton(new ImageIcon("P10/resources/saveas.png"));
        saveAsB.setActionCommand("SaveAs shelter");
        saveAsB.setToolTipText(("Save the current shelter as a new file"));
        setBorder(saveAsB);
        toolbar.add(saveAsB);
        saveAsB.addActionListener(event -> onSaveShelterAsClick());
        toolbar.add(Box.createHorizontalStrut(4));

        //Create the 3 buttons above
        JButton newDogB = new JButton(new ImageIcon("P10/resources/dog.png"));
        newDogB.setActionCommand("New Dog");
        newDogB.setToolTipText(("Create a new dog"));
        setBorder(newDogB);
        toolbar.add(newDogB);
        newDogB.addActionListener(event -> onNewDogClick());
        toolbar.add(Box.createHorizontalStrut(4));

        JButton newCatB = new JButton(new ImageIcon("P10/resources/cat.png"));
        newCatB.setActionCommand("New Cat");
        newCatB.setToolTipText(("Create a new cat"));
        setBorder(newCatB);
        toolbar.add(newCatB);
        newCatB.addActionListener(event -> onNewCatClick());
        toolbar.add(Box.createHorizontalStrut(4));

        JButton newClientB = new JButton(new ImageIcon("P10/resources/client.png"));
        newClientB.setActionCommand("New Client");
        newClientB.setToolTipText(("Create a new client"));
        setBorder(newClientB);
        toolbar.add(newClientB);
        newClientB.addActionListener(event -> onNewClientClick());
        toolbar.add(Box.createHorizontalStrut(4));

        JButton lstClientB = new JButton(new ImageIcon("P10/resources/clientList.png"));
        lstClientB.setActionCommand("List Clients");
        lstClientB.setToolTipText(("List all clients"));
        setBorder(lstClientB);
        toolbar.add(lstClientB);
        lstClientB.addActionListener(event -> updateDisplay(DisplayView.CLIENTS));
        toolbar.add(Box.createHorizontalStrut(4));

        getContentPane().add(toolbar, BorderLayout.PAGE_START);

        //Data manipulation
        //Provide a text entry box to display data
        data = new JLabel();
        data.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(data, BorderLayout.CENTER);

        //status Bar display
        msg = new JLabel();
        add(msg, BorderLayout.PAGE_END);

        //makes jframe visible
        setVisible(true);

        onNewShelterClick("MAVS Animal Shelter");

        
    }
        //Event listeners
        
       

        public void onNewShelterClick(String name){
            shelter = new Shelter(name);
            shelter.setFilename("untitled.mass");
            updateDisplay(DisplayView.ANIMALS);
        }

        public void onNewShelterAsClick(){
            String name = JOptionPane.showInputDialog(this,
            "Enter a name for the new shelter",
              "Shelter Name",
                     JOptionPane.QUESTION_MESSAGE);
            if(name != null & name.length() > 0){

                onNewShelterClick(name);
                setTitle("MASS - " + name);
            }
        }

        public void onOpenShelterClick(){
            File filename = new File(shelter.getFilename());
            final JFileChooser fc = new JFileChooser(filename);
            FileNameExtensionFilter massFiles = new FileNameExtensionFilter("MASS files", "mass");
            fc.addChoosableFileFilter(massFiles);
            fc.setFileFilter(massFiles);

            int result = fc.showOpenDialog(this);

            if(result == JFileChooser.APPROVE_OPTION){
                filename = fc.getSelectedFile();

                try(BufferedReader br = new BufferedReader(new FileReader(filename))){
                    shelter = new Shelter(br);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,
                    "Error opening file",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                }
                updateDisplay(DisplayView.ANIMALS);
            }
            
        }

        public void onSaveShelterClick(){
            try(BufferedWriter bw = new BufferedWriter(new BufferedWriter(new FileWriter(new File(shelter.getFilename()))))){
                shelter.save(bw);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,
            "Error saving file",
            "Error",
            JOptionPane.ERROR_MESSAGE);
        }
        }
        public void onSaveShelterAsClick(){
            File filename = new File(shelter.getFilename());
            final JFileChooser fc = new JFileChooser(filename);
            FileNameExtensionFilter massFiles = new FileNameExtensionFilter("MASS files", "mass");
            fc.addChoosableFileFilter(massFiles);
            fc.setFileFilter(massFiles);

            int result = fc.showSaveDialog(this);
            if(result == JFileChooser.APPROVE_OPTION){
                filename = fc.getSelectedFile();
                if(!filename.getName().endsWith(".mass")){
                    filename = new File(filename.getAbsolutePath() + ".mass");
                }
                shelter.setFilename(filename.getAbsolutePath());
                onSaveShelterClick();
            }
        } 
        //generic animal dialong

        //Listeners

        private JLabel breed = new JLabel("Breed");

        private JLabel     name = new JLabel("Name");
        private JTextField names = new JTextField(20);
        private JLabel     age = new JLabel("<HTML><br/>Age</HTML>");
        
        private JLabel     gender = new JLabel("<HTML><br/>Gender</HTML>");
        private JComboBox  genders = new JComboBox(Gender.values());

        private SpinnerModel range = new SpinnerNumberModel(0, 0, 100 ,1);
        private JSpinner   ages = new JSpinner(range);

        protected void onNewClientClick(){
            //Client name
            JLabel cName = new JLabel("Name");
            JTextField cNames = new JTextField(20);

            //Client number
            JLabel cNumber = new JLabel(
            "<HTML><BR/>Phone  <SMALL>(Example: 123-456-7890)</SMALL></HTML>");
            JTextField cNumbers = new JTextField(20);
        
            Object[] objects = {cName, cNames, cNumber, cNumbers};

            final Pattern phoneFormat = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
            
            try{
                int button = JOptionPane.showConfirmDialog(this, objects, "New Client", JOptionPane.OK_CANCEL_OPTION
                , JOptionPane.QUESTION_MESSAGE);
            
                if(button == JOptionPane.OK_OPTION){
                    String name = cNames.getText();
                    String number = cNumbers.getText();
                    if(!phoneFormat.matcher(number).find()){
                        JOptionPane.showMessageDialog(this,
                        "Invalid phone number",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                        
                    }
                    else{
                        shelter.addClient(new Client(name, number));
                        updateDisplay(DisplayView.CLIENTS);
                    }   
                    
                }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,
                    "Error adding client",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                }
        }

        protected void onNewDogClick(){
            JComboBox breeds = new JComboBox<>(DogBreed.values());
            Object[] objects = {breed, breeds, name, names, gender, genders, age, ages};
            
            int button = JOptionPane.showConfirmDialog(this, objects, "New Dog", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(button ==JOptionPane.OK_CANCEL_OPTION){
                shelter.addAnimal(
                    new Dog((DogBreed) breeds.getSelectedItem(), names.getText(),(Gender) genders.getSelectedItem(),(int) ages.getValue()));
            }
                updateDisplay(DisplayView.ANIMALS);
            
        }
        protected void onNewTurtleClick(){
            JComboBox breeds = new JComboBox<>(TurtleBreed.values());
            Object[] objects = {breed, breeds, name, names, gender, genders, age, ages};

            int button = JOptionPane.showConfirmDialog(this, objects, "New Turtle", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(button==JOptionPane.OK_OPTION){
                shelter.addAnimal(
                    new Turtle((TurtleBreed) breeds.getSelectedItem(),names.getText(),(Gender) genders.getSelectedItem(),(int) ages.getValue()));


            }
            updateDisplay(DisplayView.ANIMALS);
        }
        protected void onNewCatClick(){
            JComboBox breeds = new JComboBox<>(CatBreed.values());
            Object[] objects = {breed, breeds, name, names, gender, genders, age, ages};

            int button = JOptionPane.showConfirmDialog(this, objects, "New Cat", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(button == JOptionPane.OK_OPTION){
                shelter.addAnimal(
                    new Cat((CatBreed) breeds.getSelectedItem(), names.getText(),(Gender) genders.getSelectedItem(),(int) ages.getValue()));
            }
            updateDisplay(DisplayView.ANIMALS);
        }

        protected void onAboutClick(){
            JDialog about = new JDialog();
            about.setLayout(new FlowLayout());
            about.setTitle("Mavs Animal Shelter Software");

            try{
                BufferedImage pic = ImageIO.read(new File("resources/about.png"));
                JLabel logo  = new JLabel(new ImageIcon(pic));
                about.add(logo);
            } catch(IOException e){}
            
            JPanel info = new JPanel();
            info.setLayout(new BoxLayout(info, BoxLayout.PAGE_AXIS));
            
            JLabel title = new JLabel(
                "<HTML>" + "<p><font size =+4>Mavs Animal Shelter Software</font></p>" + "</HTML>"
            );
            JPanel titlePanel = new JPanel();
            titlePanel.add(title);
            info.add(titlePanel);

            JLabel subtitle = new JLabel("<HTML>" + "<p><font size =+2>Mavs Animal Shelter Software</font></p>" + "</HTML>");
            JPanel subtitlePanel = new JPanel();
            subtitlePanel.add(subtitle);
            info.add(subtitlePanel);

            JLabel artists = new JLabel(
                "<HTML>" + "<p><font size =+1>Version 1.0</font></p>" 
                + "<p><font size =+1>Copyright 2022 by Brendan Sophabmixay:</font></p>"
                +"<p><font size =+1> Licensed under GNU GPL 3.0</font></p>"
                +"<p>Logo by Anna Langova, CC0 Public Domain</p>"
                + "<p><font size=-2>https://www.publicdomainpictures.net/<br/>en/view-image.php?image=24076</font></p>"
                + "<br/>"
                + "<p><a href=\"https://www.flaticon.com/free-icons/dog\" title=\"dog icons\">Dog icons created by Freepik - Flaticon</a></p>"
                + "<p><a href=\"https://www.flaticon.com/free-icons/cat\" title=\"cat icons\">Cat icons created by justicon - Flaticon</a></p>" 
                +"<p><font size =+1> NOTE:Code largely Adopted from Suggested Sprint</font></p>"
                +"<p><font size =+1> 3 Solution to facilitate smoother workflow on P10.</font></p>"
                +"</HTML>"
            );
            info.add(artists);

            JButton ok = new JButton("OK");
            ok.addActionListener( event->about.setVisible(false));
            JPanel okPanel = new JPanel();
            okPanel.add(ok);
            info.add(okPanel);

            about.add(info);
            about.pack();
            about.setVisible(true);

        }

        protected void onQuitClick(){
            System.exit(0);
        }
        private void updateDisplay(DisplayView displayView){
            data.setIcon(null);
            data.setHorizontalAlignment(JLabel.LEFT);
            data.setVerticalAlignment(JLabel.TOP);
            String s = "Invalid Display" + displayView;
            if(displayView == displayView.ANIMALS) s = shelter.toString();
            if(displayView == displayView.CLIENTS) s = shelter.clientToString();

            data.setText("<html>"+shelter.toString()
            .replaceAll("<", "&lt;")
            .replaceAll(">", "&gt;")
            .replaceAll("\n", "<br>")+"</html>");
            data.revalidate();
        }
    
        private Shelter shelter;
        private JLabel data;
        private JLabel msg;
}
