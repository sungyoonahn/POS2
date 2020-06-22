package com.kitri.pos.calc;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Cmain extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField notice;
	
	
	
	Cmain frame1;
	CardLayout card = new CardLayout();
	JPanel pMonitor;
	static PCalc pCalc;
	CalcService calcService;
	
	JButton mBtnCalc;
	
	static JPanel pTest;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	
		EventQueue.invokeLater(new Runnable() {	 
			public void run() {
				try {
					Cmain frame1 = new Cmain();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		System.out.println(pCalc.data[2][2]);
	}

	/**
	 * Create the frame.
	 */
	
	public void showFrameTest() {
		frame1.setVisible(true);
//		frame.dispose();
	}
	
	
	public Cmain() {
		setFont(new Font("���� ���", Font.BOLD, 20));
		setTitle("Force.pos");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 15, 1326, 753);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pStatusBar = new JPanel();
		pStatusBar.setBackground(new Color(0, 0, 128));
		pStatusBar.setBounds(0, 0, 1308, 51);
		contentPane.add(pStatusBar);
		pStatusBar.setLayout(null);
		
		JLabel titleLabel = new JLabel("Force. pos");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(new Color(0, 0, 128));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("���� ���", Font.BOLD, 25));
		titleLabel.setBounds(14, 8, 241, 31);
		pStatusBar.add(titleLabel);
		
		notice = new JTextField();
		notice.setFont(new Font("���� ���", Font.PLAIN, 20));
		notice.setText("\uC0C1\uD488\uBA85(..)\uB294 \uC720\uD1B5\uAE30\uD55C\uC774 \uC9C0\uB0AC\uC2B5\uB2C8\uB2E4.");
		notice.setHorizontalAlignment(SwingConstants.CENTER);
		notice.setBounds(258, 8, 726, 31);
		pStatusBar.add(notice);
		notice.setColumns(10);
		
		JLabel dateLabel = new JLabel("2019-04-01 \uC624\uD6C4 5:01");
		dateLabel.setBackground(new Color(0, 0, 128));
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setForeground(new Color(255, 255, 255));
		dateLabel.setFont(new Font("���� ���", Font.PLAIN, 20));
		dateLabel.setBounds(1016, 8, 278, 31);
		pStatusBar.add(dateLabel);
		
		JPanel pMainBtn = new JPanel();
		pMainBtn.setBackground(new Color(255, 255, 255));
		pMainBtn.setBounds(0, 585, 1144, 120);
		contentPane.add(pMainBtn);
		pMainBtn.setLayout(null);
		
		JLabel idLabel = new JLabel("\uAD00\uB9AC\uC790");
		idLabel.setBackground(new Color(105, 105, 105));
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("���� ���", Font.BOLD, 20));
		idLabel.setBounds(860, 0, 201, 120);
		pMainBtn.add(idLabel);
		
		JButton mBtnInven = new JButton("\uC7AC\uACE0");
		mBtnInven.setBackground(new Color(28, 94, 94));
		mBtnInven.setForeground(new Color(255, 255, 255));
		mBtnInven.setFont(new Font("���� ���", Font.BOLD, 20));
		mBtnInven.setBounds(0, 0, 157, 120);
		pMainBtn.add(mBtnInven);
		
		JButton mBtnSale = new JButton("\uD310\uB9E4");
		mBtnSale.setBackground(new Color(99, 166, 166));
		mBtnSale.setFont(new Font("���� ���", Font.BOLD, 20));
		mBtnSale.setForeground(new Color(255, 255, 255));
		mBtnSale.setBounds(156, 0, 157, 120);
		pMainBtn.add(mBtnSale);
		
		mBtnCalc = new JButton("\uC815\uC0B0");
		mBtnCalc.setBackground(new Color(28, 94, 94));
		mBtnCalc.setForeground(new Color(255, 255, 255));
		mBtnCalc.setFont(new Font("���� ���", Font.BOLD, 20));
		mBtnCalc.setBounds(313, 0, 157, 120);
		pMainBtn.add(mBtnCalc);
		
		JButton mBtnStat = new JButton("\uD1B5\uACC4");
		mBtnStat.setBackground(new Color(99, 166, 166));
		mBtnStat.setFont(new Font("���� ���", Font.BOLD, 20));
		mBtnStat.setForeground(new Color(255, 255, 255));
		mBtnStat.setBounds(470, 0, 157, 120);
		pMainBtn.add(mBtnStat);
		
		JButton mBtnAccount = new JButton("\uACC4\uC815");
		mBtnAccount.setBackground(new Color(28, 94, 94));
		mBtnAccount.setForeground(new Color(255, 255, 255));
		mBtnAccount.setFont(new Font("���� ���", Font.BOLD, 20));
		mBtnAccount.setBounds(626, 0, 157, 120);
		pMainBtn.add(mBtnAccount);
		
		JPanel pSellFunction = new JPanel();
		pSellFunction.setBackground(new Color(0, 0, 128));
		pSellFunction.setBounds(1144, 50, 164, 655);
		contentPane.add(pSellFunction);
		pSellFunction.setLayout(null);
		
		JButton sBtnCustomer = new JButton("\uC7AC\uACE0\uC870\uD68C");
		sBtnCustomer.setForeground(new Color(255, 255, 255));
		sBtnCustomer.setBackground(new Color(0, 0, 128));
		sBtnCustomer.setFont(new Font("���� ���", Font.BOLD, 20));
		sBtnCustomer.setBounds(0, 0, 164, 120);
		pSellFunction.add(sBtnCustomer);
		
		JButton sBtnDisuse = new JButton("\uC785\uCD9C\uACE0");
		sBtnDisuse.setBackground(new Color(100, 149, 237));
		sBtnDisuse.setForeground(new Color(255, 255, 255));
		sBtnDisuse.setFont(new Font("���� ���", Font.BOLD, 20));
		sBtnDisuse.setBounds(0, 130, 164, 120);
		pSellFunction.add(sBtnDisuse);
		
		JButton sBtnPdInput = new JButton("\uC7AC\uACE0\uB4F1\uB85D");
		sBtnPdInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sBtnPdInput.setBackground(new Color(0, 0, 128));
		sBtnPdInput.setForeground(new Color(255, 255, 255));
		sBtnPdInput.setFont(new Font("���� ���", Font.BOLD, 20));
		sBtnPdInput.setBounds(0, 260, 164, 120);
		pSellFunction.add(sBtnPdInput);
		
		JButton sBtnPdChange = new JButton("\uC7AC\uACE0\uC218\uC815");
		sBtnPdChange.setBackground(new Color(100, 149, 237));
		sBtnPdChange.setForeground(new Color(255, 255, 255));
		sBtnPdChange.setFont(new Font("���� ���", Font.BOLD, 20));
		sBtnPdChange.setBounds(0, 390, 164, 120);
		pSellFunction.add(sBtnPdChange);
		
		JButton sBtnPdCancel = new JButton("\uC7AC\uACE0\uC0AD\uC81C");
		sBtnPdCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sBtnPdCancel.setBackground(new Color(0, 0, 128));
		sBtnPdCancel.setForeground(new Color(255, 255, 255));
		sBtnPdCancel.setFont(new Font("���� ���", Font.BOLD, 20));
		sBtnPdCancel.setBounds(0, 520, 164, 120);
		pSellFunction.add(sBtnPdCancel);
		
		
		//test
		pTest = new JPanel();
		
		pMonitor = new JPanel();
		pCalc = new PCalc();
		pMonitor.setBackground(new Color(255, 255, 255));
		pMonitor.setBounds(0, 50, 1144, 535);
		contentPane.add(pMonitor);
		pMonitor.setLayout(card);
		pMonitor.add("Calc",pCalc);
//		card.show(pMonitor,"Calc");
/////////////////////////////////////test		
		
		pMonitor.add("Test", pTest);
		card.show(pMonitor, "Test");
//////////////////////////////////////////
		
		
		calcService = new CalcService(this);
		
		mBtnCalc.addActionListener(calcService);
		pCalc.btnCalc_0.addActionListener(calcService);
		pCalc.btnCalc_1.addActionListener(calcService);
		pCalc.btnCalc_2.addActionListener(calcService);
		pCalc.btnCalc_3.addActionListener(calcService);
		pCalc.btnCalc_4.addActionListener(calcService);
		pCalc.btnCalc_5.addActionListener(calcService);
		pCalc.btnCalc_6.addActionListener(calcService);
		pCalc.btnCalc_7.addActionListener(calcService);
		pCalc.btnCalc_8.addActionListener(calcService);
		pCalc.btnCalc_9.addActionListener(calcService);
		pCalc.btnCalc_00.addActionListener(calcService);
		pCalc.btnCalc_del.addActionListener(calcService);
		pCalc.btnCalc_C.addActionListener(calcService);
		pCalc.btnCalc_Apply.addActionListener(calcService);
		pCalc.btnCalc_Cancel.addActionListener(calcService);
		
		
		
		
		
	
	}


	
}