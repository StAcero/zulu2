package com.zulu.Mintic_Ciclo3_Textilera;

public class Controller {
    public static void main(String[] args) {

        //Creando empleado 0
        Empleado emp = new Empleado("Felipe","Rivera","demo@hotmail.com");
        //Creando Empresa 0
        Empresa empr = new Empresa("Algarra", "Calle 26",6015190299L,9014456787L);
        //Seteando empresa 0 al empleado 0
        emp.setEmpresa(empr);

        //Creando empleado 1
        Empleado emp1 = new Empleado("Laura","Gomez","laugomez@gmail.com");
        //Creando Empresa 1
        Empresa empr1 = new Empresa("UHC", "Calle 67",6015190433L,9424567425L);
        //Seteando empresa 1 al empleado 1
        emp1.setEmpresa(empr1);


        //Imprimiendo Empleados y empresa correspondiente.
        System.out.println(
                       "** Empleado:"+"\n"+
                       "Nombre:"+ emp.getNombres()+" "+emp.getApellidos()+"\n"+
                       "Correo:"+ emp.getCorreo()+"\n"+
                       "** Empresa" +"\n"+
                       "Nombre:"+ emp.getEmpresa().getnombreEmpresa()+"\n"+
                       "Dirección:"+ emp.getEmpresa().getdireccionEmpresa()+"\n"+
                       "Teléfono:"+ emp.getEmpresa().getTelefono()+"\n"+
                       "Nit:"+ emp.getEmpresa().getTelefono()+"\n"+
                       "-------------------"+"\n"

        );
        System.out.println(
                        "** Empleado:"+"\n"+
                        "Nombre:"+ emp1.getNombres()+" "+emp1.getApellidos()+"\n"+
                        "Correo:"+ emp1.getCorreo()+"\n"+
                        "** Empresa" +"\n"+
                        "Nombre:"+ emp1.getEmpresa().getnombreEmpresa()+"\n"+
                        "Dirección:"+ emp1.getEmpresa().getdireccionEmpresa()+"\n"+
                        "Teléfono:"+ emp1.getEmpresa().getTelefono()+"\n"+
                        "Nit:"+ emp1.getEmpresa().getTelefono()+"\n"+
                        "-------------------"+"\n"

        );

    }
}
