/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo32;

import java.time.LocalDate;

import java.time.ZoneId;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import universidadgrupo32accesoDatos.AlumnoData;
import universidadgrupo32entidades.Alumno;

public class GestionDeAlumnos extends javax.swing.JInternalFrame {

    public GestionDeAlumnos() {
        initComponents();
        jTapellido.setEnabled(false);
        jTnombre.setEnabled(false);
        jRestado.setEnabled(false);
        jDfecha.setEnabled(false);
        jBeliminar.setEnabled(false);
        jBguardar.setEnabled(false);
        jBmodificar.setEnabled(false);
        jLidAlumno.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBnuevo = new javax.swing.JButton();
        jBeliminar = new javax.swing.JButton();
        jBguardar = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();
        jBbuscar = new javax.swing.JButton();
        jTdocumento = new javax.swing.JTextField();
        jTapellido = new javax.swing.JTextField();
        jTnombre = new javax.swing.JTextField();
        jRestado = new javax.swing.JRadioButton();
        jDfecha = new com.toedter.calendar.JDateChooser();
        jBmodificar = new javax.swing.JButton();
        jLidAlumno = new javax.swing.JLabel();

        setTitle("Alumnos");

        jLabel1.setText("Alumno");

        jLabel2.setText("Documento: ");

        jLabel3.setText("Apellido:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Estado:");

        jLabel6.setText("Fecha de Nacimiento:");

        jBnuevo.setText("Nuevo");
        jBnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnuevoActionPerformed(evt);
            }
        });

        jBeliminar.setText("Eliminar");
        jBeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeliminarActionPerformed(evt);
            }
        });

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

        jBbuscar.setText("Buscar");
        jBbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbuscarActionPerformed(evt);
            }
        });

        jBmodificar.setText("Modificar");
        jBmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmodificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(291, 291, 291)
                                .addComponent(jBbuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBmodificar)
                                .addGap(44, 44, 44)
                                .addComponent(jBeliminar)
                                .addGap(47, 47, 47)
                                .addComponent(jBsalir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jDfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTdocumento)
                            .addComponent(jTapellido)
                            .addComponent(jTnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(jRestado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLidAlumno)
                        .addGap(13, 13, 13)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jBnuevo)
                .addGap(60, 60, 60)
                .addComponent(jBguardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jBbuscar)
                    .addComponent(jTdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jRestado)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLidAlumno)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jDfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBnuevo)
                    .addComponent(jBguardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBeliminar)
                    .addComponent(jBsalir)
                    .addComponent(jBmodificar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnuevoActionPerformed
        limpiarGalu();
        jTapellido.setEnabled(true);
        jTnombre.setEnabled(true);
        jRestado.setEnabled(true);
        jDfecha.setEnabled(true);
        jBguardar.setEnabled(true);
        jBeliminar.setEnabled(false);
        jRestado.setSelected(true);
    }//GEN-LAST:event_jBnuevoActionPerformed

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBsalirActionPerformed

    private void jBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBguardarActionPerformed
        try {
            int dni = Integer.parseInt(jTdocumento.getText());

            LocalDate fechNac = jDfecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            boolean est = false;
            if (jRestado.isSelected()) {
                est = true;
            }
            Alumno alu = new Alumno(dni, jTapellido.getText(), jTnombre.getText(), fechNac, est);
            AlumnoData aluD = new AlumnoData();
            aluD.guardarAlumno(alu);

            jTdocumento.setText("");
            jTapellido.setText("");
            jTnombre.setText("");
            jRestado.setSelected(false);

            jTapellido.setEnabled(false);
            jTnombre.setEnabled(false);
            jRestado.setEnabled(false);
            jDfecha.setEnabled(false);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "EL DNI INGRESADO NO CORRESPONDE A UN NUMERO VALIDO");
            jTdocumento.setText("");
        }
    }//GEN-LAST:event_jBguardarActionPerformed

    private void jBeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeliminarActionPerformed

        if (jRestado.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "EL ALUMNO YA ESTA DADO DE BAJA");
            jTdocumento.setText("");
            jTapellido.setText("");
            jTnombre.setText("");
            jRestado.setSelected(false);
            jDfecha.setDate(null);

            jTapellido.setEnabled(false);
            jTnombre.setEnabled(false);
            jRestado.setEnabled(false);
            jDfecha.setEnabled(false);
            jBeliminar.setEnabled(false);
            jBguardar.setEnabled(false);
        } else {

            AlumnoData aluD = new AlumnoData();
            Alumno alu = new Alumno();
            int dni = Integer.parseInt(jTdocumento.getText());
            try {
                aluD.bajaAlumno(dni);

                jTdocumento.setText("");
                jTapellido.setText("");
                jTnombre.setText("");
                jRestado.setSelected(false);
                jDfecha.setDate(null);
                jBnuevo.setEnabled(true);
                jTapellido.setEnabled(false);
                jTnombre.setEnabled(false);
                jRestado.setEnabled(false);
                jDfecha.setEnabled(false);
                jBeliminar.setEnabled(false);
                jBguardar.setEnabled(false);
                jBmodificar.setEnabled(false);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "EL DNI INGRESADO NO CORRESPONDE A UN NUMERO VALIDO");
    }//GEN-LAST:event_jBeliminarActionPerformed
        }
    }

    private void jBbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbuscarActionPerformed
        jBguardar.setEnabled(false);
        jBeliminar.setEnabled(true);
        jTapellido.setEnabled(true);
        jTnombre.setEnabled(true);
        jRestado.setEnabled(true);
        jDfecha.setEnabled(true);

        AlumnoData aluD = new AlumnoData();
        Alumno alu = new Alumno();
        try {
            int dni = Integer.parseInt(jTdocumento.getText());
            alu = aluD.buscarAlumno(dni);
            if (alu != null) {
                jBmodificar.setEnabled(true);
                jTapellido.setText(alu.getApellido());
                jTnombre.setText(alu.getNombre());
                jDfecha.setDate(java.sql.Date.valueOf(alu.getFechaNac()));
                jLidAlumno.setText(alu.getIdAlumno() + "");
                jBnuevo.setEnabled(false);
                if (alu.isActivo()) {
                    jRestado.setSelected(true);
                } else {
                    jRestado.setSelected(false);
                }
            } else {
                jBguardar.setEnabled(false);
                jBeliminar.setEnabled(false);
                jTapellido.setEnabled(false);
                jTnombre.setEnabled(false);
                jRestado.setEnabled(false);
                jDfecha.setEnabled(false);
                jBnuevo.setEnabled(true);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "EL DNI INGRESADO NO CORRESPONDE A UN NUMERO VALIDO");
            jTapellido.setEnabled(false);
            jTnombre.setEnabled(false);
            jRestado.setEnabled(false);
            jDfecha.setEnabled(false);
            jBeliminar.setEnabled(false);
        }
    }//GEN-LAST:event_jBbuscarActionPerformed

    private void jBmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmodificarActionPerformed
        // MODIFICA DATOS DEL ALUMNO MENOS EL ESTADO
        int id = Integer.parseInt(jLidAlumno.getText());
        int dni = Integer.parseInt(jTdocumento.getText());
        String apellido = jTapellido.getText();
        String nombre = jTnombre.getText();
        LocalDate fechNac = jDfecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        boolean est;
        if(jRestado.isSelected()){
            est = true;
        }else {est=false;}
        Alumno alu = new Alumno(id, dni, apellido, nombre, fechNac, est);
        AlumnoData aluD = new AlumnoData();
        
        aluD.modificarAlumno(alu);

        jTdocumento.setText("");
        jTapellido.setText("");
        jTnombre.setText("");
        jDfecha.setDate(null);
        jRestado.setSelected(false);
        jTapellido.setEnabled(false);
        jTnombre.setEnabled(false);
        jRestado.setEnabled(false);
        jDfecha.setEnabled(false);
        jBeliminar.setEnabled(false);
        jBguardar.setEnabled(false);
        jBmodificar.setEnabled(false);
        jBnuevo.setEnabled(true);


    }//GEN-LAST:event_jBmodificarActionPerformed

    public void limpiarGalu() {
        jTdocumento.setText("");
        jTapellido.setText("");
        jTnombre.setText("");
        jRestado.setSelected(false);
        jDfecha.setDate(null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBbuscar;
    private javax.swing.JButton jBeliminar;
    private javax.swing.JButton jBguardar;
    private javax.swing.JButton jBmodificar;
    private javax.swing.JButton jBnuevo;
    private javax.swing.JButton jBsalir;
    private com.toedter.calendar.JDateChooser jDfecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLidAlumno;
    private javax.swing.JRadioButton jRestado;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTapellido;
    private javax.swing.JTextField jTdocumento;
    private javax.swing.JTextField jTnombre;
    // End of variables declaration//GEN-END:variables
}
