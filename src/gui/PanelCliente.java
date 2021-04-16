package gui;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import model.entities.Cliente;
import model.entities.controlers.ControladorCliente;
import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class PanelCliente extends JPanel {
	
	Cliente actual = null;

	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfApellidos;
	private JTextField jtfLocalidad;
	private JTextField jtfDni;
	private JTextField jtfFecha;
	private JLabel lblNewLabel_6;
	private JPanel panel;
	private JButton btnNuevo;
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JButton btnGuardar;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	private JButton btnEliminar;
	private JCheckBox cbxActivo;
	
	private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");

	/**
	 * Create the application.
	 */
	public PanelCliente() {
		initialize();
	}

	/**
	 * Método utilizado para asignar los valores del registro en el que se esté a los TextField 
	 * en pantalla
	 */
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			this.jtfId.setText("" + this.actual.getId());
			this.jtfNombre.setText(this.actual.getNombre());
			this.jtfApellidos.setText(this.actual.getApellidos());
			this.jtfLocalidad.setText(this.actual.getLocalidad());
			this.jtfDni.setText(this.actual.getDniNie());
			this.jtfFecha.setText("" + this.formatoFecha.format(this.actual.getFechaNac()));
			this.cbxActivo.setSelected(this.actual.getActivo());
		}
	}
	
	/**
	 * 
	 */
	private void cargarActualDesdePantalla() {
		this.actual.setId(Integer.parseInt(jtfId.getText()));
		this.actual.setNombre(jtfNombre.getText());
		this.actual.setApellidos(jtfApellidos.getText());
		this.actual.setLocalidad(jtfLocalidad.getText());
		this.actual.setDniNie(jtfDni.getText());
		try {
			this.actual.setFechaNac(this.formatoFecha.parse(this.jtfFecha.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.actual.setActivo(cbxActivo.isSelected());
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		this.setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		this.add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false); //Deshabilitado
		jtfId.setEditable(false); //No editable
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		this.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		this.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 1;
		this.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		this.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfApellidos = new JTextField();
		GridBagConstraints gbc_jtfApellidos = new GridBagConstraints();
		gbc_jtfApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellidos.gridx = 1;
		gbc_jtfApellidos.gridy = 2;
		this.add(jtfApellidos, gbc_jtfApellidos);
		jtfApellidos.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Localidad:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		this.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfLocalidad = new JTextField();
		GridBagConstraints gbc_jtfLocalidad = new GridBagConstraints();
		gbc_jtfLocalidad.insets = new Insets(0, 0, 5, 0);
		gbc_jtfLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLocalidad.gridx = 1;
		gbc_jtfLocalidad.gridy = 3;
		this.add(jtfLocalidad, gbc_jtfLocalidad);
		jtfLocalidad.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Dni:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		this.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfDni = new JTextField();
		jtfDni.setText("");
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 4;
		this.add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("FechaNac:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		this.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 5;
		this.add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Activo:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		this.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		cbxActivo = new JCheckBox("Está activo");
		GridBagConstraints gbc_cbxActivo = new GridBagConstraints();
		gbc_cbxActivo.insets = new Insets(0, 0, 5, 0);
		gbc_cbxActivo.gridx = 1;
		gbc_cbxActivo.gridy = 6;
		add(cbxActivo, gbc_cbxActivo);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 7;
		this.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaciarCampos();
			}
		});
		panel.add(btnNuevo);
		
		btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorCliente.getInstance().findPrimero();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnPrimero);
		
		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorCliente.getInstance().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnAnterior);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorCliente.getInstance().findSiguiente(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnSiguiente);
		
		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorCliente.getInstance().findUltimo();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnUltimo);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
		panel.add(btnEliminar);
		
		this.actual = ControladorCliente.getInstance().findPrimero(); //Encontrar el primero
		cargarActualEnPantalla(); //Y cargar en los JTextField los campos obtenidos
	}

	/**
	 * Método utilizado para dos situaciones, guardar un registro modificado o guardar uno nuevo
	 */
	private void guardar() {
		//Primero comprobar qué registro hay en pantalla
		cargarActualDesdePantalla();
		//Comprobar que el registro se ha guardado correctamente
		boolean resultado = ControladorCliente.getInstance().guardar(this.actual);
		if (resultado == true && this.actual != null && this.actual.getId() > 0) {
			this.jtfId.setText("" + this.actual.getId());
			JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "Error al guardar");
		}
	}
	
	/**
	 * Método utilizado para vaciar los campos de los JTextField para poder añadir uno nuevo
	 */
	private void vaciarCampos() {
		this.jtfId.setText("0");
		this.jtfNombre.setText("");
		this.jtfApellidos.setText("");
		this.jtfLocalidad.setText("");
		this.jtfDni.setText("");
		this.jtfFecha.setText("");
		this.cbxActivo.setSelected(false);
	}
	
	/**
	 * Método utilizado para borrar un registro
	 */
	private void borrar() {
		String posiblesRespuestas[] = {"Sí","No"};
		// En esta opción se utiliza un showOptionDialog en el que personalizo el icono mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Desea eliminar?", "Gestión venta de coches", 
		        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas, posiblesRespuestas[1]);
	    if(opcionElegida == 0) {
	    	//Si se elige la primera opción "Sí" 
	    	ControladorCliente.getInstance().borrar(this.actual);
	    	vaciarCampos();
	    	JOptionPane.showMessageDialog(null, "Eliminado correctamente");
	    }
	}
}
