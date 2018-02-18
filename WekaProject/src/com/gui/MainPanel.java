package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class MainPanel extends JPanel {

	private JTextArea instancesArea, algoOutputArea;
	private JScrollPane scrollPaneInst, scrollPaneAlgo;
	private JLabel titleInst, titleAlgo, seqCov ;
	private JButton go = new JButton("GO ==>");
	private JButton clear = new JButton("Clear all");
	private JPanel leftPanel,middlePanel,middle2Panel,rightPanel;

	public JTextArea getInstancesArea() {
		return instancesArea;
	}


	public JTextArea getAlgoOutputArea() {
		return algoOutputArea;
	}


	public MainPanel() {
		this.setLayout(new BorderLayout());
		titleInst = new JLabel("Instances : ");
		titleInst.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleAlgo = new JLabel("Algo Output : ");
		titleAlgo.setAlignmentX(Component.CENTER_ALIGNMENT);
		seqCov = new JLabel("Sequential Coverage : ");
		seqCov.setAlignmentX(Component.CENTER_ALIGNMENT);
		go.setAlignmentX(Component.CENTER_ALIGNMENT);
		clear.setAlignmentX(Component.CENTER_ALIGNMENT);
		instancesArea = new JTextArea(5,20);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		instancesArea.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		algoOutputArea = new JTextArea(5,33);
		instancesArea.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		algoOutputArea.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		scrollPaneInst = new JScrollPane(instancesArea);
		scrollPaneAlgo = new JScrollPane(algoOutputArea);
		instancesArea.setEditable(false);
		algoOutputArea.setEditable(false);
		//------------------------------------------------------
		leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		leftPanel.add(titleInst);
		leftPanel.add(scrollPaneInst);
		leftPanel.setBorder(border);
		//-------------------------------------------------------
		middlePanel = new JPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
		middlePanel.add(seqCov);
		middlePanel.add(go);
		middlePanel.add(Box.createVerticalStrut(5));
		middlePanel.add(clear);
		middlePanel.setBorder(border);
		middle2Panel = new JPanel();
		middle2Panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		middle2Panel.add(middlePanel,gbc);
		//--------------------------------------------------------
		rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.add(titleAlgo);
		rightPanel.add(scrollPaneAlgo);
		rightPanel.setBorder(border);
		//--------------------------------------------------------
		go.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<1000;i++) {
					algoOutputArea.append("Hello World !\n");
					instancesArea.append("Hello World !\n");
				}
			}
		});
		
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				instancesArea.setText(null);
				algoOutputArea.setText(null);
			}
		});
		//---------------------------------------------------------
		this.add(leftPanel, BorderLayout.WEST);
		this.add(rightPanel, BorderLayout.EAST);
		this.add(middle2Panel, BorderLayout.CENTER);
	}


}
