package gui;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import model.entities.Fabricante;
import model.entities.controlers.ControladorFabricante;

import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelFabricantes extends JPanel {
	
	//Inicializar un objeto de tipo Fabricante como nulo, servirá para saber cual es el registro en el que se está
	Fabricante actual = null;

	private JPanel panel;
	private JTextField jtfId;
	private JTextField jtfCif;
	private JTextField jtfNombre;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JButton btnGuardar;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	private JButton btnEliminar;


	/**
	 * Create the application.
	 */
	public PanelFabricantes() {
		initialize();
		//Una vez inicializada la ventana buscar cual es el primer registro de la tabla fabricante
		this.actual = ControladorFabricante.getInstance().findPrimero();
		//A continuacion mostrar en pantalla los valores obtenidos de actual
		cargarActualEnPantalla();
	}

	/**
	 * Método utilizado para asignar los valores del registro en el que se esté a los TextField 
	 * en pantalla
	 */
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			this.jtfId.setText("" + this.actual.getId());
			this.jtfCif.setText(this.actual.getCif());
			this.jtfNombre.setText(this.actual.getNombre());
		}
	}
	
	/**
	 * 
	 */
	private void cargarActualDesdePantalla() {
		this.actual.setId(Integer.parseInt(jtfId.getText()));
		this.actual.setCif(jtfCif.getText());
		this.actual.setNombre(jtfNombre.getText());
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Inicialización JFrame con sus medidas y Layout
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		this.setLayout(gridBagLayout);
		
		//Etiqueta Id
		lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		this.add(lblNewLabel, gbc_lblNewLabel);
		
		//TextField de Id
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		this.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		//Etiqueta de Cif
		lblNewLabel_1 = new JLabel("Cif:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		this.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		//TextField de Cif
		jtfCif = new JTextField();
		GridBagConstraints gbc_jtfCif = new GridBagConstraints();
		gbc_jtfCif.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCif.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCif.gridx = 1;
		gbc_jtfCif.gridy = 1;
		this.add(jtfCif, gbc_jtfCif);
		jtfCif.setColumns(10);
		
		//Etiqueta de Nombre
		lblNewLabel_2 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		this.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		//TextField de Nombre
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		this.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		//Crear un nuevo panel al que se le dará un FlowLayout para colocar los botones
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		this.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//Botón de Nuevo
		btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaciarCampos();
			}
		});
		panel.add(btnNewButton);
		
		//Botón de Primero
		btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorFabricante.getInstance().findPrimero();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnPrimero);
		
		//Botón de Anterior
		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorFabricante.getInstance().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnAnterior);
		
		//Botón de Guardar
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);
		
		
		//Botón de Siguiente
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorFabricante.getInstance().findSiguiente(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnSiguiente);
		
		//Botón de Último
		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorFabricante.getInstance().findUltimo();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnUltimo);
		
		//Botón de Eliminar
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
		panel.add(btnEliminar);
		
	}
	
	/**
	 * Método utilizado para dos situaciones, guardar un registro modificado o guardar uno nuevo
	 */
	private void guardar() {
		cargarActualDesdePantalla();
		boolean resultado = ControladorFabricante.getInstance().guardar(this.actual);
		// Comprobar que se ha guardado correctamente
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
		this.jtfCif.setText("");
		this.jtfNombre.setText("");
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
	    	ControladorFabricante.getInstance().borrar(this.actual);
	    	vaciarCampos();
	    	JOptionPane.showMessageDialog(null, "Eliminado correctamente");
	    }
	}

}
