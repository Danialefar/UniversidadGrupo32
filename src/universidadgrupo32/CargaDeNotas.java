/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo32;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadgrupo32accesoDatos.AlumnoData;
import universidadgrupo32accesoDatos.InscripcionData;
import universidadgrupo32entidades.Alumno;
import universidadgrupo32entidades.Inscripcion;
import universidadgrupo32entidades.Materia;

/**
 *
 * @author Emiliano
 */
public class CargaDeNotas extends javax.swing.JInternalFrame {

    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    /**
     * Creates new form CargaDeNotas
     */
    public CargaDeNotas() {
        initComponents();
        armarCabecera();

        AlumnoData aluD = new AlumnoData();

        for (Alumno alus : aluD.listarAlumnos()) {
            Alumno alu = new Alumno(alus.getIdAlumno(), alus.getDni(), alus.getApellido(), alus.getNombre(),
                    alus.getFechaNac(), alus.isActivo());
            jCseleccionAluNotas.addItem(alu);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jCseleccionAluNotas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTnotas = new javax.swing.JTable();
        jBguardar = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTnuevaNota = new javax.swing.JTextField();
        jBcargarNota = new javax.swing.JButton();

        setTitle("Carga de Notas");

        jLabel1.setText("Carga de Notas");

        jLabel2.setText("Seleccione Alumno:");

        jCseleccionAluNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCseleccionAluNotasActionPerformed(evt);
            }
        });

        jTnotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTnotas);

        jBguardar.setText("Guardar");
        jBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBguardarActionPerformed(evt);
            }
        });

        jBsalir.setText("Salir");
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });

        jLabel3.setText("Para cambiar una nota seleccione una materia");

        jLabel4.setText("Ingrese la Calificación");

        jBcargarNota.setText("Cargar Nota");
        jBcargarNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcargarNotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jBguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBsalir)
                .addGap(79, 79, 79))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jCseleccionAluNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTnuevaNota, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBcargarNota)))
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCseleccionAluNotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTnuevaNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBcargarNota))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBguardar)
                    .addComponent(jBsalir))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBsalirActionPerformed

    private void jCseleccionAluNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCseleccionAluNotasActionPerformed
        // carga tabla con lkas materias donde esta inscripto el alumno
        borrarFilas();
        Alumno al = (Alumno) jCseleccionAluNotas.getSelectedItem();

        InscripcionData insD = new InscripcionData();

        for (Inscripcion in : insD.obtenerInscripcionmesPorAlumno2(al.getIdAlumno())) {

            modelo.addRow(new Object[]{
                in.getMateria().getIdMateria(),
                in.getMateria().getNombre(),
                in.getNota(),});
        }

    }//GEN-LAST:event_jCseleccionAluNotasActionPerformed

    private void jBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBguardarActionPerformed
        // modifica la nota del alumno
        InscripcionData insD = new InscripcionData();
        int filaSelec = jTnotas.getSelectedRow();

        if (filaSelec != -1) {
            Alumno alumno = (Alumno) jCseleccionAluNotas.getSelectedItem();

            int idMateria = (Integer) modelo.getValueAt(filaSelec, 0);
//            String notaTabla = (String) modelo.getValueAt(filaSelec, 2);
            double nota = Double.parseDouble((String) modelo.getValueAt(filaSelec, 2));
            insD.actualizarNota(alumno.getIdAlumno(), idMateria, nota);
            borrarFilas();

        } else {
            JOptionPane.showMessageDialog(this, "SELECCIONE UNA MATERIA DEL LISTADO");
        }


    }//GEN-LAST:event_jBguardarActionPerformed

    private void jBcargarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcargarNotaActionPerformed
        // CARGA NOTA EN LA TABLA
        try{
            int filaSelec = jTnotas.getSelectedRow();
            String notaNueva = (String) jTnuevaNota.getText();
            double nota = Double.parseDouble(notaNueva);

            if (filaSelec != -1) {
                if (nota >= 1 && nota <= 10) {
                    modelo.setValueAt(jTnuevaNota.getText(), jTnotas.getSelectedRow(), 2);
                    jTnuevaNota.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "DEBE INGRESAR UN VALOR NUMÉRICO ENTRE 1 y 10");
                }
            } else {
                JOptionPane.showMessageDialog(this, "SELECCIONE UNA MATERIA DEL LISTADO");
            }
        }catch(NumberFormatException nf){
        JOptionPane.showMessageDialog(this, "DEBE UNGRESAR UN NÚMERO");
        jTnuevaNota.setText("");
        }
    }//GEN-LAST:event_jBcargarNotaActionPerformed
    

    private void armarCabecera() {
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");
        jTnotas.setModel(modelo);
    }

    private void borrarFilas() {
        int f = jTnotas.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBcargarNota;
    private javax.swing.JButton jBguardar;
    private javax.swing.JButton jBsalir;
    private javax.swing.JComboBox<Alumno> jCseleccionAluNotas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTnotas;
    private javax.swing.JTextField jTnuevaNota;
    // End of variables declaration//GEN-END:variables
}
