import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame.*;

/**
 * Creates the GUI layout
 * 
 * @author fmeade
 */
public class AnimatorGUI
{
	private JFrame mainFrame, subFrame;
	private JPanel main1, main2, sub1, sub2;
	private JButton add, remove, show, exitMain, exitSub, hide;
	private JCheckBox plane, boat, clock;
	private JLabel author, planeLabel, boatLabel, clockLabel;
	private ShapeIcon planeIcon, boatIcon, clockIcon;
	private Timer timer;
	private int x, y;
	
	/**
	 * Initializes instance variables
	 */
	public AnimatorGUI()
	{
		mainFrame = new JFrame();
		subFrame = new JFrame();	
		
		main1 = new JPanel();
		main2 = new JPanel();
		sub1 = new JPanel();
		sub2 = new JPanel();
		
		add = new JButton("Add");
		remove = new JButton("Remove");
		show = new JButton("Show");
		exitMain = new JButton("Exit");
		exitSub = new JButton("Exit");
		hide = new JButton("Hide");
		
		plane = new JCheckBox("Airplane");
		boat = new JCheckBox("Boat");
		clock = new JCheckBox("Clock");
		
		planeIcon = new ShapeIcon(500,100);
		boatIcon  = new ShapeIcon(500, 140);
		clockIcon = new ShapeIcon(500, 100);
		
		author = new JLabel("      fmeade");
		planeLabel = new JLabel(planeIcon);
		boatLabel = new JLabel(boatIcon);
		clockLabel = new JLabel(clockIcon);
		
		x = 0;
		y = 0;
		
		timer = new Timer(10, new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				planeIcon.move();
				planeLabel.repaint();
				boatIcon.move();
				boatLabel.repaint();
				clockIcon.move();
				clockLabel.repaint();
		    }});
	}
	
	/**
	 * Builds the main window and creates actions for the buttons
	 */
	public void start()
	{
		mainFrame.setLayout(new GridLayout(2,1));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("Animator Menu");
		subFrame.setTitle("Animator");
		
		main1.setLayout(new GridLayout(1, 4));
		main2.setLayout(new GridLayout(1, 4));
		

		/* Button Actions */
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(plane.isSelected())
					add(1);
				
				if(boat.isSelected())
					add(2);
				
				if(clock.isSelected())
					add(3);
			}});
		
		remove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ remove(); }});
		
		show.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ show(); }});
		
		exitMain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ exitMain(); }});
		
		hide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ hide(); }});
		
		exitSub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ exitSub(); }});
		/* end acion block */
		
		/* adds buttons to frame */
		main1.add(add);
		main1.add(remove);
		main1.add(show);
		main1.add(exitMain);
		main2.add(plane);
		main2.add(boat);
		main2.add(clock);
		main2.add(author);
		plane.setSelected(true);
		mainFrame.add(main1);
		mainFrame.add(main2);
		mainFrame.setResizable(false);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	/*
	 * When clicked, a new shape is added to the sub window at a random location.
	 * The shape immediately starts moving and wraps the window.
	 * 
	 * @param _choice user choice
	 */
	private void add(int _choice)
	{
		if(_choice == 1)
		{
			x = (int)(Math.random() * 300);
			y = (int)(Math.random() * 300);
			planeIcon.addShape(new Shape(x, y,1));
			planeLabel.setBounds(0, 50, 500, 500);
			subFrame.add(planeLabel);
			if(!subFrame.isVisible())
				show();
		}
		else if(_choice == 2)
		{
			x = (int)(Math.random() * 300);
			y = (int)(Math.random() * 300);
			boatIcon.addShape(new Shape(x, y,2));
			boatLabel.setBounds(0, 50, 500, 500);
			subFrame.add(boatLabel);
			if(!subFrame.isVisible())
				show();
		}
		else
		{
			x = (int)(Math.random() * 300);
			y = (int)(Math.random() * 300);
			clockIcon.addShape(new Shape(x, y, 3));
			clockLabel.setBounds(0, 50, 500, 500);
			subFrame.add(clockLabel);
			if(!subFrame.isVisible())
				show();
		}
	}

	/*
	 * When clicked, the last added shape is removed.
	 * If the subFrame isn't showing, the button has no effect.
	 */
	private void remove()
	{
		if(plane.isSelected())
			planeIcon.remove();
		
		if(boat.isSelected())
			boatIcon.remove();
		
		if(clock.isSelected())
			clockIcon.remove();
	}

	/*
	 * When clicked, the subFrame is shown, created if necessary
	 */
	private void show()
	{
		if(!subFrame.isVisible())
		{
			subFrame.setLayout(null);
            
            subFrame.setLocation(0,(int)(mainFrame.getHeight()*1.5));
			hide.setBounds(150, 0, 100, 25);
			exitSub.setBounds(250, 0, 100, 25);
			subFrame.add(hide);
			subFrame.add(exitSub);
			subFrame.setSize(500, 500);
			subFrame.setResizable(false);
			subFrame.setVisible(true);
			timer.start();
		}
	}

	/*
	 * closes ALL windows and terminates the application.
	 */
	private void exitMain()
	{
		System.exit(JFrame.EXIT_ON_CLOSE);
	}

	/*
	 * Hides the sub-window but doesn't terminate it and pauses the animations.
	 */
	private void hide(){
		subFrame.setVisible(false);
		timer.stop();
	}

	/*
	 * Terminates the subWindow.
	 */
	private void exitSub(){
		subFrame.dispose();
		planeIcon.removeAll();
		boatIcon.removeAll();
		clockIcon.removeAll();
	}
	
	
}