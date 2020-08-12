package ArrayProblems;

import javax.swing.*;
import java.awt.*;

public class SwingsDemo extends JFrame {
    public SwingsDemo() {
        String path = "/Users/sanjay.gupta/Downloads";
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        Box myHorizontalBox = Box.createHorizontalBox();
        Box myVerticleBox = Box.createVerticalBox();

        myHorizontalBox.add(new JButton("My Button 1"));
        myHorizontalBox.add(new JButton("My Button 2"));
        myHorizontalBox.add(new JButton("My Button 3"));

        //myVerticleBox.add(new JButton(new ImageIcon(path + "/desidhaba.png")));
        //myVerticleBox.add(new JButton(new ImageIcon(path + "/jeera-rice-recipe.jpg")));
        myVerticleBox.add(new JButton(new ImageIcon(path + "/moneyheist.jpeg")));

        contentPane.add(myHorizontalBox);
        contentPane.add(myVerticleBox);

        pack();
        setVisible(true);
    }

    public static void main(String args[]) {
        new SwingsDemo();
    }
}