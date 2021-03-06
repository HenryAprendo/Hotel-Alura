package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;

import com.data.jdbc.controller.ReservaController;
import com.data.jdbc.modelo.Reserva;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


@SuppressWarnings("serial")
public class Reservas extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;
	private JDateChooser txtFechaE;
	private JDateChooser txtFechaS;
	private JComboBox txtFormaPago;
	private Integer valorPagar;
	private int COSTO_HABITACION = 30;
	
	private ReservaController reservaController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservas frame = new Reservas();
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
	public Reservas() {
		
		this.reservaController = new ReservaController();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reservas.class.getResource("/imagenes/calendario.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 540);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245,245,245));
		panel.setBounds(0, 0, 900, 502);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtFechaE = new JDateChooser();
		txtFechaE.setDateFormatString("yyyy-MM-dd");
		txtFechaE.setBounds(88, 166, 235, 33);
		panel.add(txtFechaE);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de Check In");
		lblNewLabel_1.setBounds(88, 142, 133, 14);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha de Check Out");
		lblNewLabel_1_1.setBounds(88, 210, 133, 14);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_1);
		
		txtFechaS = new JDateChooser();
		txtFechaS.setDateFormatString("yyyy-MM-dd");
		txtFechaS.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				calcularNumeroDias(txtFechaE, txtFechaS);
			}
		});
		
		txtFechaS.setBounds(88, 234, 235, 33);
		txtFechaS.getCalendarButton().setBackground(Color.WHITE);
		panel.add(txtFechaS);
		
		txtValor = new JTextField();
		txtValor.setBounds(88, 303, 235, 33);
		txtValor.setEnabled(false);
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Valor de la Reserva");
		lblNewLabel_1_1_1.setBounds(88, 278, 133, 14);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_1_1);
		
		txtFormaPago = new JComboBox();
		txtFormaPago.setBounds(88, 373, 235, 33);
		txtFormaPago.setFont(new Font("Arial", Font.PLAIN, 14));
		txtFormaPago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta de Cr??dito", "Tarjeta de D??bito", "Dinero en efectivo"}));
		panel.add(txtFormaPago);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Forma de pago");
		lblNewLabel_1_1_1_1.setBounds(88, 347, 133, 24);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Sistema de Reservas");
		lblNewLabel_4.setBounds(108, 93, 199, 42);
		lblNewLabel_4.setForeground(new Color(65, 105, 225));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblNewLabel_4);
		
		JButton btnReservar = new JButton("Continuar");
		btnReservar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
								
				String idReserva = guardar();
				
				RegistroHuesped huesped = new RegistroHuesped();
				huesped.txtNreserva.setText(idReserva);
				huesped.setVisible(true);
				dispose();
			}
		});
		btnReservar.setForeground(Color.WHITE);
		btnReservar.setBounds(183, 436, 140, 33);
		btnReservar.setIcon(new ImageIcon(Reservas.class.getResource("/imagenes/calendario.png")));
		btnReservar.setBackground(new Color(65,105,225));
		btnReservar.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(btnReservar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(399, 0, 491, 502);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, -16, 500, 539);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(Reservas.class.getResource("/imagenes/reservas-img-2.png")));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Reservas.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(15, 6, 104, 107);
		panel.add(lblNewLabel_2);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	
	private String guardar() {
		String idReserva = "";
		
		if (txtFechaE.getDate() != null && txtFechaS.getDate() != null ) {
			String fechaEntrada = ((JTextField) txtFechaE.getDateEditor().getUiComponent()).getText();
			String fechaSalida = ((JTextField) txtFechaS.getDateEditor().getUiComponent()).getText();
			
			String selectedItem = (String) txtFormaPago.getSelectedItem();
			
			Reserva reserva = new Reserva(java.sql.Date.valueOf(fechaEntrada), java.sql.Date.valueOf(fechaSalida), selectedItem, valorPagar);
			idReserva = reserva.getidReserva();
			
			this.reservaController.guardar(reserva);
			JOptionPane.showMessageDialog(contentPane,"Registro guardado satisfactoriamente");
			limpiar();
			
			
		}
		else {
			JOptionPane.showMessageDialog(contentPane,"Debes llenar los campos de fechas");
		}
		return idReserva;
	}
	
	private void limpiar() {
		this.txtFormaPago.setSelectedIndex(0);
		this.txtValor.setText("");
		this.txtFechaE.setCalendar(null);
		this.txtFechaS.setCalendar(null);
	}
	
	
	
	private void calcularNumeroDias(JDateChooser fechaE, JDateChooser fechaS) {
		int numeroDeDias = 0;
		if(fechaE.getDate() != null && fechaS.getDate() != null) {
			Calendar in = fechaE.getCalendar();
			Calendar out = fechaS.getCalendar();
			
			int dia = in.get(Calendar.DAY_OF_MONTH);
			int mes = in.get(Calendar.MONTH);
			
			int dia2 = out.get(Calendar.DAY_OF_MONTH);
			int mes2 = out.get(Calendar.MONTH);
						
			if (mes == mes2) {
				System.out.println("fechas del mismo mes");
				numeroDeDias = dia2 - dia;			}
			else {
				System.out.println("fechas de meses diferentes");
				//mismo mes
				int diaMaximo = lastDayOfMonth(mes);
				numeroDeDias = diaMaximo - dia;
				
				int d = mes2 - mes;
				
				if (d > 1) {
					while(d != 1) {
						System.out.println(d);
						numeroDeDias += lastDayOfMonth(d);
						d--;
					}
				}	
				
				numeroDeDias += dia2;				
			}
		}
		
		valorPagar = numeroDeDias * COSTO_HABITACION;
		
		if (txtValor != null) {
			txtValor.setText("" + valorPagar);
		}
		
	}
	
	
	private Integer lastDayOfMonth(Integer month) {
		int d = 0;
		switch (month) {
									
			case 0:
			case 2:
			case 4:
			case 6:
			case 7:
			case 9:
			case 11:	
				d = 31;
				break;
				
			case 3:
			case 5:
			case 8:
			case 10: 
				d = 30;
				break;
				
			case 1: 
				d = 28;
				break;
				
		}
		
		return d;
	}
	
}




















