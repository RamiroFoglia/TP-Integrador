package trabajoIntegrador;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class ConexionDB {

    private static Connection conX;
    private static Statement sT;

    public static Connection conexionDB() {

        try {
            conX = DriverManager.getConnection("jdbc:mysql://localhost:3306/db-soporte-incidente", "root", "");
            sT = conX.createStatement();
            return conX;
        } catch (SQLException obj) {

            System.out.println("Error en la conexion de la base de datos" + obj);
            System.out.println(obj.fillInStackTrace());
        }
        return null;

    }

    //ALTA CLIENTE  
    public static void altaClienteDB(Cliente cli) {
        String consulta = "insert into cliente(idCli,cuit,razonS,nom,ape,dire,cel,mail,altaCliente)"
                + " values (idCli,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement sqlUp = conX.prepareStatement(consulta);

            sqlUp.setString(1, cli.getCuitCliente());
            sqlUp.setString(2, cli.getRazonSocial());
            sqlUp.setString(3, cli.getNomCliente());
            sqlUp.setString(4, cli.getApeCliente());
            sqlUp.setString(5, cli.getDireCliente());
            sqlUp.setString(6, cli.getCelCliente());
            sqlUp.setString(7, cli.getMailCliente());
            sqlUp.setString(8, LocalDate.now().toString());

            sqlUp.executeUpdate();

            System.out.println("¡¡Alta de cliente exitosa!!");

        } catch (SQLException obj) {
            System.out.println("Error en el insert de la tabla Cliente" + obj);
            obj.fillInStackTrace();
        }

    }

    public static void contratosCliente(int idCliente) {
//        List<> listaContratos = new ArrayList<>();

        String consulta = String.format("select nom, ape from cliente where idCli = %s", idCliente);
        ResultSet rs;

        try {
            rs = sT.executeQuery(consulta);

            if (rs.next()) {
                System.out.println("[CONTRATOS del cliente: " + rs.getString(2) + ", " + rs.getString(1) + "]");

                String consulta2 = String.format("select codSoporte, desSoporte, estadoSoporte"
                        + " from soporte S, clientecontrato CC where "
                        + "S.idSoporte = CC.idSoporte and CC.idCliente = %s", idCliente);
                ResultSet rs2;
                try {
                    rs2 = sT.executeQuery(consulta2);
                    System.out.println("\t[CODIGO]\t[ESTADO]\t[DESCRIPCION]");
                    while (rs2.next()) {
                        System.out.println("\t" + rs2.getString(1) + "\t\t" + rs2.getString(3) + "\t" + rs2.getString(2));
                    }
                    System.out.println("");
                } catch (SQLException obj) {
                    System.out.println("Error al buscar contratos del cliente " + obj);
                    obj.fillInStackTrace();
                }
            }

        } catch (SQLException obj) {
            System.out.println("Error al buscar el cliente para mostrar los contratos " + obj);
            obj.fillInStackTrace();
        }
    }

    //BUSCAR CLIENTE POR CUIT
    public static boolean existeCuitCliente(String cuitCliente) {
        boolean estado = false;
        String consulta = String.format("select * from cliente where cuit = %s", cuitCliente);
        ResultSet rs;

        try {
            rs = sT.executeQuery(consulta);

            if (rs.next()) {
                estado = true;
            }

        } catch (SQLException obj) {
            System.out.println("Error al buscar cliente por cuit" + obj);
            obj.fillInStackTrace();
        }

        return estado;
    }

    //METODO QUE RECIBE UN CUIT Y DEVUELCE EL ID DEL CLIENTE
    public static int idCliente(String cuitCliente) {
        int idcli = 0;
        String consulta = String.format("select idCli from cliente where cuit = %s", cuitCliente);
        ResultSet rs;

        try {
            rs = sT.executeQuery(consulta);

            if (rs.next()) {
                idcli = rs.getInt(1);

            }

        } catch (SQLException obj) {
            System.out.println("Error al buscar cliente por cuit" + obj);
            obj.fillInStackTrace();
        }
        return idcli;
    }

    //LISTAR CLIENTES
    public static void listarCliente() {

        String consulta = "select * from cliente";

        ResultSet sql;
        try {
            sql = sT.executeQuery(consulta);
            System.out.println("\n============================== LISTADO DE CLIENTES ==============================");
            System.out.println("[ID]\t[CUIT]\t\t[NOMBRE]\t[APELLIDO]\t[RAZON SOCIAL]");
            while (sql.next()) {

                System.out.println(sql.getInt(1) + "\t" + sql.getString(2) + "\t" + sql.getString(4)
                        + "\t\t" + sql.getString(5) + "\t\t" + sql.getString(3));

            }
            System.out.println("===================================================================================");
        } catch (SQLException e) {
            System.out.println("Error al consultar la tabla Clientes: " + e);
            e.printStackTrace();
        }

    }

    //ALTA EMPLEADO
    public static void altaEmpleadoDB(Empleado emp1) {

        String consulta = "insert into Empleado(idEmpleado,cuitEmpleado,nomEmpleado,apeEmpleado,direEmpleado"
                + ",celEmpleado,mailEmpleado,altaEmpleado,areaEmpleado) values (idEmpleado,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement sqlUp = conX.prepareStatement(consulta);

            sqlUp.setString(1, emp1.getCuitEmpleado());
            sqlUp.setString(2, emp1.getNomEmpleado());
            sqlUp.setString(3, emp1.getApeEmpleado());
            sqlUp.setString(4, emp1.getDireEmpleado());
            sqlUp.setString(5, emp1.getCelEmpleado());
            sqlUp.setString(6, emp1.getMailEmpleado());
            sqlUp.setString(7, LocalDate.now().toString());
            sqlUp.setString(8, emp1.getAreaEmpleado());

            sqlUp.executeUpdate();

            System.out.println("La DB/TABLA EMPLEADO se actualizo con exito");
        } catch (SQLException obj) {
            System.out.println("Error en el insert de la tabla Empleado" + obj);
            obj.fillInStackTrace();
        }
    }

    //BUSCAR EMPLEADO POR CUIT
    public static boolean existeCuitEmpleado(String cuitEmp) {
        boolean estado = false;
        String consulta = String.format("select * from empleado where cuitEmpleado = %s", cuitEmp);
        ResultSet rs;

        try {
            rs = sT.executeQuery(consulta);

            if (rs.next()) {
                estado = true;
            }

        } catch (SQLException obj) {
            System.out.println("Error al buscar cliente por cuit" + obj);
            obj.fillInStackTrace();
        }
        return estado;
    }

    //LISTAR EMPLEADOS
    public static void listarEmpleado() {

        String consulta = "select * from empleado";

        ResultSet sql;
        try {
            sql = sT.executeQuery(consulta);

            System.out.println("\n======================================= LISTADO DE EMPLEADOS =======================================");
            System.out.println("[ID]   [CUIT]        [NOMBRE]    [APALLIDO]     [CELULAR]       [EMAIL]\t\t\t[AREA]");
            while (sql.next()) {

                System.out.println(sql.getInt(1) + "     " + sql.getString(2) + "   " + sql.getString(3)
                        + "\t  " + sql.getString(4) + "\t" + sql.getString(6) + "\t" + sql.getString(7)
                        + "\t" + sql.getString(9));
            }
            System.out.println("=====================================================================================================\n");

        } catch (SQLException e) {
            System.out.println("Error en el select de la tabla EMPLEADO" + e);
            e.printStackTrace();
        }
    }

    //ALTA TECNICO
    public static void altaTecnicoDB(Tecnico tec1) {

        String consulta = "insert into Tecnico(idTecnico,cuitEmpleado,tituloTecnico,dispoTecnico,altaTecnico,estadoTecnico) values (idTecnico,?,?,?,?,?)";

        try {
            PreparedStatement sqlUp = conX.prepareStatement(consulta);

            sqlUp.setString(1, tec1.getCuitEmpleado());
            sqlUp.setString(2, tec1.getTituloTecnico());
            sqlUp.setString(3, tec1.getDispoTecnico());
            sqlUp.setString(4, LocalDate.now().toString());
            sqlUp.setString(5, tec1.getEstadoTecnico());

            sqlUp.executeUpdate();

            System.out.println("La DB/TABLA TECNICO se actualizo con exito");

        } catch (SQLException obj) {
            System.out.println("Error en el insert de la tabla Tecnico: " + obj);
            obj.fillInStackTrace();
        }

    }

    //LISTAR TECNICOS
    public static void listarTecnico() {

        String consulta = "select * from tecnico";

        ResultSet sql;
        try {
            sql = sT.executeQuery(consulta);
            System.out.println("\n============================== LISTADO DE TECNICOS ==============================");
            System.out.println("[ID]    [CUIT]           [ESTADO]");
            while (sql.next()) {

                System.out.println(sql.getInt(1) + "\t" + sql.getString(2) + "\t  " + sql.getString(6));

            }
            System.out.println("===================================================================================");
        } catch (SQLException e) {
            System.out.println("Error al consultar la tabla tecnicos: " + e);
            e.printStackTrace();
        }

    }

    //VALIDAR CUIT EMPLEADO
    public static boolean validarCuitEmpleado(String cuitEmp) {
        String consulta = String.format("select * from empleado where cuitEmpleado = %s", cuitEmp);
        ResultSet sql;
        boolean resultado = false;

        try {
            sql = sT.executeQuery(consulta);
            int id = 0;
            String nom = " ", ape = " ";

            while (sql.next()) {

                id = sql.getInt(1);
                nom = sql.getString(3);
                ape = sql.getString(4);
                System.out.println(sql.getInt(1) + "\t" + sql.getString(2) + "\t" + sql.getString(3) + "\t" + sql.getString(4));
                if (sql.getRow() == 0) {
                    System.out.println("El empleado no existe, INGRESE OTRO CUIT");
                    return resultado = false;
                } else {
                    return resultado = true;
                }

            }

        } catch (SQLException e) {
            System.out.println("Error en la busqueda de Empleado" + e);
            e.printStackTrace();
        }
        return resultado;
    }

    //ALTA SOPORTE
    public static void altaSoporteDB(SoporteServicio sop1) {

        String consulta = "insert into soporte(idSoporte,codSoporte,tipoSoporte,desSoporte,altaSoporte,tmpRespSoporte,complejidadSoporte,estadoSoporte) values (idSoporte,?,?,?,?,?,?,?)";

        try {
            PreparedStatement sqlUp = conX.prepareStatement(consulta);

            sqlUp.setString(1, sop1.getCodSoporte());
            sqlUp.setString(2, sop1.getTipoSoporte());
            sqlUp.setString(3, sop1.getDesSoporte());
            sqlUp.setString(4, LocalDate.now().toString());
            sqlUp.setString(5, sop1.getTmpRespSoporte());
            sqlUp.setString(6, sop1.getComplejidadSoporte());
            sqlUp.setString(7, sop1.getEstadoSoporte());

            sqlUp.executeUpdate();

            System.out.println("La DB/TABLA SOPORTE se actualizo con exito");

        } catch (SQLException obj) {
            System.out.println("Error en el insert de la tabla SOPORTE" + obj);
            obj.fillInStackTrace();
        }

    }

    //LISTAR SOPORTE
    public static void listarSoporte() {

        String consulta = "select * from soporte";

        ResultSet sql;
        try {
            sql = sT.executeQuery(consulta);
            System.out.println("\n============================== LISTADO DE SOPORTES ==============================");
            System.out.println("[ID]   [CODIGO]   [TIPO]   [ESTADO]\t  [DESCRIPCION]");
            while (sql.next()) {

                System.out.println(sql.getInt(1) + "\t" + sql.getString(2) + "\t  " + sql.getString(3) + "\t    " + sql.getString(8) + "\t   " + sql.getString(4));

            }
            System.out.println("===================================================================================");
        } catch (SQLException e) {
            System.out.println("Error en el INSERT de la tabla SOPORTE" + e);
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //ALTA INCIDENTE
    public static void altaIncidenteDB(Incidente inc1) {

        String consulta = "insert into incidente(idIncidente,idEmpleado,idCliente,idSoporte,idTecnico,altaIncidente,fechaResolucion,horaColchon,estadoIncidente)"
                + " values (idIncidente,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement sqlUp = conX.prepareStatement(consulta);

            sqlUp.setInt(1, inc1.getIdEmpleado());
            sqlUp.setInt(2, inc1.getIdCliente());
            sqlUp.setInt(3, inc1.getIdSoporte());
            sqlUp.setInt(4, inc1.getIdTecnico());
            sqlUp.setString(5, LocalDate.now().toString());
            sqlUp.setString(6, inc1.getFechaResolucion());
            sqlUp.setString(7, inc1.getHorasColchon());
            sqlUp.setString(8, inc1.getEstadoIncidente());

            sqlUp.executeUpdate();

            System.out.println("La DB/TABLA INCIDENTE se actualizo con exito");

        } catch (SQLException obj) {
            System.out.println("Error en el insert de la tabla Incidente" + obj);
            obj.fillInStackTrace();
        }

    }

    //ALTA CONTRATOCLIENTE
    static void altaContratoClienteDB(Incidente inc1) {
        String consulta = "insert into clientecontrato(idCliente, idSoporte, altaContrato) values (?,?,?)";

        try {
            PreparedStatement sqlUp = conX.prepareStatement(consulta);

            sqlUp.setInt(1, inc1.getIdCliente());
            sqlUp.setInt(2, inc1.getIdSoporte());
            sqlUp.setString(3, LocalDate.now().toString());

            sqlUp.executeUpdate();

        } catch (SQLException obj) {
            System.out.println("Error en el insert de la tabla ContratoCliente: " + obj);
            obj.fillInStackTrace();
        }

    }

}
