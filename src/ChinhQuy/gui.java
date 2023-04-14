package ChinhQuy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;



public class gui extends JFrame implements ActionListener, MouseListener{
	
	private JTextField txtMaLop, txtTenLop, txtSiSo;
	private String[] cols = {"Mã lớp" , "Tên lớp", "Sỉ số"};
	private JTable table;
	private DefaultTableModel model;
	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXemTT;
	public gui() {
		//Khởi tạo kết nối
		setTitle("Thông tin lớp học");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 380);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		
		
		JPanel pnSouth, pnCenter, pnNorth;
		add(pnNorth = new JPanel(), BorderLayout.NORTH);
		add(pnCenter = new JPanel(), BorderLayout.CENTER);
		add(pnSouth = new JPanel(), BorderLayout.SOUTH);
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		pnNorth.add(new JLabel("Thông tin lớp học"));
		
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane pane = new JScrollPane(table);
		pnCenter.add(pane);
		pane.setPreferredSize(new Dimension(670, 170));
		
		JPanel pnbtn = new JPanel();
		pnbtn.add(new JButton("<<"));
		pnbtn.add(new JButton("<"));
		pnbtn.add(new JButton(">"));
		pnbtn.add(new JButton(">>"));
		pnCenter.add(pnbtn);
		
		JPanel pnMa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnMa.add(new JLabel("Mã lớp: "));
		pnMa.add(txtMaLop = new JTextField(20));
		pnMa.add(new JLabel());
		pnCenter.add(pnMa);

		JPanel pnTen = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnTen.add(new JLabel("Tên lớp: "));
		pnTen.add(txtTenLop = new JTextField(55));
		pnCenter.add(pnTen);
		
		JPanel pnsiso = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnsiso.add(new JLabel("Sỉ số: "));
		pnsiso.add(txtSiSo = new JTextField(8));
//		txtSiSo.setEditable(false);
		pnCenter.add(pnsiso);
		
		//load dữ liệu lên table
		
		pnSouth.add(btnThem = new JButton("Thêm"));
		pnSouth.add(btnLuu = new JButton("Lưu"));
		pnSouth.add(btnSua = new JButton("Sửa"));
		pnSouth.add(btnXoa = new JButton("Xóa"));
		pnSouth.add(btnXemTT = new JButton("Xem thông tin sinh viên"));
		
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXemTT.addActionListener(this);
		table.addMouseListener(this);
	}
	
	public static void main(String[] args) {
		new gui().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			if(valiData()) {
				if(txtMaLop.getText() == "" || txtTenLop.getText() == ""  || txtSiSo.getText() == "") {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
				}
				else {
					Object[] obj = {txtMaLop.getText(), txtTenLop.getText(), txtSiSo.getText()};
					model.addRow(obj);
				}
			}
		}
		if(o.equals(btnLuu)) {
			
		}
		
		if(o.equals(btnSua)) {
			
		}
		
		if(o.equals(btnXoa)) {
			
		}
		
		if(o.equals(btnXemTT)) {
			
		}
	}


	private boolean valiData() {
		String maLop = txtMaLop.getText();
		String tenLop = txtTenLop.getText();
		try {
			int siSo = (int) Integer.parseInt(txtSiSo.getText());
			if(siSo < 0 || siSo > 40) {
				JOptionPane.showMessageDialog(this, "Sỉ số phải lớn hơn 0 và bé hơn 40");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Lỗi cú pháp sỉ số!");
			return false;
		}
		
		if(!(maLop.length() > 0 && maLop.matches("^(ML)\\d*"))) {
			JOptionPane.showConfirmDialog(this, "Sai ma");
			return false;
		}
		
		return true;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

//private boolean validData() {
//	String maNV = txtMaNV.getText().trim();
//	String ho = txtHo.getText().trim();
//	String ten = txtTenNV.getText().trim();
//	int tuoi = Integer.parseInt(txtTuoi.getText().trim());
//	
//	if(!(maNV.length() > 0 && maNV.matches("(NV)\\d{3}"))) {
//		JOptionPane.showMessageDialog(this, "Mã nhân viên theo mẫu: NV + 3 số");
//		return false;
//	}
//	
//	if(!(ho.length() > 0 && ho.matches("^[A-Z][a-z]+$"))) {
//		JOptionPane.showMessageDialog(this, "Họ phải là một từ và viết hoa chữ đầu");
//		return false;
//	}
//	if(!(ten.length() > 0 && ten.matches("^[A-Z][a-z]+\\s([A-Z][a-z]+)*"))){
//		JOptionPane.showMessageDialog(this, "Tên phải là một hoặc nhiều từ và viết hoa chữ đầu và ngăn cách nhau bởi dấu cách");
//		return false;
//	}
//	if(!(tuoi >= 18 && tuoi <=60)) {
//		JOptionPane.showMessageDialog(this, "Tuổi phải từ 18 đến 60");
//		return false;
//	}
//	return true;
//}
//if (o.equals(btnThem)) {
//	if(validData()) {	
//		if (txtMaNV.getText().equals("") || txtHo.getText().equals("") || txtTenNV.getText().equals("")
//				|| txtTienLuong.getText().equals("") || txtTuoi.getText().equals("")) {
//			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!!");
//		} else {
//			NhanVien employee = createNewEmployee();
//			if (employee != null) {
//				if (lstNhanVien.addNhanVien(employee)) {
//					model.setRowCount(0); // Xoa cac row trong model
//					loadDataToTable(lstNhanVien.getLstNhanVien(), model);
//					JOptionPane.showMessageDialog(this, "Thêm thành công");
//					XoaTrang();
//					btnLuu.setEnabled(true);
//					btnXoa.setEnabled(true);
//					btnTim.setEnabled(true);
//				} else {
//					JOptionPane.showMessageDialog(this, "Trùng mã!");
//				}
//			}
//		}
//	}
//}
//public NhanVien createNewEmployee() {
//	NhanVien item;
//	String id, ho, ten, phai;
//	double tienLuong = 0;
//	int tuoi = 0;
//	id = txtMaNV.getText();
//	ho = txtHo.getText();
//	ten = txtTenNV.getText();
//	if (rdobtnNam.isSelected())
//		phai = "Nam";
//	else
//		phai = "Nữ";
//	try {
//		tienLuong = Double.parseDouble(txtTienLuong.getText());
//		if (tienLuong < 0) {
//			JOptionPane.showMessageDialog(this, "Tiền lương không được bé hơn 0!!");
//			return null;
//		}
//	} catch (Exception e) {
//		JOptionPane.showMessageDialog(this, "Tiền lương không hợp lệ!!");
//		return null;
//	}
//	try {
//		tuoi = Integer.parseInt(txtTuoi.getText());
//		if (tuoi < 0) {
//			JOptionPane.showMessageDialog(this, "Tuổi không được bé hơn 0!!");
//			return null;
//		}
//	} catch (Exception e) {
//		JOptionPane.showMessageDialog(this, "Tuổi không hợp lệ!!");
//		return null;
//	}
//	item = new NhanVien(id, ho, ten, phai, tuoi, tienLuong);
//	return item;
//}