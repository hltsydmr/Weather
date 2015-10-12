package Utilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DataTest.Excel2;
import DataTest.Excel3;
import DataTest.Excel4;
import DataTest.Excel5;
import jxl.read.biff.BiffException;


public class Main extends JFrame implements ActionListener{

	private JFrame jf;
	private JPanel jp;
	private JButton btn_2,btn_3,btn_4,btn_5;
	static JTextArea txt;
	private JLabel lbl;
	
	public Main()
	{
		
	jf = new JFrame();
	jf.setTitle("Weather Forecast");
	jf.setSize(600 , 400);
	jf.setLayout(new BorderLayout());
	jf.setLocationRelativeTo(null);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	jp = new JPanel();
	jp.setLayout(new GridLayout(0,4));
	jf.add(jp,BorderLayout.CENTER);
	// jp.setBackground(Color.BLUE);
	
	btn_2 = new JButton("Excel2");
	jp.add(btn_2);
	
	btn_2.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try 
			{
				new Excel2();
			} 
			catch (BiffException | IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
	
	btn_3 = new JButton("Excel3");
	jp.add(btn_3);
	
	btn_3.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try 
			{
				new Excel3();
			} 
			catch (BiffException | IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
	
	btn_4 = new JButton("Excel4");
	jp.add(btn_4);
	
	btn_4.addActionListener(new ActionListener(){
		
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try 
			{
				new Excel4();
			} 
			catch (BiffException | IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
	
	btn_5 = new JButton("Excel5");
	jp.add(btn_5);
	
	btn_5.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try 
			{
				new Excel5();
			} 
			catch (BiffException | IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
	
	
	txt = new JTextArea("try\ntry\ntry");
	jf.add(txt,BorderLayout.NORTH);
	
	
	jf.setVisible(true);
	
	
	}
	
	public static void main(String[] args) 
	{
		
		new Main();
			
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
