/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

/**
 *
 * @author kike
 */
public class Estudiante extends Estudiantes{
    
    @Override
    public void agregar(){
     try{
           PreparedStatement parametro;
           String query = "INSERT INTO estudiantes(carnet,nombres,apellidos,direccion,telefono,genero,email,fecha_nacimiento) VALUES(?,?,?,?,?,?,?,?);";
           cn = new Conexion ();
           cn.abrir_conexion();
           parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
           parametro.setString(1, this.getCarnet());
           parametro.setString(2, this.getNombres());
           parametro.setString(3, this.getApellidos());
           parametro.setString(4, this.getDireccion());
           parametro.setString(5, this.getTelefono());
           parametro.setString(6, this.getGenero());
           parametro.setString(7, this.getEmail());
           parametro.setString(8, this.getFecha_nacimiento());
           
           int executar = parametro.executeUpdate();
           cn.cerrar_conexion();
           
           JOptionPane.showMessageDialog(null, Integer.toString(executar) + "Registro Ingresado", "Agregar", JOptionPane.INFORMATION_MESSAGE);
           
           
       }catch(Exception ex){
           System.out.println("Error...." + ex.getMessage());
       }
   }
}
