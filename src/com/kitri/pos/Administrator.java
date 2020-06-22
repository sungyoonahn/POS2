package com.kitri.pos;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.border.LineBorder;

public class Administrator extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ForcePos forcePos;
	private JPanel contentPane;
	private JTextField userTf;
	private JTextField passTf;
	private JTextField nameTf; 
	String user;
	String pass;
	String name;
	private JTextField notice;
	private ForcePos frame; 
	private UserDto userDto; 
	private UserDao userDao; 
	private JComboBox authority; 
	private JComboBox authorityUp;
	Vector<UserDto> data;
	Vector<String> userColumn;
	String auth; 
	private JPanel pMonitor;
	private JTable table;
	private JTextField upuserTF;
	private JTextField upassTf;
	private JTextField unameTf;
	private boolean result; 
	private DefaultTableModel tm;



	JPanel pRegister = new JPanel();

	JPanel pTable = new JPanel();

	JPanel ppRegister;

	CardLayout card = new CardLayout();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {

					Administrator administrator = new Administrator();
					administrator.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	public void showFrameTest() {
//		frame1.setVisible(true);
//		frame.dispose();
//	}

	public static void tableCellCenter(JTable table) {

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();

		dtcr.setHorizontalAlignment(SwingConstants.CENTER);

		TableColumnModel tcm = table.getColumnModel();

		
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}


	public void showFrame() {
		frame = new ForcePos();
		this.setVisible(false);
		frame.setVisible(true);
	}


	public Administrator() {

		setTitle("Force.pos");
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
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
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		titleLabel.setBounds(14, 8, 241, 31);
		pStatusBar.add(titleLabel);

		notice = new JTextField();
		notice.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		notice.setText("\uC0C1\uD488\uBA85(..)\uB294 \uC720\uD1B5\uAE30\uD55C\uC774 \uC9C0\uB0AC\uC2B5\uB2C8\uB2E4.");
		notice.setHorizontalAlignment(SwingConstants.CENTER);
		notice.setBounds(258, 8, 726, 31);
		pStatusBar.add(notice);
		notice.setColumns(10);

		JLabel dateLabel = new JLabel("2019-04-01 \uC624\uD6C4 5:01");
		dateLabel.setBackground(new Color(0, 0, 128));
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setForeground(new Color(255, 255, 255));
		dateLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		dateLabel.setBounds(1016, 8, 278, 31);
		pStatusBar.add(dateLabel);

		JPanel pMainBtn = new JPanel();
		pMainBtn.setBackground(new Color(255, 255, 255));
		pMainBtn.setBounds(0, 585, 1144, 120);
		contentPane.add(pMainBtn);
		pMainBtn.setLayout(null);

		JLabel idLabel = new JLabel();
		idLabel.setText("\uAD00\uB9AC\uC790");
		idLabel.setBackground(new Color(105, 105, 105));
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		idLabel.setBounds(860, 0, 201, 120);
		pMainBtn.add(idLabel);

		JButton mBtnInven = new JButton("\uC7AC\uACE0");
		mBtnInven.setBackground(new Color(28, 94, 94));
		mBtnInven.setForeground(new Color(255, 255, 255));
		mBtnInven.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		mBtnInven.setBounds(0, 0, 157, 120);
		pMainBtn.add(mBtnInven);

		JButton mBtnSale = new JButton("\uD310\uB9E4");
		mBtnSale.setBackground(new Color(99, 166, 166));
		mBtnSale.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		mBtnSale.setForeground(new Color(255, 255, 255));
		mBtnSale.setBounds(156, 0, 157, 120);
		pMainBtn.add(mBtnSale);

		JButton mBtnCalc = new JButton("\uC815\uC0B0");
		mBtnCalc.setBackground(new Color(28, 94, 94));
		mBtnCalc.setForeground(new Color(255, 255, 255));
		mBtnCalc.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		mBtnCalc.setBounds(313, 0, 157, 120);
		pMainBtn.add(mBtnCalc);

		JButton mBtnStat = new JButton("\uD1B5\uACC4");
		mBtnStat.setBackground(new Color(99, 166, 166));
		mBtnStat.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		mBtnStat.setForeground(new Color(255, 255, 255));
		mBtnStat.setBounds(470, 0, 157, 120);
		pMainBtn.add(mBtnStat);

		JButton mBtnAccount = new JButton("\uACC4\uC815");
		mBtnAccount.setBackground(new Color(28, 94, 94));
		mBtnAccount.setForeground(new Color(255, 255, 255));
		mBtnAccount.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		mBtnAccount.setBounds(626, 0, 157, 120);
		pMainBtn.add(mBtnAccount);

		JPanel pSellFunction = new JPanel();
		pSellFunction.setBackground(new Color(0, 0, 128));
		pSellFunction.setBounds(1144, 50, 164, 655);
		contentPane.add(pSellFunction);
		pSellFunction.setLayout(null);

		// À¯Àúµî·Ï ¹öÆ°
		JButton userInsert = new JButton("\uC720\uC800\uB4F1\uB85D");
		userInsert.setForeground(new Color(255, 255, 255));
		userInsert.setBackground(new Color(0, 0, 128));
		userInsert.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		userInsert.setBounds(0, 10, 164, 120);
		pSellFunction.add(userInsert);

		// À¯ÀúŒöÁ€ ¹öÆ°
		JButton userUpdate = new JButton("\uC720\uC800\uC218\uC815");
		userUpdate.setBackground(new Color(100, 149, 237));
		userUpdate.setForeground(new Color(255, 255, 255));
		userUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		userUpdate.setBounds(0, 130, 164, 120);
		pSellFunction.add(userUpdate);

		// À¯Àú»èÁŠ ¹öÆ°
		JButton userDelete = new JButton("\uC720\uC800\uC0AD\uC81C");
		userDelete.setBackground(new Color(0, 0, 128));
		userDelete.setForeground(new Color(255, 255, 255));
		userDelete.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		userDelete.setBounds(0, 260, 164, 120);
		pSellFunction.add(userDelete);

		JButton sBtnPdChange = new JButton("\uCD9C\uACB0");
		sBtnPdChange.setBackground(new Color(100, 149, 237));
		sBtnPdChange.setForeground(new Color(255, 255, 255));
		sBtnPdChange.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		sBtnPdChange.setBounds(0, 390, 164, 120);
		pSellFunction.add(sBtnPdChange);

		JButton logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		logout.setBackground(new Color(255, 69, 0));
		logout.setForeground(new Color(255, 255, 255));
		logout.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		logout.setBounds(0, 520, 164, 120);
		pSellFunction.add(logout);

		setpMonitor(new JPanel());
		getpMonitor().setSize(new Dimension(1144, 533));
		getpMonitor().setBackground(new Color(255, 255, 255));
		getpMonitor().setBounds(0, 50, 1144, 533);
		contentPane.add(getpMonitor());

		pRegister.setBackground(SystemColor.desktop);
		pRegister.setBorder(new LineBorder(new Color(0, 0, 0)));
		pRegister.setLayout(null);

		ppRegister = new JPanel();
		ppRegister.setBackground(Color.ORANGE);
		getpMonitor().add(ppRegister, "name_19549728576459");
		ppRegister.setLayout(null);

		JPanel prInput = new JPanel();
		prInput.setBorder(new LineBorder(new Color(0, 0, 0)));
		prInput.setBounds(451, 10, 356, 513);
		prInput.setLayout(new GridLayout(11, 1, 0, 0));
		pRegister.add(prInput);
//---------------------------------------------------------------------//
//		String header[] = {"유저코드", "ÆÐœº¿öµå", "ŸÆÀÌµð", "±ÇÇÑ", "ÀÌž§"};

		// È­žé¿¡ »Ñ·ÁÁÖŽÂ Å×ÀÌºí !!!¿µ¿ª
		setUserDao(new UserDao());
		data = getUserDao().getMemberList();
//		data.clear();
//		data = userDao.getMemberList();

		// ÄÃ·³ží
		userColumn = new Vector<String>();
		
		userColumn.addElement("유저코드");
		userColumn.addElement("패스워드");
		userColumn.addElement("아이디");
		userColumn.addElement("권한");
		userColumn.addElement("이름");

		setTm(new DefaultTableModel(userColumn, 0));
		setTable(new JTable(getTm()));

		JScrollPane scrollPane = new JScrollPane(getTable());
		pTable.add(scrollPane);
		getTable().setRowHeight(60);
		tableCellCenter(getTable());
		pTable.setLayout(null);
		scrollPane.setBounds(0, 5, 1144, 528);

		int size = data.size();

		for (int i = 0; i < size; i++) {
			// Çà
			Vector<String> row = new Vector<String>();

			// ŒýÀÚžŠ ¹®ÀÚ·Î º¯È¯ Çà¿¡ Ãß°¡
			row.addElement(data.get(i).getUserCode() + "");
			row.addElement(data.get(i).getPw());
			row.addElement(data.get(i).getId());
			row.addElement(data.get(i).getAuthority());
			row.addElement(data.get(i).getName());

			getTm().addRow(row);

		}
		
		// Ä«µå·¹ÀÌŸÆ¿ôŽãŽç.
		getpMonitor().setLayout(card);
		getpMonitor().add("pTable", pTable);
		getpMonitor().add("pRegister", pRegister);
		getpMonitor().add("ppRegister", ppRegister);
		card.show(getpMonitor(), "pTable");

		JPanel panel = new JPanel();
		prInput.add(panel);

		JLabel userIdLabel = new JLabel("\uC720\uC800ID");
		userIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userIdLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		userIdLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		prInput.add(userIdLabel);

		// Èž¿øµî·Ï - À¯ÀúŸÆÀÌµðÀÔ·Â
		userTf = new JTextField();
		userTf.setHorizontalAlignment(SwingConstants.CENTER);
		prInput.add(userTf);
		userTf.setColumns(10);
		JLabel passWLabel_1 = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		passWLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		passWLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		prInput.add(passWLabel_1);

		// Èž¿øµî·Ï - ÆÐœº¿öµåÀÔ·Â
		passTf = new JTextField();
		passTf.setHorizontalAlignment(SwingConstants.CENTER);
		prInput.add(passTf);
		passTf.setColumns(10);
		JLabel lblNewLabel_2 = new JLabel("\uC774\uB984");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		prInput.add(lblNewLabel_2);

		// Èž¿øµî·Ï - ÀÌž§ÀÔ·Â
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		prInput.add(nameTf);
		nameTf.setColumns(10);
		JLabel lblNewLabel_3 = new JLabel("\uAD8C\uD55C");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		prInput.add(lblNewLabel_3);

		// ±ÇÇÑ¹è¿­

		setAuthority(new JComboBox());
		getAuthority().addItem("관리자");
		getAuthority().addItem("직원");
		prInput.add(getAuthority());

		// ŸÆ·¡¹öÆ°ÆÐ³Î
		JPanel pB = new JPanel();
		prInput.add(pB);
		pB.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// È®ÀÎ¹öÆ°
		JButton ok = new JButton("\uD655\uC778");
		ok.setMargin(new Insets(2, 20, 2, 20));
		ok.setHorizontalTextPosition(SwingConstants.CENTER);
		ok.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		ok.setAlignmentX(Component.CENTER_ALIGNMENT);
		pB.add(ok);

		// ÃëŒÒ¹öÆ°
		JButton cancel = new JButton("\uCDE8\uC18C");
		cancel.setMargin(new Insets(2, 20, 2, 20));
		cancel.setBackground(new Color(255, 99, 71));
		cancel.setHorizontalTextPosition(SwingConstants.CENTER);
		cancel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pB.add(cancel);

		// Èž¿øŒöÁ€ - È­žé
		JPanel prInsert = new JPanel();
		prInsert.setBounds(451, 10, 356, 513);
		prInsert.setBorder(new LineBorder(new Color(0, 0, 0)));
		ppRegister.add(prInsert);
		prInsert.setLayout(new GridLayout(11, 1, 0, 0));

		JPanel panel_2 = new JPanel();
		prInsert.add(panel_2);

		JLabel upuserL = new JLabel("\uC720\uC800ID");
		upuserL.setHorizontalAlignment(SwingConstants.CENTER);
		upuserL.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		prInsert.add(upuserL);

		upuserTF = new JTextField();
		upuserTF.setHorizontalAlignment(SwingConstants.CENTER);
		upuserTF.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		upuserTF.setEnabled(false);
		upuserTF.setDragEnabled(true);
		upuserTF.setColumns(10);
		prInsert.add(upuserTF);

		JLabel uppassL = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		uppassL.setHorizontalAlignment(SwingConstants.CENTER);
		uppassL.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		prInsert.add(uppassL);

		upassTf = new JTextField();
		upassTf.setHorizontalAlignment(SwingConstants.CENTER);
		upassTf.setColumns(10);
		prInsert.add(upassTf);

		JLabel upnameL = new JLabel("\uC774\uB984");
		upnameL.setHorizontalAlignment(SwingConstants.CENTER);
		upnameL.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		prInsert.add(upnameL);

		unameTf = new JTextField();
		unameTf.setHorizontalAlignment(SwingConstants.CENTER);
		unameTf.setColumns(10);
		prInsert.add(unameTf);

		JLabel upauthL = new JLabel("\uAD8C\uD55C");
		upauthL.setHorizontalAlignment(SwingConstants.CENTER);
		upauthL.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		prInsert.add(upauthL);

		// ŒöÁ€È­žé ÄÞºž¹Úœº
		setAuthorityUp(new JComboBox());
		getAuthorityUp().addItem("관리자");
		getAuthorityUp().addItem("직원");
		prInsert.add(getAuthorityUp());

		JPanel panel_3 = new JPanel();
		prInsert.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton button = new JButton("\uC218\uC815");
		button.setMargin(new Insets(2, 20, 2, 20));
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		button.setAlignmentX(0.5f);
		panel_3.add(button);

		JButton button_1 = new JButton("\uCDE8\uC18C");
		button_1.setMargin(new Insets(2, 20, 2, 20));
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		button_1.setBackground(new Color(255, 99, 71));
		panel_3.add(button_1);

		// ÀÌº¥Æ® ž®œº³Ê µî·Ï
		userInsert.addActionListener(this);
		userUpdate.addActionListener(this);
		//
		userDelete.addActionListener(this);
		logout.addActionListener(this);
		getAuthority().addActionListener(this);
		getAuthorityUp().addActionListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);
		button.addActionListener(this);
		button_1.addActionListener(this);
		
		//
		getTable().addMouseListener(ms);
	}

	// Èž¿øµî·ÏÃ¢¿¡ ÀÔ·ÂµÈ °ªÀ» ºž¿©Áà
	public UserDto getViewData() {

		userDto = new UserDto();

		userDto.setPw(passTf.getText());
		userDto.setId(userTf.getText());
		userDto.setName(nameTf.getText());
		userDto.setAuthority(auth);

		return userDto;

	}

	// Èž¿ø ŒöÁ€Ã¢¿¡ ÀÔ·ÂµÈ °ªÀ» ºž¿©Áà
	public UserDto getViewUpdata() {

		userDto = new UserDto();

		userDto.setId(upuserTF.getText());
		userDto.setPw(upassTf.getText());
		userDto.setName(unameTf.getText());
		userDto.setAuthority(auth);

		return userDto;

	}
	
	
	public boolean isUserId() {

		user = userTf.getText().trim();
		pass = passTf.getText().trim();
		name = nameTf.getText().trim();

		if (user.length() > 10) {
			JOptionPane.showMessageDialog(this, "아이디는 10자 미만으로 생성가능합니다.", "ID생성 오류", JOptionPane.WARNING_MESSAGE);
			setResult(false);
		} else if (user.isEmpty() || pass.isEmpty() || name.isEmpty()) {
			JOptionPane.showMessageDialog(this, "공백은 안되요!!!");
				setResult(false);
		} else {
				setResult(true);
		}
		
		return isResult();
	}

	// Èž¿øµî·Ï À¯È¿Œº°Ë»ç.
	void insertUser() {

		getViewData();

		if (isUserId()) {
			JOptionPane.showMessageDialog(this, "등록이 완료되었습니다. 감사합니다");
			card.show(getpMonitor(), "pTable");
		} else {
			JOptionPane.showMessageDialog(this, "등록이 실패 하였습니다.");
			return;
		}
	}

	void updateUser() {

		setUserDao(new UserDao());
		UserDto re = getViewUpdata();

		try {
			boolean result;
			
			result = getUserDao().updateMember(re);

			if (result) {
				JOptionPane.showMessageDialog(this, "수정이 완료되었습니다.");
				card.show(getpMonitor(), "pTable");
			} else {
				JOptionPane.showMessageDialog(this, "수정이 실패하였습니다.");
			 	return;
			}
			
			getUserDao().userSelectAll(getTm());
			
		} catch (SQLException e) {
			System.out.println("업데이트 실패");
			e.printStackTrace();
		}
	}

	void deleteUser() {
		// ÇàÀÇ ¹øÈ£žŠ »ÌŸÆ¿È.
		int numberRow = getTable().getSelectedRow();
		// ¿­ÀÇ ¹øÈ£žŠ »ÌŸÆ¿È.
//		int numberColumn = table.getSelectedColumn();
		String id = (String) getTm().getValueAt(numberRow, 2);

		if (id.length() == 0) {
			JOptionPane.showMessageDialog(this, "id를 클릭해주세요.");
			return;
		}

		setUserDao(new UserDao());

		try {
			boolean result;
			result = getUserDao().deleteMember(id);

			if (result) {
				JOptionPane.showMessageDialog(this, "삭제완료");
			} else {
				JOptionPane.showMessageDialog(this, "삭제실패");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// À¯Àú µî·Ï ÅØœºÆ®ÇÊµå ÃÊ±âÈ­
	public void tfClear() {
		userTf.setText("");
		passTf.setText("");
		nameTf.setText("");
	}

	// À¯Àú ŒöÁ€ ÅØœºÆ®ÇÊµå ÃÊ±âÈ­
	public void tfUClear() {
		upassTf.setText("");
		upuserTF.setText("");
		unameTf.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object ob = e.getActionCommand();
		Object ob2 = e.getSource();

		//ÄÞºž¹Úœº¿¡Œ­ ±ÇÇÑ Œ³Á€ÇÒ œÃ ±ÇÇÑ º¯°æ
		if (ob2 == getAuthority()) {
			String str = getAuthority().getSelectedItem().toString();
//			System.out.println(str);
			if(str.equals("관리자")) {
				auth = "T";
			}else if(str.equals("직원")){
				auth = "F";
			}
		}
			if(ob2 == getAuthorityUp()) {
			String str = getAuthorityUp().getSelectedItem().toString();
			System.out.println(str);
				if(str.equals("관리자")) {
					auth = "T";
				}else if(str.equals("직원")){
					auth = "F";
				}	
				
				System.out.println(auth);
		}


		// Èž¿øµî·ÏÀÌ¶ó°íÇÏÁÒ.
		if (ob.equals("À¯Àúµî·Ï")) {
			card.show(getpMonitor(), "pRegister");
//			isSelect(); //±ÇÇÑ Œ³Á€
			tfClear();
		}

		// Èž¿øŒöÁ€ÀÌ¶ó°í ÇÏÁÒ.
		if (ob.equals("À¯ÀúŒöÁ€")) {
			tfUClear();
			// ÇàÀÇ ¹øÈ£žŠ »ÌŸÆ¿È.
			int numberRow = getTable().getSelectedRow();
			
			// ¿­ÀÇ ¹øÈ£žŠ »ÌŸÆ¿È.
//			int numberColumn = table.getSelectedColumn();
			if (getTable().getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Å×ÀÌºíÀ» Å¬ž¯ÇØÁÖŒŒ¿ä.");
			} else {
				String id = (String) getTm().getValueAt(numberRow, 2);
				card.show(getpMonitor(), "ppRegister");
				upuserTF.setText(id);
			}
		}

		// À¯ÀúžŠ Áö¿öºžµµ·Ï ÇÏÁÒ.
		if (ob.equals("À¯Àú»èÁŠ")) {

			UserDao userDao = new UserDao();

			if (getTable().getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Å×ÀÌºíÀ» Å¬ž¯ÇØÁÖŒŒ¿ä.");
			
		} else {
			int x = JOptionPane.showConfirmDialog(this, "Á€ž» »èÁŠ ÇÏœÃ°ÚœÀŽÏ±î?", "»èÁŠ", JOptionPane.YES_NO_OPTION);
			if (x == JOptionPane.OK_OPTION) {
				deleteUser();
				try {
					userDao.userSelectAll(getTm());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(this, "»èÁŠžŠ ÃëŒÒÇÏ¿ŽœÀŽÏŽÙ.");
				}
			}
		}


		if (ob.equals("ŒöÁ€")) {
			updateUser();
		}

		// È®ÀÎÀ» Ž©ž£žé À¯Àúµî·ÏÃ¢
		if (ob.equals("È®ÀÎ")) {

			insertUser(); // À¯È¿Œº °Ë»ç

			UserDto re = getViewData(); // œÇÁŠ ³ÑŸî°£ µ¥ÀÌÅÍ userDto¿¡ ÀúÀå.
			setUserDao(new UserDao()); // userDao °ŽÃŒ »ýŒº

			if (isResult()) { // µ¥ÀÌÅÍ°¡ ³ÑŸî °¬ŽÙžé.
				try {
					getUserDao().getMemberList(); // select ¹® œÇÇà.
					getUserDao().insertMember(re); // insert¹® œÇÇà.
					getUserDao().userSelectAll(getTm());
//					tableRefresh();
				} catch (SQLException e1) {
					System.out.println("È®ÀÎ œÇÆÐ");
					e1.printStackTrace();
				}
			} else {
				setResult(false);
				return;
			}

		}

		// ÃëŒÒ¹öÆ°À» Ž©ž£ŽÂ µ¿œÃ¿¡ ŽÙœÃ Å×ÀÌºíÈ­žéÀž·Î.
		if (ob.equals("ÃëŒÒ")) {
			System.out.println("ÃëŒÒ¹öÆ°µî·Ï");
			card.show(getpMonitor(), "pTable");
		}

		// ž»±×Žë·Î ·Î±×ŸÆ¿ô žÞÀÎÇÁ·¹ÀÓÀž·Î ³ÑŸî°š.
		if (ob.equals("·Î±×ŸÆ¿ô")) {
			this.setVisible(false);
			setForcePos(new ForcePos());
			getForcePos().setVisible(true);
		}

	}
	
	public JComboBox getAuthority() {
		return authority;
	}

	public void setAuthority(JComboBox authority) {
		this.authority = authority;
	}

	public JComboBox getAuthorityUp() {
		return authorityUp;
	}

	public void setAuthorityUp(JComboBox authorityUp) {
		this.authorityUp = authorityUp;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public DefaultTableModel getTm() {
		return tm;
	}

	public void setTm(DefaultTableModel tm) {
		this.tm = tm;
	}

	public ForcePos getForcePos() {
		return forcePos;
	}

	public void setForcePos(ForcePos forcePos) {
		this.forcePos = forcePos;
	}

	public JPanel getpMonitor() {
		return pMonitor;
	}

	public void setpMonitor(JPanel pMonitor) {
		this.pMonitor = pMonitor;
	}
	
	MouseAdapter ms = new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			super.mouseClicked(e);
			
			setTable((JTable) e.getComponent());
			setTm((DefaultTableModel) getTable().getModel());
			
		}
		
	};
}