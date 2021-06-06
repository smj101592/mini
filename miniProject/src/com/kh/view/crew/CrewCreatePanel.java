package com.kh.view.crew;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.kh.controller.crew.CrewCreateController;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class CrewCreatePanel extends JPanel {

	private CrewViewManager crewManager;
	
	private CrewCreateController createController;
	
	private JTextField textFieldCrewName; // 크루명이 입력되는 텍스트필드
	private JTextArea textAreaCrewContents; // 크루 소개가 입력되는 텍스트 에리어

	public CrewCreatePanel() {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JButton btnCreateCrew = new JButton("완료");
		btnCreateCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createController.createCrew(textFieldCrewName.getText(), textAreaCrewContents.getText(), crewManager.getUser().getName());
				crewManager.convertPanel("main"); // main page로
			}
		});
		btnCreateCrew.setBounds(235, 20, 97, 23);
		add(btnCreateCrew);
		
		JPanel panelTextArea = new JPanel();
		panelTextArea.setBounds(15, 270, 330, 240);
		add(panelTextArea);
		panelTextArea.setLayout(null);
		
		textAreaCrewContents = new JTextArea();
		textAreaCrewContents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textAreaCrewContents.setText("");
			}
		});
		textAreaCrewContents.setText("내용을 입력해주세요");
		textAreaCrewContents.setToolTipText("");
		textAreaCrewContents.setBounds(5, 5, 320, 230);
		panelTextArea.add(textAreaCrewContents);
		textAreaCrewContents.setBackground(Color.WHITE);
		textAreaCrewContents.setToolTipText("");
		
		JLabel lblCrewContents = new JLabel("소 개");
		lblCrewContents.setBounds(12, 228, 79, 23);
		add(lblCrewContents);
		
		JLabel lblCrewName = new JLabel("크루 명");
		lblCrewName.setBounds(12, 86, 66, 23);
		add(lblCrewName);
		
		JPanel panelTextField = new JPanel();
		panelTextField.setBounds(22, 119, 310, 38);
		add(panelTextField);
		panelTextField.setLayout(null);
		
		textFieldCrewName = new JTextField();
		textFieldCrewName.setBounds(50, 0, 260, 30);
		panelTextField.add(textFieldCrewName);
		textFieldCrewName.setColumns(10);
		
		JPanel footerPanel = new JPanel();
		footerPanel.setBackground(Color.LIGHT_GRAY);
		footerPanel.setBounds(0, 561, 360, 29);
		add(footerPanel);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crewManager.convertPanel("main");
			}
		});
		footerPanel.add(lblHome);
	}

	public CrewCreatePanel(CrewViewManager crewManager, CrewCreateController createController) {
		this();
		this.crewManager = crewManager;
		this.createController = createController;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewCreatePanel panel = new CrewCreatePanel();
					panel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
