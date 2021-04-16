package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import model.entities.Coche;
import model.entities.Fabricante;
import model.entities.controlers.ControladorCoche;
import model.entities.controlers.ControladorFabricante;

import java.awt.Insets;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelCoche extends JPanel {
	
	Coche actual = null;
	
	private JTextField jtfId;
	private JTextField jtfBastidor;
	private JTextField jtfModelo;
	private JTextField jtfColor;
	private JComboBox<Fabricante> jcbFabricante;
	


	/**
	 * Create the panel.
	 */
	public PanelCoche() {
		//Inicializar el el GridBagLayout y todas las variables necesarias
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//Etiqueta Id
		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		//TextField Id:
		jtfId = new JTextField();
		jtfId.setEnabled(false); //Deshabilitado
		jtfId.setEditable(false); //No editable
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		//Etiqueta Fabricante
		JLabel lblNewLabel_1 = new JLabel("Fabricante:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		//JComboBox / Desplegable de Fabricantes
		jcbFabricante = new JComboBox();
		GridBagConstraints gbc_jcbFabricante = new GridBagConstraints();
		gbc_jcbFabricante.insets = new Insets(0, 0, 5, 0);
		gbc_jcbFabricante.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbFabricante.gridx = 1;
		gbc_jcbFabricante.gridy = 1;
		add(jcbFabricante, gbc_jcbFabricante);
		
		//Etiqueta de Bastidor
		JLabel lblNewLabel_2 = new JLabel("Bastidor");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		//JTextField Bastidor
		jtfBastidor = new JTextField();
		GridBagConstraints gbc_jtfBastidor = new GridBagConstraints();
		gbc_jtfBastidor.insets = new Insets(0, 0, 5, 0);
		gbc_jtfBastidor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfBastidor.gridx = 1;
		gbc_jtfBastidor.gridy = 2;
		add(jtfBastidor, gbc_jtfBastidor);
		jtfBastidor.setColumns(10);
		
		//Etiqueta de Modelo
		JLabel lblNewLabel_3 = new JLabel("Modelo:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		//JTextField de modelo
		jtfModelo = new JTextField();
		GridBagConstraints gbc_jtfModelo = new GridBagConstraints();
		gbc_jtfModelo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfModelo.gridx = 1;
		gbc_jtfModelo.gridy = 3;
		add(jtfModelo, gbc_jtfModelo);
		jtfModelo.setColumns(10);
		
		//Etiqueta de color
		JLabel lblNewLabel_4 = new JLabel("Color:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		//JTextField de color
		jtfColor = new JTextField();
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 5, 0);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 4;
		add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);
		
		//Crear un nuevo panel al que se le dará un FlowLayout para colocar los botones
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//Botón de Nuevo
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaciarCampos();
			}
		});
		panel.add(btnNuevo);
		
		//Botón de Primero
		JButton btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorCoche.getInstance().findPrimero();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnPrimero);
		
		//Boton de Anterior
		JButton btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorCoche.getInstance().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnAnterior);
		
		//Boton de Guardar
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);
		
		//Botón de Siguiente
		JButton btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorCoche.getInstance().findSiguiente(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnSiguiente);
		
		//Botón de Último
		JButton btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorCoche.getInstance().findUltimo();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnUltimo);
		
		//Botón de Eliminar
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
		panel.add(btnEliminar);
		
		//Una vez todo colocado, cargar los datos de los fabricantes
		cargarDatosFabricantes();
		this.actual = ControladorCoche.getInstance().findPrimero(); //Encontrar el primero
		cargarActualEnPantalla(); //Y cargar en los JTextField los campos obtenidos

	}
	
	/**
	 * Método utilizado para asignar los valores del registro en el que se esté a los TextField 
	 * en pantalla
	 */
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			this.jtfId.setText("" + this.actual.getId());
			this.jtfBastidor.setText(this.actual.getBastidor());
			this.jtfModelo.setText(this.actual.getModelo());
			this.jtfColor.setText(this.actual.getColor());
			
			//Cargar los campos de fabricante
			for (int i = 0; i < this.jcbFabricante.getItemCount(); i++) {
				
				if (this.actual.getFabricante().getId() == this.jcbFabricante.getItemAt(i).getId()) {
					this.jcbFabricante.setSelectedIndex(i);
				}
			}
		}
	}
	
	/**
	 * Método utilizado para cargar todos los fabricantes en una lista
	 */
	private void cargarDatosFabricantes() {
		List<Fabricante> fabricantes = ControladorFabricante.getInstance().findAll();
		
		for (Fabricante f: fabricantes) {
			this.jcbFabricante.addItem(f);
		}
	}
	
	/**
	 * Método utilizado para cargar los campos del registro que haya como actual
	 */
	private void cargarActualDesdePantalla() {
		this.actual.setId(Integer.parseInt(jtfId.getText()));
		this.actual.setBastidor(jtfBastidor.getText());
		this.actual.setModelo(jtfModelo.getText());
		this.actual.setColor(jtfColor.getText());
		Fabricante f = (Fabricante) jcbFabricante.getSelectedItem();
		this.actual.setFabricante(f);
	}
	
	/**
	 * Método utilizado para guardar una vez se haya modificado o añadido un registro
	 */
	private void guardar() {
		//Primero comprobar qué registro hay en pantalla
		cargarActualDesdePantalla();
		//Comprobar que el registro se ha guardado correctamente
		boolean resultado = ControladorCoche.getInstance().guardar(this.actual);
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
		this.jtfBastidor.setText("");
		this.jtfModelo.setText("");
		this.jtfColor.setText("");
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
	    	ControladorCoche.getInstance().borrar(this.actual);
	    	vaciarCampos();
	    	JOptionPane.showMessageDialog(null, "Eliminado correctamente");	
	    }
	}
}
