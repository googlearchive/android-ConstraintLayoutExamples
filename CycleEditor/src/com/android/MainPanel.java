package com.android;

import static javax.swing.SwingConstants.TRAILING;

import com.android.CycleView.MainAttribute;
import com.android.CycleView.Model;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;

public class MainPanel extends JFrame {

  Model myModel = new Model();
  JButton myPlayButton = new JButton("play");
  JComboBox<String> baseMovement = new JComboBox<>(AnimationPanel.MOVE_NAMES);
  JComboBox<String> duration = new JComboBox<>(AnimationPanel.DURATION);
  JPanel main = new JPanel(new BorderLayout());
  JTextArea xmlOutput = new JTextArea();
  JScrollPane scrollPane = new JScrollPane(xmlOutput);
  AnimationPanel animationPanel = new AnimationPanel(myModel, myPlayButton);
  CycleView cycleView = new CycleView();
  JPanel control = new JPanel(new GridBagLayout());
  JPanel displayPanel = new JPanel(new BorderLayout());
  JMenuBar topMenu = new JMenuBar();

  MainPanel() {
    super("Cycle Editor");
    setBounds(new Rectangle(1000, 900));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    control.setBorder(new EmptyBorder(5, 10, 10, 20));
    displayPanel.add(animationPanel, BorderLayout.CENTER);
    displayPanel.add(scrollPane, BorderLayout.EAST);

    main.add(control, BorderLayout.EAST);
    main.add(cycleView, BorderLayout.CENTER);
    main.add(displayPanel, BorderLayout.SOUTH);

    myModel.xmlOutput = xmlOutput;

    scrollPane.setPreferredSize(new Dimension(100, 300));
    BasicArrowButton next = new BasicArrowButton(BasicArrowButton.EAST);
    BasicArrowButton prev = new BasicArrowButton(BasicArrowButton.WEST);
    myModel.delete = next;
    cycleView.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        myModel.selectClosest(cycleView.last_click);
      }
    });
    JTextField number = new JTextField("XX");
    number.setPreferredSize(number.getPreferredSize());
    GridBagConstraints gbc = new GridBagConstraints();
    number.setText("" + myModel.selected);
    number.setEditable(false);
    gbc.insets = new Insets(10, 5, 0, 0);
    next.addActionListener((e) -> {
      myModel.changeSelection(+1);
    });
    prev.addActionListener((e) -> {
      myModel.changeSelection(-1);
    });
    myModel.mKeyCycleNo = number;

    gbc.gridy = 0;
    gbc.gridx = 2;
    gbc.gridwidth = 1;

    control.add(new JLabel("KeyCycle:", TRAILING), gbc);
    gbc.gridx = 3;
    gbc.anchor = GridBagConstraints.EAST;
    control.add(prev, gbc);
    gbc.gridx++;
    control.add(number, gbc);
    gbc.gridx++;
    gbc.anchor = GridBagConstraints.WEST;
    control.add(next, gbc);
    gbc.gridy++;

    JButton del = new JButton("Delete");
    JButton add = new JButton("Add");
    myModel.add = add;
    myModel.delete = del;
    del.addActionListener((e) -> {
      myModel.delete();
    });
    add.addActionListener((e) -> {
      myModel.add();
    });
    gbc.gridwidth = 1;
    gbc.gridx = 3;
    control.add(add, gbc);
    gbc.gridx += 2;
    control.add(del, gbc);
    gbc.gridy++;
    gbc.gridwidth = 3;
    JSlider pos = new JSlider();
    gbc.gridx = 0;
    gbc.anchor = GridBagConstraints.NORTHEAST;
    control.add(new JLabel("Pos:", TRAILING), gbc);
    gbc.gridx += 3;
    gbc.anchor = GridBagConstraints.WEST;
    control.add(pos, gbc);
    gbc.gridy++;

    JSlider period = new JSlider();
    gbc.gridx = 0;
    gbc.anchor = GridBagConstraints.NORTHEAST;
    control.add(new JLabel("Period:", TRAILING), gbc);
    gbc.gridx += 3;
    gbc.anchor = GridBagConstraints.WEST;

    control.add(period, gbc);
    gbc.gridy++;

    JSlider amp = new JSlider();
    gbc.gridx = 0;
    gbc.anchor = GridBagConstraints.NORTHEAST;
    JComboBox<String> attrName = new JComboBox<>(MainAttribute.ShortNames);
    attrName.setSelectedIndex(myModel.mAttrIndex);
    attrName.addActionListener(e -> {
      myModel.setAttr(attrName.getSelectedIndex());
      animationPanel.setMode();
    });

    control.add(attrName, gbc);

    gbc.gridx += 3;
    gbc.anchor = GridBagConstraints.WEST;
    control.add(amp, gbc);

    gbc.gridy++;
    JSlider off = new JSlider();
    gbc.gridx = 0;
    gbc.anchor = GridBagConstraints.NORTHEAST;
    control.add(new JLabel("Offset:", TRAILING), gbc);

    gbc.gridx += 3;
    gbc.anchor = GridBagConstraints.WEST;
    control.add(off, gbc);

    gbc.gridy++;
    gbc.gridx = 0;
    gbc.anchor = GridBagConstraints.EAST;
    control.add(new JLabel("WaveType:", TRAILING), gbc);

    JComboBox<String> mode = new JComboBox<>(myModel.waveShapeName);
    gbc.gridx += 3;
    gbc.anchor = GridBagConstraints.WEST;
    control.add(mode, gbc);

    gbc.gridy++;
    gbc.gridx = 0;
    gbc.anchor = GridBagConstraints.NORTHEAST;
    control.add(new JLabel("Target:", TRAILING), gbc);

    gbc.gridx += 3;
    gbc.anchor = GridBagConstraints.WEST;
    JTextField target = new JTextField("XXXXXXXXXXXXXXXXXXXXX");
    target.setPreferredSize(target.getPreferredSize());
    target.setText("button");
    control.add(target, gbc);

    gbc.weighty = 1;
    gbc.gridx = 0;
    gbc.gridwidth = 1;
    gbc.gridy++;
    gbc.anchor = GridBagConstraints.SOUTH;
    myPlayButton.setText("XXXXX");
    myPlayButton.setPreferredSize(myPlayButton.getPreferredSize());
    myPlayButton.setText("Play");
    control.add(myPlayButton, gbc);

    gbc.gridx = 3;
    gbc.gridwidth = 3;
    baseMovement
        .addActionListener((e) -> animationPanel.setMovement(baseMovement.getSelectedIndex()));
    control.add(baseMovement, gbc);

    gbc.gridx = 2;
    gbc.gridwidth = 1;
    duration.setSelectedIndex(AnimationPanel.DURATION.length - 1);
    duration.addActionListener((e) -> animationPanel.setDurationIndex(duration.getSelectedIndex()));
    control.add(duration, gbc);

    // gbc.gridx = 0;
    // gbc.gridwidth = 6;
    // gbc.gridy++;
    // gbc.anchor = GridBagConstraints.SOUTH;
    // JButton load = new JButton("load XML");
    // load.addActionListener(e -> myModel.parseXML());
    // control.add(load, gbc);

    scrollPane.setPreferredSize(control.getPreferredSize());
    myModel.setTarget(target);

    myModel.setUIElements(pos, period, amp, off, mode);

    setContentPane(main);
    validate();

    myModel.setCycle(cycleView);
    myModel.update();
    JMenu menu = new JMenu("File");
    topMenu.add(menu);
    JMenuItem menuItem = new JMenuItem("parse xml", KeyEvent.VK_T);
    menuItem.addActionListener(e -> myModel.parseXML());
    menu.add(menuItem);

    menu = new JMenu("Examples");
    topMenu.add(menu);
    for (int i = 0; i < KeyCycleExamples.all.length; i++) {
      String text = KeyCycleExamples.all[i][1];
      int speed = Integer.parseInt(KeyCycleExamples.all[i][2]);
      int movement = Integer.parseInt(KeyCycleExamples.all[i][3]);
      menuItem = new JMenuItem(KeyCycleExamples.all[i][0]);
      menuItem.addActionListener(e -> {
        xmlOutput.setText(text);
        duration.setSelectedIndex(speed);
        baseMovement.setSelectedIndex(movement);
        myModel.parseXML();
        attrName.setSelectedIndex(myModel.mAttrIndex);
      });
      menu.add(menuItem);
    }
    menuItem = new JMenuItem("play", KeyEvent.VK_P);
    topMenu.add(menuItem);
    menuItem.addActionListener(e->animationPanel.play());

    this.setJMenuBar(topMenu);
  }

  public static void main(String[] arg) {
    MainPanel f = new MainPanel();
    f.setVisible(true);
  }

}
