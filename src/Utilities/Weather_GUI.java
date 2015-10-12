package Utilities;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
//import java.time.Year;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import DataTest.Excel2;
import DataTest.Excel3;
import DataTest.Excel4;
import DataTest.Excel5;
import Predict.predictFuture;


public class Weather_GUI extends JFrame {
	private JPanel contentPane;
	public static JTextArea txt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Weather_GUI frame = new Weather_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Weather_GUI() {
		setBackground(Color.ORANGE);
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 443);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setForeground(Color.BLACK);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnExcel_1 = new JButton("");
		btnExcel_1.setIcon(new ImageIcon("Numbers-2-Black-icon.png"));
		btnExcel_1.setForeground(new Color(102, 51, 0));
		btnExcel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnExcel_1.setBackground(new Color(255, 102, 0));
		
		btnExcel_1.setBorderPainted(false); 
		btnExcel_1.setContentAreaFilled(false); 
		btnExcel_1.setFocusPainted(false); 
		btnExcel_1.setOpaque(false);
		
		panel.add(btnExcel_1);
		
		JButton btnExcel_2 = new JButton("");
		btnExcel_2.setIcon(new ImageIcon("Numbers-3-Black-icon.png"));
		btnExcel_2.setForeground(new Color(102, 51, 0));
		btnExcel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnExcel_2.setBackground(new Color(255, 102, 0));
		
		btnExcel_2.setBorderPainted(false); 
		btnExcel_2.setContentAreaFilled(false); 
		btnExcel_2.setFocusPainted(false); 
		btnExcel_2.setOpaque(false);
		
		panel.add(btnExcel_2);
		
		JButton btnExcel_3 = new JButton("");
		btnExcel_3.setIcon(new ImageIcon("Numbers-4-Black-icon.png"));
		btnExcel_3.setForeground(new Color(102, 51, 0));
		btnExcel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnExcel_3.setBackground(new Color(255, 102, 0));
		
		btnExcel_3.setBorderPainted(false); 
		btnExcel_3.setContentAreaFilled(false); 
		btnExcel_3.setFocusPainted(false); 
		btnExcel_3.setOpaque(false);
		
		panel.add(btnExcel_3);
		
		JButton btnExcel_4 = new JButton("");
		btnExcel_4.setIcon(new ImageIcon("Numbers-5-Black-icon.png"));
		btnExcel_4.setForeground(new Color(102, 51, 0));
		btnExcel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnExcel_4.setBackground(new Color(255, 102, 0));
		
		btnExcel_4.setBorderPainted(false); 
		btnExcel_4.setContentAreaFilled(false); 
		btnExcel_4.setFocusPainted(false); 
		btnExcel_4.setOpaque(false);
		
		panel.add(btnExcel_4);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JButton btnDays = new JButton("predict");
		btnDays.setIcon(new ImageIcon("Numbers-5-Black-icon.png"));
		btnDays.setForeground(new Color(102, 51, 0));
		btnDays.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnDays.setBackground(new Color(255, 102, 0));
		btnDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txt.setText("");
				try {
					new predictFuture();
					//new kumeleme.KumeleClass();
					//new kumeleme.writeARFF();
					//new kumeleme.writeARFF_2();
				} catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}// catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				//} catch (WriteException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				//}
				
			}
		});
		panel_4.add(btnDays);
		
		txt = new JTextArea();
		txt.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		txt.setBackground(new Color(255, 204, 102));
		txt.setText("TextField");
		txt.setEditable(false);
		JScrollPane scroll = new JScrollPane(txt);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		contentPane.add(scroll, BorderLayout.CENTER);
		
		Panel panel_1 = new Panel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		Panel panel_2 = new Panel();
		contentPane.add(panel_2, BorderLayout.WEST);
		
		Panel panel_3 = new Panel();
		contentPane.add(panel_3, BorderLayout.EAST);
		
		btnExcel_1.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					txt.setText("");
					new Excel2();
				} 
				catch (BiffException | IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
	btnExcel_2.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					txt.setText("");
					new Excel3();
				} 
				catch (BiffException | IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	
	btnExcel_3.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try 
			{
				txt.setText("");
				new Excel4();
			} 
			catch (BiffException | IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
	
	btnExcel_4.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try 
			{
				txt.setText("");
				new Excel5();
			} 
			catch (BiffException | IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
	
	}

}
