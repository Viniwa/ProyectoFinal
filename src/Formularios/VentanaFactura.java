/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

/**
 *
 * @author Vini
 */
import Clases.ConexionDB;
import com.itextpdf.text.Chunk;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import com.itextpdf.text.pdf.PdfPCell;

public class VentanaFactura extends javax.swing.JFrame {

    /**
     * Creates new form VentanaFactura
     */
    private int idFactura;
    private JLabel jLabelFecha;
    private JLabel jLabelTotal;
    private JLabel jLabelCliente;
    private JLabel jLabelDireccion;
    private JLabel jLabelTelefono;
    private JLabel jLabelEmail;
    private JTable jTableProductos;
    private DefaultTableModel modeloProductos;

    public VentanaFactura(int idFactura) {
        this.idFactura = idFactura;
        initComponents();
        cargarDatosFactura();
        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calcular la posición central de la pantalla
        int x = (int) ((screenSize.getWidth() - this.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - this.getHeight()) / 2);

        // Establecer la posición central de la ventana
        this.setLocation(x, y);
    }

    private void initComponents() {
        jLabelFecha = new JLabel();
        jLabelTotal = new JLabel();
        jLabelCliente = new JLabel();
        jLabelDireccion = new JLabel();
        jLabelTelefono = new JLabel();
        jLabelEmail = new JLabel();
        jTableProductos = new JTable();
        modeloProductos = new DefaultTableModel();
        modeloProductos.addColumn("ID Producto");
        modeloProductos.addColumn("Nombre Producto");
        modeloProductos.addColumn("Cantidad");
        modeloProductos.addColumn("Precio Unidad");
        jTableProductos.setModel(modeloProductos);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel panelNorte = new JPanel();
        panelNorte.setLayout(new GridLayout(3, 1));
        panelNorte.add(jLabelFecha);
        panelNorte.add(jLabelTotal);
        panelNorte.add(jLabelCliente);
        panelNorte.add(jLabelDireccion);
        panelNorte.add(jLabelTelefono);
        panelNorte.add(jLabelEmail);

        panel.add(panelNorte, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(jTableProductos);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton jButtonGuardarTxt = new JButton("Generar Factura");
        jButtonGuardarTxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarFacturaComoPdf();
            }
        });
        panel.add(jButtonGuardarTxt, BorderLayout.SOUTH);

        add(panel);

        pack();
    }

    private void guardarFacturaComoPdf() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar factura como archivo PDF");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setSelectedFile(new File("factura_" + idFactura + ".pdf"));

        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                // Crear un documento PDF
                Document document = new Document();
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(selectedFile));
                document.open();

                // Agregar número de factura en la esquina superior derecha
                Paragraph numeroFactura = new Paragraph("Nº Factura: " + idFactura);
                numeroFactura.setAlignment(Element.ALIGN_RIGHT);
                document.add(numeroFactura);

                // Agregar título de la factura
                Font font = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD);
                Chunk tituloChunk = new Chunk("FACTURA", font);
                tituloChunk.setUnderline(0.1f, -2);
                Paragraph titulo = new Paragraph(tituloChunk);
                titulo.setAlignment(Element.ALIGN_CENTER);
                titulo.setSpacingBefore(20); // Agregar un margen antes del título
                titulo.setSpacingAfter(10); // Agregar un margen después del título
                document.add(titulo);

                // Agregar datos del cliente
                font = new Font(Font.FontFamily.HELVETICA, 12);
                Paragraph cliente = new Paragraph(jLabelCliente.getText(), font);
                cliente.setAlignment(Element.ALIGN_LEFT);
                document.add(cliente);

                cliente = new Paragraph(jLabelDireccion.getText(), font);
                cliente.setAlignment(Element.ALIGN_LEFT);
                document.add(cliente);

                cliente = new Paragraph(jLabelTelefono.getText(), font);
                cliente.setAlignment(Element.ALIGN_LEFT);
                document.add(cliente);

                cliente = new Paragraph(jLabelEmail.getText(), font);
                cliente.setAlignment(Element.ALIGN_LEFT);
                document.add(cliente);

                // Agregar fecha de la factura
                cliente = new Paragraph(jLabelFecha.getText(), font);
                cliente.setAlignment(Element.ALIGN_LEFT);
                document.add(cliente);

                // Agregar espacio hacia abajo
                document.add(new Paragraph(""));

                // Agregar tabla con los productos
                PdfPTable table = new PdfPTable(4);
                table.setWidths(new int[]{1, 3, 1, 1}); // Ancho de las columnas
                table.addCell("Código");
                table.addCell("Nombre Producto");
                table.addCell("Cantidad");
                table.addCell("Precio/U");

                for (int i = 0; i < modeloProductos.getRowCount(); i++) {
                    table.addCell(modeloProductos.getValueAt(i, 0).toString());
                    table.addCell(modeloProductos.getValueAt(i, 1).toString());
                    table.addCell(modeloProductos.getValueAt(i, 2).toString());
                    table.addCell(modeloProductos.getValueAt(i, 3).toString());
                }

                // Establecer el espacio en blanco antes de la tabla
                table.setSpacingBefore(20); // Espacio en blanco de 20 puntos

                // Calcular el total
                double total = 0;
                for (int i = 0; i < modeloProductos.getRowCount(); i++) {
                    double cantidad = Double.parseDouble(modeloProductos.getValueAt(i, 2).toString());
                    double precio = Double.parseDouble(modeloProductos.getValueAt(i, 3).toString());
                    total += cantidad * precio;
                }

                // Agregar fila con el total
                PdfPCell cell = new PdfPCell(new Phrase("Total"));
                cell.setColspan(3); // Ocupa 3 celdas
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.format("%.2f", total) + " €"));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                // Centrar la tabla
                table.setHorizontalAlignment(Element.ALIGN_CENTER);

                document.add(table);

                // Agregar espacio hacia abajo
                document.add(new Paragraph(""));

                //Datos de la empresa
                String nombreEmpresa = "Mi Empresa";
                String cifEmpresa = "12345678A";
                String direccionEmpresa = "Calle Principal, 1";
                String telefonoEmpresa = "912345678";

                // Crear una tabla para los datos de la empresa
                PdfPTable tablaDatosEmpresa = new PdfPTable(1);
                tablaDatosEmpresa.setTotalWidth(document.getPageSize().getWidth());
                tablaDatosEmpresa.setWidthPercentage(100);
                tablaDatosEmpresa.getDefaultCell().setBorderWidth(0);

                // Agregar los datos de la empresa a la tabla
                tablaDatosEmpresa.addCell("Nombre: " + nombreEmpresa);
                tablaDatosEmpresa.addCell("CIF: " + cifEmpresa);
                tablaDatosEmpresa.addCell("Dirección: " + direccionEmpresa);
                tablaDatosEmpresa.addCell("Teléfono: " + telefonoEmpresa);

                // Agregar la tabla al documento en la esquina inferior izquierda
                document.setPageSize(PageSize.A4);
                document.setMargins(36, 36, 36, 36); // Margen inferior de 36 puntos
                PdfContentByte cb = writer.getDirectContent();
                cb.saveState();
                cb.rectangle(36, 100, 550, 50); // Coordenadas x, y, ancho, alto
                cb.restoreState();
                writer.getDirectContent().beginText();
                writer.getDirectContent().setFontAndSize(BaseFont.createFont("Helvetica", "Cp1252", false), 10);
                writer.getDirectContent().setTextMatrix(36, 100);
                writer.getDirectContent().showText(" ");
                writer.getDirectContent().endText();
                tablaDatosEmpresa.writeSelectedRows(0, -1, 36, 100, writer.getDirectContent());

                // Cerrar el documento PDF
                document.close();

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this, "Factura guardada como archivo PDF en " + selectedFile.getAbsolutePath());
            } catch (DocumentException | IOException e) {
                System.out.println("Error al guardar archivo PDF: " + e.getMessage());
            }
        }
    }

    private void cargarDatosFactura() {
        // Realizar la consulta para obtener los datos de la factura
        ConexionDB conexionDB = new ConexionDB();
        Connection con = conexionDB.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query = "SELECT * FROM facturas WHERE id_facturas =?";
            ps = con.prepareStatement(query);
            ps.setInt(1, idFactura);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Cargar los datos de la factura
                String fecha = rs.getString("fecha");
                double total = rs.getDouble("total");
                int idCliente = rs.getInt("id_usuario");

// Realizar consulta adicional para obtener los datos del cliente
                String queryCliente = "SELECT * FROM usuarios WHERE id = ?";
                PreparedStatement psCliente = con.prepareStatement(queryCliente);
                psCliente.setInt(1, idCliente);
                ResultSet rsCliente = psCliente.executeQuery();

                if (rsCliente.next()) {
                    String nombreCliente = rsCliente.getString("nombre");
                    String apellidoCliente = rsCliente.getString("apellidos");
                    String direccionCliente = rsCliente.getString("direccion");
                    String ciudad = rsCliente.getString("ciudad");
                    String provincia = rsCliente.getString("provincia");
                    String c_postal = rsCliente.getString("c_postal");
                    String telefonoCliente = rsCliente.getString("telefono");
                    String emailCliente = rsCliente.getString("correo");

                    // Mostrar los datos del cliente en la ventana
                    jLabelCliente.setText("Cliente: " + nombreCliente + " " + apellidoCliente);
                    // Agregar los demás campos que desees mostrar
                    jLabelDireccion.setText("Dirección: " + direccionCliente + ", " + ciudad + ", " + provincia + ", " + c_postal);
                    jLabelTelefono.setText("Teléfono: " + telefonoCliente);
                    jLabelEmail.setText("Email: " + emailCliente);
                }

                // Cerrar el ResultSet y el PreparedStatement
                rsCliente.close();
                psCliente.close();

                // Cargar los productos asociados a la factura
                query = "SELECT * FROM detalle_factura WHERE id_factura =?";
                ps = con.prepareStatement(query);
                ps.setInt(1, idFactura);
                rs = ps.executeQuery();

                while (rs.next()) {
                    int idProducto = rs.getInt("codigo_producto");
                    int cantidad = rs.getInt("cantidad");
                    double precio = rs.getDouble("precio_unitario");

                    // Realizar consulta adicional para obtener el nombre del producto
                    String queryProducto = "SELECT nombre FROM productos WHERE codigo = ?";
                    PreparedStatement psProducto = con.prepareStatement(queryProducto);
                    psProducto.setInt(1, idProducto);
                    ResultSet rsProducto = psProducto.executeQuery();

                    while (rsProducto.next()) {
                        String nombreProducto = rsProducto.getString("nombre");

                        // Agregar la fila a la tabla de productos
                        modeloProductos.addRow(new Object[]{idProducto, nombreProducto, cantidad, precio});
                    }

                    // Cerrar el ResultSet y el PreparedStatement
                    rsProducto.close();
                    psProducto.close();
                }

                // Mostrar los datos de la factura en la ventana
                jLabelFecha.setText("Fecha: " + fecha);
                jLabelTotal.setText("Total: " + total + "€");
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar datos de la factura: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    /*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
*/
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
            java.util.logging.Logger.getLogger(VentanaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaFactura ventana = new VentanaFactura(1); // Cambiar el ID de la factura aquí
                ventana.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
