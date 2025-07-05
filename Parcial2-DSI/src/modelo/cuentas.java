package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class cuentas {
    int idcuenta;
    String nombres;
    String apellidos; 
    String dui; 
    String tipo;
    String saldo;
    String fecha; 
    String activa;

    public cuentas() {
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getActiva() {
        return activa;
    }

    public void setActiva(String activa) {
        this.activa = activa;
    }
    
    //METODOS
    public boolean Insertar(){
        boolean resultado = false;
        PreparedStatement ps;
        conexion cc = new conexion();
        try{
            ps = cc.Conectar().prepareStatement("insert into cuentas(nombres, apellidos, dui, tipo, saldo, fecha, activa) values (?, ?, ?, ?, ?, ?, ?)");
            ps.setString (1, this.nombres);
            ps.setString(2, this.apellidos);
            ps.setString(3, this.dui);
            ps.setString(4, this.tipo);
            ps.setString(5, this.saldo);
            ps.setString(6, this.fecha);
            ps.setString(7, this.activa);
            
            int res = ps.executeUpdate();
            resultado = res > 0;
            cc.desconectar();
            return resultado;
            
        }catch (SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    public boolean Actualizar() {
        boolean resultado = false;
        PreparedStatement ps;
        conexion cc = new conexion();

        try {
            ps = cc.Conectar().prepareStatement( "update cuentas set nombres = ?, apellidos = ?, dui = ?, tipo = ?, saldo =?, fecha = ?, activa = ? where idcuenta = ?");

            ps.setString(1, this.nombres);
            ps.setString(2, this.apellidos);
            ps.setString(3, this.dui);
            ps.setString(4, this.tipo);
            ps.setString(5, this.saldo);
            ps.setString(6, this.fecha);
            ps.setString(7, this.activa);
            ps.setInt(8, this.idcuenta);

            int res = ps.executeUpdate();
            resultado = res > 0;
            cc.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
        return resultado;
    }
    
    public boolean Eliminar(){
        boolean resultado = false;
        PreparedStatement ps;
        conexion cc = new conexion();
        
        try{
            ps = cc.Conectar().prepareStatement("delete from cuentas where idcuenta = ?;");
            ps.setInt(1, this.idcuenta);
            int res = ps.executeUpdate();
            resultado = res > 0;
            cc.desconectar();
            return resultado;
        }catch(SQLException e){
          System.out.println(e);
        }
        return resultado;
    }
    
    public DefaultTableModel buscarEmpleado(String buscar) {
        String[] nombreColumna = {"id", "nombres", "apellidos", "dui", "tipo", "saldo", "fecha", "activa"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombreColumna);

        String sql = "select * from cuentas where nombres like ? or apellidos like ? or idcuenta like ?";

        conexion cc = new conexion();
        Connection con = cc.Conectar(); 

        if (con == null) {
            System.out.println("Error: No se pudo establecer la conexión a la base de datos.");
            return modelo;
        }

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "%" + buscar + "%");
            ps.setString(2, "%" + buscar + "%");
            ps.setString(3, "%" + buscar + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] registros = new String[8];
                registros[0] = rs.getString("idcuenta");
                registros[1] = rs.getString("nombres");
                registros[2] = rs.getString("apellidos");
                registros[3] = rs.getString("dui");
                registros[4] = rs.getString("tipo");
                registros[5] = rs.getString("saldo");
                registros[6] = rs.getString("fecha");
                registros[7] = rs.getString("activa");
                modelo.addRow(registros); 
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            cc.desconectar();
        }
        return modelo;
    }
}