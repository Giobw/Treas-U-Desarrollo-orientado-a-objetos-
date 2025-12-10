package ui;

import data.GestorEntidades;
import model.Empleado;
import model.Proveedor;
import model.Direccion;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuGUI {

    private GestorEntidades gestor = new GestorEntidades();
    private JFrame ventanaPrincipal;

    public void iniciar() {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}

        ventanaPrincipal = new JFrame("Sistema de Gestión Salmontt");
        ventanaPrincipal.setSize(460, 650); // Un poco más alto para los nuevos campos
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setLayout(new BorderLayout());

        // --- ENCABEZADO ---
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(0, 102, 204));
        panelTitulo.setBorder(new EmptyBorder(20, 10, 20, 10));

        JLabel lblTitulo = new JLabel("SALMONTT APP");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        panelTitulo.add(lblTitulo);

        ventanaPrincipal.add(panelTitulo, BorderLayout.NORTH);

        // --- BOTONES ---
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 1, 15, 15));
        panelBotones.setBorder(new EmptyBorder(40, 60, 40, 60));

        JButton btnPersonal = crearBoton("Ingresar Personal");
        btnPersonal.addActionListener(e -> ingresarEmpleado());
        panelBotones.add(btnPersonal);

        JButton btnProveedor = crearBoton("Registrar Proveedor");
        btnProveedor.addActionListener(e -> ingresarProveedor());
        panelBotones.add(btnProveedor);

        JButton btnReporte = crearBoton("Ver Reporte General");
        btnReporte.addActionListener(e -> mostrarReporte());
        panelBotones.add(btnReporte);

        JButton btnSalir = crearBoton("Salir del Sistema");
        btnSalir.addActionListener(e -> System.exit(0));
        panelBotones.add(btnSalir);

        ventanaPrincipal.add(panelBotones, BorderLayout.CENTER);

        // --- PIE DE PÁGINA ---
        JLabel lblFooter = new JLabel("Versión 3.6 - Dirección Detallada", SwingConstants.CENTER);
        lblFooter.setBorder(new EmptyBorder(10, 10, 10, 10));
        lblFooter.setForeground(Color.GRAY);
        ventanaPrincipal.add(lblFooter, BorderLayout.SOUTH);

        ventanaPrincipal.setVisible(true);
    }

    private JButton crearBoton(String texto) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btn.setFocusPainted(false);
        btn.setBackground(Color.WHITE);
        return btn;
    }

    // --- FORMULARIO EMPLEADO ---
    private void ingresarEmpleado() {
        JTextField txtRut = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtApellidoPaterno = new JTextField();
        JTextField txtApellidoMaterno = new JTextField();

        String[] cargos = {"Operario de Centro", "Jefe de Centro", "Veterinario", "Administrativo", "Gerente Zonal"};
        JComboBox<String> comboCargos = new JComboBox<>(cargos);

        configurarCampo(txtRut);
        configurarCampo(txtNombre);
        configurarCampo(txtApellidoPaterno);
        configurarCampo(txtApellidoMaterno);
        comboCargos.setPreferredSize(new Dimension(200, 25));

        JPanel panelForm = new JPanel(new GridLayout(0, 2, 10, 10));
        panelForm.add(new JLabel("RUT (12345678-k):"));
        panelForm.add(txtRut);
        panelForm.add(new JLabel("Nombres:"));
        panelForm.add(txtNombre);
        panelForm.add(new JLabel("Primer Apellido:"));
        panelForm.add(txtApellidoPaterno);
        panelForm.add(new JLabel("Segundo Apellido:"));
        panelForm.add(txtApellidoMaterno);
        panelForm.add(new JLabel("Cargo:"));
        panelForm.add(comboCargos);

        JPanel panelContenedor = new JPanel(new BorderLayout());
        panelContenedor.add(panelForm, BorderLayout.NORTH);
        panelContenedor.setBorder(new EmptyBorder(10, 10, 10, 10));

        while (true) {
            int resultado = JOptionPane.showConfirmDialog(ventanaPrincipal, panelContenedor,
                    "Ingreso de Personal", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (resultado != JOptionPane.OK_OPTION) return;

            String rut = txtRut.getText().trim();
            String nombre = txtNombre.getText().trim();
            String paterno = txtApellidoPaterno.getText().trim();
            String materno = txtApellidoMaterno.getText().trim();

            if (rut.isEmpty() || nombre.isEmpty() || paterno.isEmpty()) {
                mostrarAlerta("Campos obligatorios: RUT, Nombre y Primer Apellido.", JOptionPane.WARNING_MESSAGE);
                continue;
            }

            if (!rut.matches("^[0-9]{7,8}-[0-9kK]{1}$")) {
                mostrarAlerta("RUT inválido. Use formato: 12345678-k", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            String apellidosUnidos = paterno + " " + materno;
            String cargoSeleccionado = (String) comboCargos.getSelectedItem();
            double sueldoCalculado = 0;
            switch (cargoSeleccionado) {
                case "Gerente Zonal": sueldoCalculado = 2500000; break;
                case "Jefe de Centro": sueldoCalculado = 1800000; break;
                case "Veterinario": sueldoCalculado = 1500000; break;
                case "Administrativo": sueldoCalculado = 850000; break;
                default: sueldoCalculado = 550000; break;
            }

            Direccion dir = new Direccion("Calle Planta", 100, "Puerto Montt", "Los Lagos");
            gestor.registrar(new Empleado(rut, nombre, apellidosUnidos.trim(), dir, cargoSeleccionado, sueldoCalculado));
            mostrarAlerta("Colaborador registrado exitosamente.", JOptionPane.INFORMATION_MESSAGE);
            break;
        }
    }

    // --- FORMULARIO PROVEEDOR ---
    private void ingresarProveedor() {
        JTextField txtEmpresa = new JTextField();
        JTextField txtRutEmpresa = new JTextField();
        JTextField txtGiro = new JTextField();

        // --- NUEVOS CAMPOS DE DIRECCIÓN ---
        JTextField txtCalle = new JTextField();
        JTextField txtNumero = new JTextField();
        JTextField txtComuna = new JTextField();
        JTextField txtRegion = new JTextField();

        JTextArea txtInfoProductos = new JTextArea(3, 20);
        JScrollPane scrollInfo = new JScrollPane(txtInfoProductos);

        configurarCampo(txtEmpresa);
        configurarCampo(txtRutEmpresa);
        configurarCampo(txtGiro);

        configurarCampo(txtCalle);
        configurarCampo(txtNumero);
        configurarCampo(txtComuna);
        configurarCampo(txtRegion);

        String[] serviciosReales = {
                "Suministro de Alimento",
                "Transporte Marítimo",
                "Mantenimiento de Redes",
                "Servicios Veterinarios",
                "Seguridad y Vigilancia",
                "Logística Terrestre"
        };
        JComboBox<String> comboServicios = new JComboBox<>(serviciosReales);
        comboServicios.setPreferredSize(new Dimension(200, 25));

        JPanel panelDatos = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Fila 0: Empresa
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.1; panelDatos.add(new JLabel("Empresa:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 1.0; panelDatos.add(txtEmpresa, gbc);

        // Fila 1: RUT
        gbc.gridx = 0; gbc.gridy = 1; panelDatos.add(new JLabel("RUT (77123456-k):"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; panelDatos.add(txtRutEmpresa, gbc);

        // Fila 2: Giro
        gbc.gridx = 0; gbc.gridy = 2; panelDatos.add(new JLabel("Giro:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; panelDatos.add(txtGiro, gbc);

        // --- SECCIÓN DIRECCIÓN DETALLADA ---
        // Separador visual pequeño
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        panelDatos.add(new JSeparator(), gbc);

        gbc.gridwidth = 1; // Volvemos a 1 columna

        // Fila 4: Calle
        gbc.gridx = 0; gbc.gridy = 4; panelDatos.add(new JLabel("Calle:"), gbc);
        gbc.gridx = 1; gbc.gridy = 4; panelDatos.add(txtCalle, gbc);

        // Fila 5: Número
        gbc.gridx = 0; gbc.gridy = 5; panelDatos.add(new JLabel("Número:"), gbc);
        gbc.gridx = 1; gbc.gridy = 5; panelDatos.add(txtNumero, gbc);

        // Fila 6: Comuna
        gbc.gridx = 0; gbc.gridy = 6; panelDatos.add(new JLabel("Comuna:"), gbc);
        gbc.gridx = 1; gbc.gridy = 6; panelDatos.add(txtComuna, gbc);

        // Fila 7: Región
        gbc.gridx = 0; gbc.gridy = 7; panelDatos.add(new JLabel("Región:"), gbc);
        gbc.gridx = 1; gbc.gridy = 7; panelDatos.add(txtRegion, gbc);

        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2;
        panelDatos.add(new JSeparator(), gbc);
        gbc.gridwidth = 1;

        // Fila 9: Servicio
        gbc.gridx = 0; gbc.gridy = 9; panelDatos.add(new JLabel("Servicio:"), gbc);
        gbc.gridx = 1; gbc.gridy = 9; panelDatos.add(comboServicios, gbc);


        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(panelDatos);

        panelMain.add(Box.createVerticalStrut(15));
        JLabel lblInfo = new JLabel("Información de productos de la empresa (Opcional):");
        lblInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblInfo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelMain.add(lblInfo);

        panelMain.add(Box.createVerticalStrut(5));
        panelMain.add(scrollInfo);

        JScrollPane mainScroll = new JScrollPane(panelMain);
        mainScroll.setBorder(null);
        mainScroll.setPreferredSize(new Dimension(480, 480));
        mainScroll.getVerticalScrollBar().setUnitIncrement(16);
        mainScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        while (true) {
            int resultado = JOptionPane.showConfirmDialog(ventanaPrincipal, mainScroll,
                    "Registro de Proveedores", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (resultado != JOptionPane.OK_OPTION) return;

            String empresa = txtEmpresa.getText().trim();
            String rut = txtRutEmpresa.getText().trim();
            String giro = txtGiro.getText().trim();


            String calle = txtCalle.getText().trim();
            String numeroStr = txtNumero.getText().trim();
            String comuna = txtComuna.getText().trim();
            String region = txtRegion.getText().trim();

            String servicio = (String) comboServicios.getSelectedItem();
            String infoExtra = txtInfoProductos.getText().trim();

            // Validar que todo esté lleno (menos infoExtra)
            if (empresa.isEmpty() || rut.isEmpty() || giro.isEmpty() ||
                    calle.isEmpty() || numeroStr.isEmpty() || comuna.isEmpty() || region.isEmpty()) {
                mostrarAlerta("Campos obligatorios incompletos.", JOptionPane.WARNING_MESSAGE);
                continue;
            }

            if (!rut.matches("^[0-9]{7,8}-[0-9kK]{1}$")) {
                mostrarAlerta("Error en RUT Empresa. Formato inválido.", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            // Validar que el número sea un número
            int numero = 0;
            try {
                numero = Integer.parseInt(numeroStr);
            } catch (NumberFormatException ex) {
                mostrarAlerta("El campo 'Número' debe ser numérico.", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            //Objeto Dirección con los datos separados
            Direccion dirProv = new Direccion(calle, numero, comuna, region);

            // Registramos
            gestor.registrar(new Proveedor(empresa, rut, giro, dirProv, servicio, infoExtra));
            mostrarAlerta("Proveedor registrado correctamente.", JOptionPane.INFORMATION_MESSAGE);
            break;
        }
    }

    private void mostrarReporte() {
        String reporte = gestor.generarReporte();
        JTextArea textArea = new JTextArea(reporte);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize( new Dimension( 500, 400 ) );
        JOptionPane.showMessageDialog(ventanaPrincipal, scrollPane, "Reporte Consolidado", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarAlerta(String mensaje, int tipoIcono) {
        JOptionPane.showMessageDialog(ventanaPrincipal, mensaje, "Sistema Salmontt", tipoIcono);
    }

    private void configurarCampo(JTextField campo) {
        campo.setPreferredSize(new Dimension(150, 25));
    }
}