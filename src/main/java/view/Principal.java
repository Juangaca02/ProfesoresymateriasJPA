package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.AsignaturaController;
import Controller.AsignaturaspordocenteController;
import Controller.DocenteController;
import model.Asignatura;
import model.Asignaturaspordocente;
import model.Docente;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

//	static {
//		utils.Apariencia.setAparienciasOrdenadas(utils.Apariencia.aparienciasOrdenadas);
//	}

	private JPanel contentPane;
	private JTextField jtfFiltrar;

	private static JComboBox<Docente> jcbDocente;
	private List<Asignatura> asignaturas = AsignaturaController.findAll();
	private List<Asignatura> asignaturasParaGuardar = new ArrayList<>();

	// Elemento JList a utilizar en el ejemplo
	private JList jlistAsignatura;
	// Modelo del elemento JList, necesario para que podamos c�modamente agregar y
	// eliminar elementos
	private DefaultListModel<Asignatura> listModelAsignatura = null;
	// Elemento JList a utilizar en el ejemplo
	private JList jlistAsignatura2;
	// Modelo del elemento JList, necesario para que podamos c�modamente agregar y
	// eliminar elementos
	private DefaultListModel<Asignatura> listModelAsignatura2 = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0 };
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Docentes y asignaturas ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		jtfFiltrar = new JTextField();
		jtfFiltrar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		contentPane.add(jtfFiltrar, gbc_textField);
		jtfFiltrar.setColumns(10);

		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarMunicipio();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		jcbDocente = new JComboBox<Docente>();
		jcbDocente.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 2;
		contentPane.add(jcbDocente, gbc_comboBox);

		JButton btnNewButton_1 = new JButton("Cargar materia");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverTodoIzquierda();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 2;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel_1 = new JLabel("Asignaturas no seleccionadas");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Asignaturas seleccionadas");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1_1.gridx = 2;
		gbc_lblNewLabel_1_1.gridy = 0;
		panel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		// La JList debe ir dentro de un ScrollPane, y se construye con el modelo de
		// JList sobre el que despues
		// se agregaran o eliminaran Estudiante.
		jlistAsignatura = new JList(this.getDefaultListModel());
		// Tipos de selecci�n disponibles en JList
		// this.jlistProvincias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// this.jlistProvincias.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.jlistAsignatura.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Valor por defecto

		// La JList debe ir dentro de un ScrollPane, y se construye con el modelo de
		// JList sobre el que despues
		// se agregaran o eliminaran Estudiante.
		jlistAsignatura2 = new JList(this.getDefaultListModel2());
		// Tipos de selecci�n disponibles en JList
		// this.jlistProvincias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// this.jlistProvincias.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.jlistAsignatura2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Valor por defecto

		JScrollPane scrollPane = new JScrollPane(jlistAsignatura);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JButton btnNewButton_2 = new JButton(">>");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverTodoDerecha();
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 0;
		panel_1.add(btnNewButton_2, gbc_btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton(">");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarSeleccionados();
			}
		});
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_2_1 = new GridBagConstraints();
		gbc_btnNewButton_2_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2_1.gridx = 0;
		gbc_btnNewButton_2_1.gridy = 1;
		panel_1.add(btnNewButton_2_1, gbc_btnNewButton_2_1);

		JButton btnNewButton_2_2 = new JButton("<");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarSeleccionados2();
			}
		});
		btnNewButton_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_2_2 = new GridBagConstraints();
		gbc_btnNewButton_2_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2_2.gridx = 0;
		gbc_btnNewButton_2_2.gridy = 2;
		panel_1.add(btnNewButton_2_2, gbc_btnNewButton_2_2);

		JButton btnNewButton_2_3 = new JButton("<<");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverTodoIzquierda();
			}
		});
		btnNewButton_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_2_3 = new GridBagConstraints();
		gbc_btnNewButton_2_3.gridx = 0;
		gbc_btnNewButton_2_3.gridy = 3;
		panel_1.add(btnNewButton_2_3, gbc_btnNewButton_2_3);

		JScrollPane scrollPane_1 = new JScrollPane(jlistAsignatura2);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 1;
		panel.add(scrollPane_1, gbc_scrollPane_1);

		JButton btnNewButton_3 = new JButton("Guardar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridwidth = 2;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 4;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);

	}

	private void guardar() {
		asignaturasParaGuardar.removeAll(asignaturasParaGuardar);
		for (int i = 0; i < listModelAsignatura2.size(); i++) {
			asignaturasParaGuardar.add(listModelAsignatura2.getElementAt(i));
		}
		for (Asignatura asignaturas : asignaturasParaGuardar) {
			Asignaturaspordocente as = AsignaturaspordocenteController.asignaturaPorDocente(asignaturas,
					(Docente) jcbDocente.getSelectedItem());
			if (as != null) {
				as.setDocente((Docente) jcbDocente.getSelectedItem());
				AsignaturaspordocenteController.update(as);
			} else {
				as = new Asignaturaspordocente();
				as.setAsignatura(asignaturas);
				as.setDocente((Docente) jcbDocente.getSelectedItem());
				AsignaturaspordocenteController.insert(as);
			}
		}
	}

	/**
	 * 
	 */
	private void cambiarSeleccionados() {
		List<Asignatura> l = jlistAsignatura.getSelectedValuesList();
		this.listModelAsignatura2.addAll(l);
		for (int i = this.jlistAsignatura.getSelectedIndices().length - 1; i >= 0; i--) {
			this.listModelAsignatura.removeElementAt(this.jlistAsignatura.getSelectedIndices()[i]);
		}
	}

	/**
	 * 
	 */
	private void cambiarSeleccionados2() {
		this.listModelAsignatura.addAll(jlistAsignatura2.getSelectedValuesList());
		for (int i = this.jlistAsignatura2.getSelectedIndices().length - 1; i >= 0; i--) {
			this.listModelAsignatura2.removeElementAt(this.jlistAsignatura2.getSelectedIndices()[i]);
		}
	}

	/**
	 * 
	 */
	private void moverTodoIzquierda() {
		listModelAsignatura2.removeAllElements();
		listModelAsignatura.removeAllElements();
		listModelAsignatura.addAll(asignaturas);
	}

	/**
	 * 
	 */
	private void moverTodoDerecha() {
		listModelAsignatura.removeAllElements();
		listModelAsignatura2.removeAllElements();
		listModelAsignatura2.addAll(asignaturas);
	}

	/**
	 * M�todo que construye el modelo de JList, a utilizar para agregar y eliminar
	 * provincias
	 */
	private DefaultListModel getDefaultListModel() {
		this.listModelAsignatura = new DefaultListModel<Asignatura>();
		return this.listModelAsignatura;
	}

	/**
	 * M�todo que construye el modelo de JList, a utilizar para agregar y eliminar
	 * provincias
	 */
	private DefaultListModel getDefaultListModel2() {
		this.listModelAsignatura2 = new DefaultListModel<Asignatura>();
		return this.listModelAsignatura2;
	}

	/**
	 * 
	 */
	private void llenarMunicipio() {
		try {
			jcbDocente.removeAllItems();
		} catch (Exception e) {
		}
		for (Docente m : DocenteController.findByNombre(jtfFiltrar.getText())) {
			jcbDocente.addItem(m);
		}
	}

//	private void cargarAsignaturasDocente() {
//	Asignatura a = (Asignatura) jcbDocente.getSelectedItem();
//	if (a != null) {
//		for (Asignatura ag : AsignaturaController.findByNombre(jtfFiltrar.getText())) {
//			jcbDocente.addItem(m);
//		}
//		
//		jlistAsignatura.getSelectedValues();
//		
//	}
//}

}
