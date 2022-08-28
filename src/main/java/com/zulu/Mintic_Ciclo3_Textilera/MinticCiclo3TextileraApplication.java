package com.zulu.Mintic_Ciclo3_Textilera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class MinticCiclo3TextileraApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MinticCiclo3TextileraApplication.class, args);


		//Creando empleado 0
		Empleado emp = new Empleado(0L,"Felipe","Rivera","demo@hotmail.com");
		//Creando Empresa 0
		Empresa empr = new Empresa("Algarra", "Calle 26",6015190299L,9014456787L);
		//Seteando empresa 0 al empleado 0
		emp.setEmpresa(empr);

		//Creando movimiento de dinero
		MovimientoDinero mv1 = new MovimientoDinero(2121313L,10.0F, "Venta de prueba");
		mv1.setEmpleado(emp);




		//Creando empleado 1
		Empleado emp1 = new Empleado(1L,"Laura","Gomez","laugomez@gmail.com");
		//Creando Empresa 1
		Empresa empr1 = new Empresa("WeWork", "Calle 26",6015190299L,9014456787L);;
		//Seteando empresa 1 al empleado 1
		emp1.setEmpresa(empr1);

		//Creando movimiento de dinero1
		MovimientoDinero mv2 = new MovimientoDinero(9898645L, 15.0F, "Venta de prueba1");
		mv2.setEmpleado(emp1);



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

		//Imprimiendo movimientos de dinero para el empleado

		System.out.println(
				"** Movimiento de dinero" +"\n"+
						"ID de la transacción:"+ mv1.getTransactionID()+ "\n" +
						"ID de empleado:"+ mv1.getEmpleado().getIdUser() + "\n" +
						"Nombre de empleado:"+ mv1.getEmpleado().getNombres()+" "+mv1.getEmpleado().getApellidos() + "\n"+
						"Concepto Movimiento:"+ mv1.getConceptoMovimiento() + "\n"+
						"Monto:"+ mv1.getMontoDinero() + "\n"
		);

		System.out.println(
				"** Movimiento de dinero" +"\n"+
						"ID de la transacción:"+ mv2.getTransactionID()+ "\n" +
						"ID de empleado:"+ mv2.getEmpleado().getIdUser() + "\n" +
						"Nombre de empleado:"+ mv2.getEmpleado().getNombres()+" "+mv2.getEmpleado().getApellidos() + "\n"+
						"Concepto Movimiento:"+ mv2.getConceptoMovimiento() + "\n"+
						"Monto:"+ mv2.getMontoDinero() + "\n"
		);
	}

}
