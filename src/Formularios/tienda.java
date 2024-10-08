/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import java.sql.SQLException;
import javax.swing.ImageIcon;
import Clases.ConexionDB;
import static Clases.ConexionDB.con;
import Clases.Usuario;
import Clases.consultas;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Formularios.carrito;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 *
 * @author Vini
 */
public class tienda extends javax.swing.JFrame {

    /**
     * Creates new form tienda
     */
    public tienda() {

        initComponents();
        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calcular la posición central de la pantalla
        int x = (int) ((screenSize.getWidth() - this.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - this.getHeight()) / 2);

        // Establecer la posición central de la ventana
        this.setLocation(x, y);
        
        cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableProductos = new javax.swing.JTable();
        jbtnVolver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jlabel = new javax.swing.JLabel();
        jLabelImagen = new javax.swing.JLabel();
        btnCarrito = new javax.swing.JButton();
        btnVerCarrito = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(112, 145, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tienda");

        jtableProductos.setBackground(new java.awt.Color(112, 145, 255));
        jtableProductos.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jtableProductos.setForeground(new java.awt.Color(255, 255, 255));
        jtableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtableProductos.setColumnSelectionAllowed(true);
        jtableProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableProductos);
        jtableProductos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jbtnVolver.setBackground(new java.awt.Color(60, 78, 234));
        jbtnVolver.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jbtnVolver.setForeground(new java.awt.Color(255, 255, 255));
        jbtnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/previous.png"))); // NOI18N
        jbtnVolver.setText("Volver");
        jbtnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVolverActionPerformed(evt);
            }
        });

        txtDescripcion.setEditable(false);
        txtDescripcion.setBackground(new java.awt.Color(112, 145, 255));
        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setBorder(null);
        txtDescripcion.setCaretColor(new java.awt.Color(112, 145, 255));
        txtDescripcion.setFocusable(false);
        txtDescripcion.setHighlighter(null);
        jScrollPane2.setViewportView(txtDescripcion);

        txtId.setBackground(new java.awt.Color(112, 145, 255));
        txtId.setForeground(new java.awt.Color(112, 145, 255));
        txtId.setBorder(null);

        jLabel2.setBackground(new java.awt.Color(112, 145, 255));
        jLabel2.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Código :");

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(112, 145, 255));
        txtCodigo.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(255, 255, 255));
        txtCodigo.setBorder(null);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        txtNombre.setEditable(false);
        txtNombre.setBackground(new java.awt.Color(112, 145, 255));
        txtNombre.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(null);

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(112, 145, 255));
        jLabel3.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Producto: ");

        txtPrecio.setEditable(false);
        txtPrecio.setBackground(new java.awt.Color(112, 145, 255));
        txtPrecio.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(255, 255, 255));
        txtPrecio.setBorder(null);

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(112, 145, 255));
        jLabel4.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio:");

        txtStock.setEditable(false);
        txtStock.setBackground(new java.awt.Color(112, 145, 255));
        txtStock.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        txtStock.setForeground(new java.awt.Color(255, 255, 255));
        txtStock.setBorder(null);

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(112, 145, 255));
        jLabel5.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Stock:");

        jlabel.setBackground(new java.awt.Color(112, 145, 255));
        jlabel.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jlabel.setForeground(new java.awt.Color(255, 255, 255));
        jlabel.setText("Detalles:");

        btnCarrito.setBackground(new java.awt.Color(60, 78, 234));
        btnCarrito.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        btnCarrito.setForeground(new java.awt.Color(255, 255, 255));
        btnCarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carrito.png"))); // NOI18N
        btnCarrito.setText("Añadir al carrito");
        btnCarrito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarritoActionPerformed(evt);
            }
        });

        btnVerCarrito.setBackground(new java.awt.Color(60, 78, 234));
        btnVerCarrito.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        btnVerCarrito.setForeground(new java.awt.Color(255, 255, 255));
        btnVerCarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pagar.png"))); // NOI18N
        btnVerCarrito.setText("  Ir al carrito");
        btnVerCarrito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerCarritoActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(112, 145, 255));
        jLabel6.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Cantidad:");

        txtCantidad.setBackground(new java.awt.Color(112, 145, 255));
        txtCantidad.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(255, 255, 255));
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidad.setBorder(null);

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));

        btnEditar.setBackground(new java.awt.Color(60, 78, 234));
        btnEditar.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Perfil de Usuario");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(249, 249, 249))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbtnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(156, 156, 156)
                                .addComponent(btnEditar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator1)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator3)
                                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator4)
                                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(221, 221, 221)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(jSeparator5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(btnCarrito))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlabel)
                        .addGap(343, 343, 343)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnVerCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(21, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlabel)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCarrito)))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnVolver)
                    .addComponent(btnVerCarrito)
                    .addComponent(btnEditar))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolverActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        panelUsuario pu = new panelUsuario();
        pu.setVisible(true);
    }//GEN-LAST:event_jbtnVolverActionPerformed

    private void jtableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableProductosMouseClicked
        try {

            int fila = jtableProductos.getSelectedRow();
            int id = Integer.parseInt(jtableProductos.getValueAt(fila, 0).toString());

            ConexionDB db = new ConexionDB();
            Connection con = db.conectar();
            PreparedStatement ps;
            ps = con.prepareCall("SELECT id, codigo, nombre, precio, stock, imagen, descripcion FROM productos WHERE id=?");
            ps.setInt(1, id);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {

                txtId.setText(resultado.getString("id"));
                txtCodigo.setText(resultado.getString("codigo"));
                txtNombre.setText(resultado.getString("nombre"));
                txtPrecio.setText(resultado.getString("precio"));
                txtStock.setText(resultado.getString("stock"));
                txtDescripcion.setText(resultado.getString("descripcion"));
                txtCantidad.setText("1");

                // Recupera la imagen de la base de datos
                String rutaImagen = resultado.getString("imagen");
                if (rutaImagen != null) {
                    ImageIcon icono = new ImageIcon(rutaImagen);
                    Image image = icono.getImage(); // obtener la imagen
                    Image newImage = image.getScaledInstance(256, 256, java.awt.Image.SCALE_SMOOTH); // redimensionar la imagen
                    icono = new ImageIcon(newImage); // crear un nuevo ImageIcon con la imagen redimensionada
                    jLabelImagen.setIcon(icono);
                } else {
                    jLabelImagen.setIcon(null);
                }

            }

        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jtableProductosMouseClicked

    private void btnCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarritoActionPerformed
        // TODO add your handling code here:

        //PRUEBA CON USUARIO LOGEADO
        Usuario user = consultas.getUsuarioLogueado();
        int usuarioId = user.getId();

        try {
            int fila = jtableProductos.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Selecciona un producto para añadirlo al carrito");
                return;
            }

            int codigo = Integer.parseInt(jtableProductos.getValueAt(fila, 0).toString());

            ConexionDB db = new ConexionDB();
            Connection con = db.conectar();

            // Busca el producto en la tabla carrito por código y usuario
            PreparedStatement ps = con.prepareStatement("SELECT * FROM carrito WHERE codigo = ? AND id_usuario = ?");
            ps.setInt(1, codigo);
            ps.setInt(2, usuarioId);
            ResultSet rs = ps.executeQuery();

            // Si el producto ya existe en la tabla carrito, actualiza la cantidad en esa fila
            if (rs.next()) {
                int cantidadActual = rs.getInt("cantidad");
                int nuevaCantidad = cantidadActual + Integer.parseInt(txtCantidad.getText());

                // Actualiza la cantidad en la tabla carrito
                ps = con.prepareStatement("UPDATE carrito SET cantidad = ? WHERE codigo = ? AND id_usuario = ?");
                ps.setInt(1, nuevaCantidad);
                ps.setInt(2, codigo);
                ps.setInt(3, usuarioId);
                ps.executeUpdate();

                // Actualiza el Stock de la tabla productos
                int stock = Integer.parseInt(txtStock.getText());
                int newStock = stock - Integer.parseInt(txtCantidad.getText());
                ps = con.prepareStatement("UPDATE productos SET stock = ? WHERE id = ?");
                ps.setInt(1, newStock);
                ps.setInt(2, Integer.parseInt(jtableProductos.getValueAt(fila, 0).toString()));
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "El producto se ha añadido al carrito");

            } // Si el producto no existe en la tabla carrito, agrega una nueva fila con los datos del producto y el usuario
            else {
                ps = con.prepareStatement("INSERT INTO carrito (id_usuario, codigo, nombre, precio, cantidad) VALUES (?,?,?,?,?)");
                ps.setInt(1, usuarioId);
                ps.setInt(2, codigo);
                ps.setString(3, txtNombre.getText());
                ps.setDouble(4, Double.parseDouble(txtPrecio.getText()));

                int cantidad = Integer.parseInt(txtCantidad.getText());
                int stock = Integer.parseInt(txtStock.getText());

                // Verifica que la cantidad seleccionada no sea mayor al stock disponible
                if (cantidad > stock) {
                    JOptionPane.showMessageDialog(null, "La cantidad seleccionada es mayor al stock disponible");
                    return;
                }

                ps.setInt(5, cantidad);

                int resultado = ps.executeUpdate();

                // Actualiza el Stock de la tabla productos
                int newStock = stock - cantidad;
                ps = con.prepareStatement("UPDATE productos SET stock = ? WHERE id = ?");
                ps.setInt(1, newStock);
                ps.setInt(2, codigo);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "El producto se ha añadido al carrito");
            }

            limpiar();
            cargarTabla();
            desconectar();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }

    }//GEN-LAST:event_btnCarritoActionPerformed

    private void btnVerCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerCarritoActionPerformed
        // TODO add your handling code here:

        carrito cart = new carrito(consultas.getUsuarioLogueado());
        cart.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnVerCarritoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        perfilUsuario e2 = new perfilUsuario(consultas.getUsuarioLogueado());
        e2.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            // Log the exception or display a meaningful error message
            System.out.println(ex.getMessage());
        }
    }

    private void limpiar() {

        txtId.setText("");
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        txtDescripcion.setText(" ");
        jLabelImagen.setIcon(null);

    }

    private void cargarTabla() {

        try {

            DefaultTableModel modelo = new DefaultTableModel();
            jtableProductos.setModel(modelo);

            ConexionDB db = new ConexionDB();
            Connection con = db.conectar();
            PreparedStatement ps;
            ps = con.prepareCall("SELECT id, codigo, nombre, precio, stock FROM productos");
            ResultSet resultado = ps.executeQuery();
            ResultSetMetaData rsmta = resultado.getMetaData();

            int columnas = rsmta.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");

            int[] ancho = {20, 100, 150};

            for (int a = 0; a < jtableProductos.getColumnCount(); a++) {
                jtableProductos.getColumnModel().getColumn(a).setPreferredWidth(ancho[a]);

            }

            while (resultado.next()) {

                Object[] filas = new Object[columnas];
                for (int b = 0; b < columnas; b++) {

                    filas[b] = resultado.getObject(b + 1);

                }

                modelo.addRow(filas);

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.toString());

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // create a new Session object and pass it to the tienda constructor
                new tienda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarrito;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnVerCarrito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton jbtnVolver;
    private javax.swing.JLabel jlabel;
    private javax.swing.JTable jtableProductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
