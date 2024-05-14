import java.awt.*;
import java.awt.event.*;

//1st step  
public class Main implements ActionListener {

    public static DistanceRunner d = new DistanceRunner();
    public static Athlete a = new Athlete();
    public static Sprinter s = new Sprinter();
    public static Frame f3 = new Frame("Workout Schedule");
    public static Label l4 = new Label();
    public static Label l5 = new Label();
    public static Label l6 = new Label();
    public static Label l7 = new Label();
    public static Label l8 = new Label();
    public static Label l11 = new Label();

    public static void work() {
        if (Information.getType() == 0) {
            s.setIntensity(Information.getIntensity());
            s.createSchedule();
            l4.setText(s.days[0]);
            l4.setBounds(75, 50, 275, 25);
            
            l5.setText(s.days[1]);
            l5.setBounds(75, 75, 275, 25);
            
            l6.setText(s.days[2]);
            l6.setBounds(75, 100, 275, 25);
            
            l7.setText(s.days[3]);
            l7.setBounds(75, 125, 275, 25);
            
            l8.setText(s.days[4]);
            l8.setBounds(75, 150, 275, 25);

            l11.setText("Cooldown: " + s.cooldown);
            l11.setBounds(75, 175, 300, 25);
        } else if (Information.getType() == 1) {
            d.setIntensity(Information.getIntensity());
            d.createSchedule();
            l4.setText(d.days[0]);
            l4.setBounds(50, 50, 300, 25);
            
            l5.setText(d.days[1]);
            l5.setBounds(50, 75, 300, 25);
            
            l6.setText(d.days[2]);
            l6.setBounds(50, 100, 325, 25);
            
            l7.setText(d.days[3]);
            l7.setBounds(50, 125, 300, 25);
            
            l8.setText(d.days[4]);
            l8.setBounds(50, 150, 300, 25);

            l11.setText("Cooldown: " + d.cooldown);
            l11.setBounds(50, 175, 300, 25);
        } else if (Information.getType() == 2) {
            a.setIntensity(Information.getIntensity());
            a.createSchedule();
            l4.setText(a.days[0]);
            l4.setBounds(75, 50, 275, 25);
            
            l5.setText(a.days[1]);
            l5.setBounds(75, 75, 275, 25);
            
            l6.setText(a.days[2]);
            l6.setBounds(75, 100, 275, 25);
            
            l7.setText(a.days[3]);
            l7.setBounds(75, 125, 275, 25);
            
            l8.setText(a.days[4]);
            l8.setBounds(75, 150, 275, 25);

            l11.setText("Cooldown: " + a.cooldown);
            l11.setBounds(75, 175, 300, 25);
        }
        f3.add(l4);
        f3.add(l5);
        f3.add(l6);
        f3.add(l7);
        f3.add(l8);
        f3.add(l11);
    }
    
    public static void main(String[] args) {
        //Frame 1 setup
        Frame f1 = new Frame("Home");

        // Text for the user to read
        Label l1 = new Label("Are you a sprinter, distance runner");
        l1.setBounds(100, 75, 275, 25);
        f1.add(l1);
        Label l2 = new Label("or athlete of another sport?");
        l2.setBounds(125, 100, 275, 25);
        f1.add(l2);

        Button b1 = new Button("Sprinter");
        b1.setBounds(15, 150, 125, 50);
        b1.setActionCommand("Sprinter");
        f1.add(b1);

        Button b2 = new Button("Distance Runner");
        b2.setBounds(140, 150, 125, 50);
        b2.setActionCommand("Distance Runner");
        //b2.addActionListener(new Main());
        f1.add(b2);

        // Button 3 created
        // Cancel button
        Button b3 = new Button("Athlete");
        b3.setBounds(265, 150, 125, 50);
        b3.setActionCommand("Athlete");
        //b3.addActionListener(new Main());
        f1.add(b3);

        f1.setSize(400, 400);
        f1.setLayout(null);
        f1.setVisible(true);

        // Frame 2 Setup
        Frame f2 = new Frame("Intensity Slider");
        f2.setSize(400, 400);
        f2.setLayout(null);

        Button b4 = new Button("Light");
        b4.setBounds(15, 150, 125, 50);
        b4.setActionCommand("Light");
        b4.addActionListener(new Main());
        f2.add(b4);

        Button b5 = new Button("Medium");
        b5.setBounds(140, 150, 125, 50);
        b5.setActionCommand("Light");
        b5.addActionListener(new Main());
        f2.add(b5);

        Button b6 = new Button("Hard");
        b6.setBounds(265, 150, 125, 50);
        b6.setActionCommand("Light");
        b6.addActionListener(new Main());
        f2.add(b6);
        
        Label l9 = new Label("   Choose the level of");
        l9.setBounds(125, 50, 275, 25);
        f2.add(l9);

        Label l10 = new Label("intensity for your workout.");
        l10.setBounds(125, 75, 275, 25);
        f2.add(l10);

        //Frame 3 setup
        f3.setSize(400, 400);
        f3.setLayout(null);

        Button b7 = new Button("Return Home");
        b7.setBounds(125, 225, 150, 50);
        b7.setActionCommand("Home");
        b7.addActionListener(new Main());
        f3.add(b7);

        Label l3 = new Label("Here is your workout schedule:");
        l3.setBounds(75, 25, 275, 25);
        f3.add(l3);
        
        //Actions setup
        b1.addActionListener(new Main() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Information.setType(0);
                System.out.println("Sprinter");
                f2.setVisible(true);
                f1.setVisible(false);
            }
        });
        b2.addActionListener(new Main() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Information.setType(1);
                System.out.println("Distance Runner");
                f2.setVisible(true);
                f1.setVisible(false);
            }
        });
        b3.addActionListener(new Main() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Information.setType(2);
                System.out.println("Athlete");
                f2.setVisible(true);
                f1.setVisible(false);
            }
        });
        b4.addActionListener(new Main() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Information.setIntensity("light");
                work();
                f3.setVisible(true);
                f2.setVisible(false);
            }
        });
        b5.addActionListener(new Main() {
            @Override
            public void actionPerformed(ActionEvent e) {    
                Information.setIntensity("medium");
                work();
                f3.setVisible(true);
                f2.setVisible(false);
            }
        });
        b6.addActionListener(new Main() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Information.setIntensity("hard");
                work();
                f3.setVisible(true);
                f2.setVisible(false);
            }
        }); 
        b7.addActionListener(new Main() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f3.setVisible(false);
                f1.setVisible(true);
            }
        }); 
    }

    // Think of this as coconut.jpg for TF2
    public void actionPerformed(ActionEvent e) {
    }
    
}