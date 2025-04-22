/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectos5teatromoro;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

//====================================================================================================================================================
public class ProyectoS5teatroMoro {

    static String[][] salaVIP = new String[3][6];
    static String[][] salaPB = new String[5][6];
    static String[][] salaPA = new String[5][6];
    static String[][] salaPalcoA = new String[3][6];
    static String[][] salaPalcoB = new String[3][6];
    static Scanner scanner = new Scanner(System.in);
    static List<BoletaEntrada> listadoEntradas = new ArrayList<>();

//====================================================================================================================================================
    public static void main(String[] args) {

        inicializarSala();
        boolean continuar = true;

        for (; continuar;) {

            mostrarMenu();
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("COMPRAR ENTRADAS");
                    comprarEntrada();
                    break;
                case 2:
                    System.out.println("MODIFICAR ENTRADAS");
                    modificarEntrada();
                    break;
                case 3:
                    System.out.println("BUSQUEDA DE ENTRADAS");
                    buscarEntradas();
                    break;
                case 4:
                    System.out.println("ANULAR ENTRADAS");
                    System.out.println(" *al anular una entrada, el teatro te penaliza con el 15% del total por costos de plataforma* ");
                    anularEntrada();
                    break;
                case 5:
                    System.out.println("RESERVAR ENTRADAS");
                    reservarEntrada();
                    break;
                case 6:
                    System.out.println("PAGAR RESERVAS");
                    pagoReservas();
                    break;
                case 7:
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    continuar = false;
                    break;
                case 8:
                    int clave=1234;
                    System.out.println("Ingrese la clave:");
                    clave = scanner.nextInt();
                    if (clave != 1234) {
                        System.out.println("Clave incorrecta, volviendo al menu principal...");
                        continuar = false;
                    } else if (clave == 1234) {
                        menuAdministrador();
                        System.out.println("Para salir ingrese 1");
                        int salir=0;
                        salir=scanner.nextInt();
                        while (salir !=1){
                            System.out.println("Solo debes ingresar > 1 < *-* ");
                        }
                        if (salir==1){
                            continuar = false;
                        }
                    }     
                default:
                    System.out.println("DEBE INGRESAR UNA OPCION VALIDA (1-5)");
            }
        }
    }


  //===========================================================================================================================================
  //
  //===========================================================================================================================================
    static void inicializarSala() {
        for (int i = 0; i < salaPB.length; i++) {
            for (int j = 0; j < salaPB[i].length; j++) {
                salaPB[i][j] = "D";
            }
        }
        for (int i = 0; i < salaPA.length; i++) {
            for (int j = 0; j < salaPA[i].length; j++) {
                salaPA[i][j] = "D";
            }
        }
        for (int i = 0; i < salaVIP.length; i++) {
            for (int j = 0; j < salaVIP[i].length; j++) {
                salaVIP[i][j] = "D";
            }
        }
        for (int i = 0; i < salaPalcoA.length; i++) {
            for (int j = 0; j < salaPalcoA[i].length; j++) {
                salaPalcoA[i][j] = "D";
                salaPalcoB[i][j] = "D";
            }
        }
    }
    
  //===========================================================================================================================================
  //
  //===========================================================================================================================================
    static void mostrarMenu() {
        System.out.println("=======================================================");
        System.out.println("                 BIENVENID@ AL TEATRO MORO             ");
        System.out.println("=======================================================");
        System.out.println("        ¡Cuentanos!, como podemos ayudarte? ");
        System.out.println("   (1) Comprar Entrada    (2) Modificar entrada      ");
        System.out.println("   (3) Buscar entrada     (4) Anular entrada             ");
        System.out.println("   (5) Reservar Entradas  (6) Pagar Reserva              ");
        System.out.println("   (7) SALIR              (8) ADMINISTRADOR");
        System.out.println("=======================================================");
    }
  //===========================================================================================================================================
  //  BLOQUE DE PLANOS SEGUN LA ZONA DEL TEATRO :
  //===========================================================================================================================================    

    static void mostrarPlanoVIP() {
        System.out.println("(D)= Asiento Disponible  (X)= Asiento Ocupado   (R)=Asiento Reservado ");
        System.out.println("==========================================================");
        System.out.println("|                       ESCENARIO                         ");
        System.out.println("==========================================================");
        for (int i = 0; i < salaVIP.length; i++) {
            for (int j = 0; j < salaVIP[i].length; j++) {
                if (i == 0 && j == 0) {
                    salaVIP[i][j] = " ";
                } else if (i == 0) {
                    salaVIP[i][j] = String.valueOf(j);
                } else if (j == 0) {
                    salaVIP[i][j] = String.valueOf(i);
                }
                System.out.print("Fila => [" + salaVIP[i][j] + "]");
            }
            System.out.println();
        }
    }

    static void mostrarPlanoPlateaBaja() {
        System.out.println("(D)= Asiento Disponible y (X)= Asiento Ocupado   (R)=Asiento Reservado ");
        System.out.println("==========================================================");
        System.out.println("|                       ESCENARIO                         ");
        System.out.println("==========================================================");
        for (int i = 0; i < salaPB.length; i++) {
            for (int j = 0; j < salaPB[i].length; j++) {
                if (i == 0 && j == 0) {
                    salaPB[i][j] = " ";
                } else if (i == 0) {
                    salaPB[i][j] = String.valueOf(j);
                } else if (j == 0) {
                    salaPB[i][j] = String.valueOf(i);
                }
                System.out.print("[" + salaPB[i][j] + "]");
            }
            System.out.println();
        }
    }

    static void mostrarPlanoPlateaAlta() {
        System.out.println("(D)= Asiento Disponible y (X)= Asiento Ocupado   (R)=Asiento Reservado ");
        System.out.println("|=========================================================|");
        System.out.println("|                       ESCENARIO                         |");
        System.out.println("|=========================================================|");
        for (int i = 0; i < salaPA.length; i++) {
            for (int j = 0; j < salaPA[i].length; j++) {
                if (i == 0 && j == 0) {
                    salaPA[i][j] = " ";
                } else if (i == 0) {
                    salaPA[i][j] = String.valueOf(j);
                } else if (j == 0) {
                    salaPA[i][j] = String.valueOf(i);
                }
                System.out.print("[" + salaPA[i][j] + "]");
            }
            System.out.println();
        }
    }

    static void mostrarPlanoPalcoA() {
        System.out.println("(D)= Asiento Disponible y (X)= Asiento Ocupado   (R)=Asiento Reservado ");
        System.out.println("==========================================================");
        System.out.println("|                       ESCENARIO                         ");
        System.out.println("==========================================================");
        for (int i = 0; i < salaPalcoA.length; i++) {
            for (int j = 0; j < salaPalcoA[i].length; j++) {
                if (i == 0 && j == 0) {
                    salaPalcoA[i][j] = " ";
                } else if (i == 0) {
                    salaPalcoA[i][j] = String.valueOf(j);
                } else if (j == 0) {
                    salaPalcoA[i][j] = String.valueOf(i);
                }
                System.out.print("[" + salaPalcoA[i][j] + "]");
            }
            System.out.println();
        }
    }

    static void mostrarPlanoPalcoB() {
        System.out.println("(D)= Asiento Disponible y (X)= Asiento Ocupado   (R)=Asiento Reservado ");
        System.out.println("==========================================================");
        System.out.println("|                       ESCENARIO                         ");
        System.out.println("==========================================================");
        System.out.println("                     C O L U M N A S                      ");
        for (int i = 0; i < salaPalcoB.length; i++) {
            for (int j = 0; j < salaPalcoB[i].length; j++) {
                if (i == 0 && j == 0) {
                    salaPalcoB[i][j] = " ";
                } else if (i == 0) {
                    salaPalcoB[i][j] = String.valueOf(j);
                } else if (j == 0) {
                    salaPalcoB[i][j] = String.valueOf(i);
                }
                System.out.print("[" + salaPalcoB[i][j] + "]");

            }
            System.out.println();
        }
    }
//====================================================================================================================================================
//  MENU 1: COMPRAR ENTRADAS
//====================================================================================================================================================

    static void comprarEntrada() {
        String nombre;
        int precioEntrada = 0;
        String zonaEntrada;
        int cantidadEntradas=0;

        System.out.println("Para una mejor atencion, ingrese su nombre:");
        scanner.nextLine();
        nombre=scanner.nextLine();

        
        System.out.println("Muy bien " + nombre + ". Para que funcion quieres comprar entardas?");
        System.out.println("==============FUNCIONES===============");
        System.out.println(" (1) Funcion 1: Nombre de la Funcion 1");
        System.out.println(" (2) Funcion 2: Nombre de la Funcion 2");
        System.out.println(" (3) Funcion 3: Nombre de la Funcion 3");
        
        int funcionSelec = 0;
        funcionSelec = scanner.nextInt();
        
        while (funcionSelec < 1 || funcionSelec > 3){
            System.out.println("Debe ingresar una opcion valida (1-3");
            funcionSelec = scanner.nextInt();
        }
         //===========================================================================================================================================
         // SWITCH QUE ABARCA LOS DATOS DE AREAS POR CADA FUNCION :
         //===========================================================================================================================================
        switch (funcionSelec) {
            case 1:
                System.out.println("Elija el area donde quiera comprar:");
                System.out.println("(1) VIP($30.000)  (2)Platea Baja($25.000)   (3)Platea Alta(20.000)");
                System.out.println("     (4)Palco A($15.000)  (5)Palco B($15.000)   ");
                System.out.println(" * Los precios se muestran en entrada regular sin descuentos *");
                System.out.println("        * El precio final puede variar segun la venta *");
                int areaSelec = scanner.nextInt();
                System.out.println("Muy bien "+nombre+", Cuantas entradas quieres compar?");
                cantidadEntradas=scanner.nextInt();
                System.out.println("\nA continuacion, se muestra el plano del teatro."); 
                while (areaSelec < 1 || areaSelec > 5) {
                    System.out.println("DEBE INGRESAR UNA OPCION VALIDA (1-5)");
                    areaSelec = scanner.nextInt();
                }
                 //===========================================================================================================================================
                 // SWITCH PARA DIFERENCIAR DATOS SEGUN EL EL AREA DEL TEATRO :
                 //===========================================================================================================================================
                switch (areaSelec) {
                    case 1:
                        mostrarPlanoVIP();
                        zonaEntrada = "VIP";
                        precioEntrada = 30000;
                        ValidarAsientosVIP(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        break;
                    case 2:
                        mostrarPlanoPlateaBaja();
                        zonaEntrada = "PLATEA BAJA";
                        precioEntrada = 25000;
                        ValidarAsientosPlateaBaja(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        break;
                    case 3:
                        mostrarPlanoPlateaAlta();
                        zonaEntrada = "PLATEA ALTA";
                        precioEntrada = 20000;
                        ValidarAsientosPlateaAlta(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        break;
                    case 4:
                        mostrarPlanoPalcoA();
                        zonaEntrada = "PALCO A";
                        precioEntrada = 15000;
                        ValidarAsientosPalcoA(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        break;
                    case 5:
                        mostrarPlanoPalcoB();
                        zonaEntrada = "PALCO B";
                        precioEntrada = 15000;
                        ValidarAsientosPalcoB(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        break;
                    default:
                        System.out.println("DEBE INGRESAR UNA POCION VALIDA (1-5)");
                        break;
                }
                break;
            case 2:
                System.out.println("Elija el area donde quiera comprar:");
                System.out.println("(1) VIP  (2)Platea Baja   (3)Platea Alta");
                System.out.println("     (4)Palco A  (5)Palco B   ");
                areaSelec = scanner.nextInt();
                System.out.println("\nA continuacion, se muestra el plano del teatro.");

                while (areaSelec < 1 || areaSelec > 5) {
                    System.out.println("DEBE INGRESAR UNA OPCION VALIDA (1-5)");
                    areaSelec = scanner.nextInt();
                }
                switch (areaSelec) {
                    case 1:
                        mostrarPlanoVIP();
                        zonaEntrada = "VIP";
                        precioEntrada = 30000;
                        ValidarAsientosVIP(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoVIP();
                        break;
                    case 2:
                        mostrarPlanoPlateaBaja();
                        zonaEntrada = "PLATEA BAJA";
                        precioEntrada = 25000;
                        ValidarAsientosPlateaBaja(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPlateaBaja();
                        break;
                    case 3:
                        mostrarPlanoPlateaAlta();
                        zonaEntrada = "PLATEA ALTA";
                        precioEntrada = 20000;
                        ValidarAsientosPlateaAlta(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPlateaAlta();
                        break;
                    case 4:
                        mostrarPlanoPalcoA();
                        zonaEntrada = "PALCO A";
                        precioEntrada = 15000;
                        ValidarAsientosPalcoA(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPalcoA();
                        break;
                    case 5:
                        mostrarPlanoPalcoB();
                        zonaEntrada = "PALCO B";
                        precioEntrada = 15000;
                        ValidarAsientosPalcoB(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPalcoB();
                        break;
                    default:
                        System.out.println("DEBE INGRESAR UNA POCION VALIDA (1-5)");
                        break;
                }
                break;
            case 3:
                System.out.println("Elija el area donde quiera comprar:");
                System.out.println("(1) VIP  (2)Platea Baja   (3)Platea Alta");
                System.out.println("     (4)Palco A  (5)Palco B   ");
                areaSelec = scanner.nextInt();
                System.out.println("\nA continuacion, se muestra el plano del teatro.");

                while (areaSelec < 1 || areaSelec > 5) {
                    System.out.println("DEBE INGRESAR UNA OPCION VALIDA (1-5)");
                    areaSelec = scanner.nextInt();
                }
                switch (areaSelec) {
                    case 1:
                        mostrarPlanoVIP();
                        zonaEntrada = "VIP";
                        precioEntrada = 30000;
                        ValidarAsientosVIP(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoVIP();
                        break;
                    case 2:
                        mostrarPlanoPlateaBaja();
                        zonaEntrada = "PLATEA BAJA";
                        precioEntrada = 25000;
                        ValidarAsientosPlateaBaja(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPlateaBaja();
                        break;
                    case 3:
                        mostrarPlanoPlateaAlta();
                        zonaEntrada = "PLATEA ALTA";
                        precioEntrada = 20000;
                        ValidarAsientosPlateaAlta(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPlateaAlta();
                        break;
                    case 4:
                        mostrarPlanoPalcoA();
                        zonaEntrada = "PALCO A";
                        precioEntrada = 15000;
                        ValidarAsientosPalcoA(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPalcoA();
                        break;
                    case 5:
                        mostrarPlanoPalcoB();
                        zonaEntrada = "PALCO B";
                        precioEntrada = 15000;
                        ValidarAsientosPalcoB(nombre, precioEntrada, funcionSelec,zonaEntrada, cantidadEntradas);
                        mostrarPlanoPalcoB();
                        break;
                    default:
                        System.out.println("DEBE INGRESAR UNA POCION VALIDA (1-5)");
                }
                break;
            default:
                System.out.println("INGRESE UNA FUNCION VALIDA (1-3)");
        }
    }
  //===========================================================================================================================================
  // MENU 2: MODIFICAR ENTRADA :
  //===========================================================================================================================================
    static void modificarEntrada() {
        System.out.println("INGRESE EL CODIGO DE RESERVA");
        scanner.nextLine();
        String codigoABuscar = scanner.nextLine();
        boolean encontrar = false;
        for (BoletaEntrada e : listadoEntradas) {
            if (e.codigo.equals(codigoABuscar)) {
                System.out.println("ENTRADA ENCONTRADA!");
                System.out.println("===============BOLETA===============");
                System.out.println("| NOMBRE CLIENTE:.........." + e.nombre);
                System.out.println("| FUNCION:................." + e.funcionSelec);
                System.out.println("| Zona Teatro:............." + e.zonaEntrada);
                System.out.println("| ASIENTO  FILA: " + e.fila + " | COLUMNA: " + e.columna);
                System.out.println("| CODIGO DE BOLETA:........" + e.codigo);
                System.out.println("| TOTAL:." + e.precioFinal);
                encontrar = true;
                if (!encontrar) {
                    System.out.println("NO SE HA ENCONTRADO LA ENTRADA");
                }
                if (e.codigo.equals(codigoABuscar)) {
                    switch (e.zonaEntrada.toUpperCase()) {
                        case "VIP":
                            System.out.println("SU ASIENTO ACTUAL SE MUESTRA COMO > A <");
                            salaVIP[e.fila][e.columna] = "A";
                            mostrarPlanoVIP();
                            salaVIP[e.fila][e.columna] = "D";
                            System.out.println("Eliga su nuevo asiento");
                            seleccionarAsientoVIP();
                            mostrarPlanoVIP();
                            break;
                        case "PLATEA BAJA":
                            System.out.println("SU ASIENTO ACTUAL SE MUESTRA COMO > A <");
                            salaPB[e.fila][e.columna] = "A";
                            mostrarPlanoPlateaBaja();
                            salaPB[e.fila][e.columna] = "D";
                            System.out.println("Eliga su nuevo asiento:");
                            seleccionarAsientoPlateaBaja();
                            mostrarPlanoPlateaBaja();
                            break;
                        case "PLATEA ALTA":                           
                            System.out.println("SU ASIENTO ACTUAL SE MUESTRA COMO > A <");
                            salaPA[e.fila][e.columna] = "A";
                            mostrarPlanoPlateaAlta();
                            salaPA[e.fila][e.columna] = "D";
                            System.out.println("Eliga su nuevo asiento");
                            seleccionarAsientoPlateaAlta();
                            mostrarPlanoPlateaAlta();
                            break;
                        case "PALCO A":                           
                            System.out.println("SU ASIENTO ACTUAL SE MUESTRA COMO > A <");
                            salaPalcoA[e.fila][e.columna] = "A";
                            mostrarPlanoPalcoA();
                            salaPalcoA[e.fila][e.columna] = "D";
                            System.out.println("Eliga su nuevo asiento");
                            seleccionarAsientoPalcoA();
                            mostrarPlanoPalcoA();
                            break;
                        case "PALCO B":                           
                            System.out.println("SU ASIENTO ACTUAL SE MUESTRA COMO > A <");
                            salaPalcoB[e.fila][e.columna] = "A";
                            mostrarPlanoPalcoB();
                            salaPalcoB[e.fila][e.columna] = "D";
                            System.out.println("Eliga su nuevo asiento");
                            seleccionarAsientoPalcoB();
                            mostrarPlanoPalcoB();
                            break;
                        default:
                            System.out.println("DATOS INCORRECTOS, VERIFIQUE LA INFORMACION.");
                    }
                }
            }
        }
    }

    public static int[] seleccionarAsientoVIP() {
        int fila, columna;
        do {
            System.out.println("Ingrese nueva fila (1 a 2):");
            fila = scanner.nextInt();
            System.out.println("Ingrese nueva columna (1 a 5):");
            columna = scanner.nextInt();

            if (fila < 1 || fila > 2 || columna < 1 || columna > 5) {
                System.out.println("Ubicación inválida. Intente de nuevo.");
            } else if (salaVIP[fila][columna].equals("X")) {
                System.out.println("Asiento ya vendido. Elija otro.");
            } else if (salaVIP[fila][columna].equals("R")) {
                System.out.println("Asiento reservado. Elija otro.");
            } else {
                break;
            }
        } while (true);

        return new int[]{fila, columna};

    }
    public static int[] seleccionarAsientoPlateaBaja() {
        int fila, columna;
        do {
            System.out.println("Ingrese nueva fila (1 a 4):");
            fila = scanner.nextInt();
            System.out.println("Ingrese nueva columna (1 a 5):");
            columna = scanner.nextInt();

            if (fila < 1 || fila > 4 || columna < 1 || columna > 5) {
                System.out.println("Ubicación inválida. Intente de nuevo.");
            } else if (salaPB[fila][columna].equals("X")) {
                System.out.println("Asiento ya vendido. Elija otro.");
            } else if (salaPB[fila][columna].equals("R")) {
                System.out.println("Asiento reservado. Elija otro.");
            } else {
                break;
            }
        } while (true);

        return new int[]{fila, columna};

    }
    public static int[] seleccionarAsientoPlateaAlta() {
        int fila, columna;
        do {
            System.out.println("Ingrese nueva fila (1 a 4):");
            fila = scanner.nextInt();
            System.out.println("Ingrese nueva columna (1 a 5):");
            columna = scanner.nextInt();

            if (fila < 1 || fila > 4 || columna < 1 || columna > 5) {
                System.out.println("Ubicación inválida. Intente de nuevo.");
            } else if (salaPA[fila][columna].equals("X")) {
                System.out.println("Asiento ya vendido. Elija otro.");
            } else if (salaPA[fila][columna].equals("R")) {
                System.out.println("Asiento reservado. Elija otro.");
            } else {
                break;
            }
        } while (true);

        return new int[]{fila, columna};

    }
    public static int[] seleccionarAsientoPalcoA() {
        int fila, columna;
        do {
            System.out.println("Ingrese nueva fila (1 a 2):");
            fila = scanner.nextInt();
            System.out.println("Ingrese nueva columna (1 a 5):");
            columna = scanner.nextInt();

            if (fila < 1 || fila > 2 || columna < 1 || columna > 5) {
                System.out.println("Ubicación inválida. Intente de nuevo.");
            } else if (salaPalcoA[fila][columna].equals("X")) {
                System.out.println("Asiento ya vendido. Elija otro.");
            } else if (salaPalcoA[fila][columna].equals("R")) {
                System.out.println("Asiento reservado. Elija otro.");
            } else {
                break;
            }
        } while (true);

        return new int[]{fila, columna};

    }
    public static int[] seleccionarAsientoPalcoB() {
        int fila, columna;
        do {
            System.out.println("Ingrese nueva fila (1 a 2):");
            fila = scanner.nextInt();
            System.out.println("Ingrese nueva columna (1 a 5):");
            columna = scanner.nextInt();

            if (fila < 1 || fila > 2 || columna < 1 || columna > 5) {
                System.out.println("Ubicación inválida. Intente de nuevo.");
            } else if (salaPalcoB[fila][columna].equals("X")) {
                System.out.println("Asiento ya vendido. Elija otro.");
            } else if (salaPalcoB[fila][columna].equals("R")) {
                System.out.println("Asiento reservado. Elija otro.");
            } else {
                break;
            }
        } while (true);

        return new int[]{fila, columna};

    }

  //===========================================================================================================================================
  // SISTEMA DE RESERVA DE ENTRADAS :
  //===========================================================================================================================================
     static void reservarEntrada() {
        String nombre;
        int precioEntrada = 0;
        String zonaEntrada;
        int cantidadEntradas=0;

        System.out.println("Para una mejor atencion, ingrese su nombre:");
        scanner.nextLine();
        nombre=scanner.nextLine();

        
        System.out.println("Muy bien " + nombre + ". Para que funcion quieres reservar entardas?");
        System.out.println("==============FUNCIONES===============");
        System.out.println(" (1) Funcion 1: Nombre de la Funcion 1");
        System.out.println(" (2) Funcion 2: Nombre de la Funcion 2");
        System.out.println(" (3) Funcion 3: Nombre de la Funcion 3");
        
        int funcionSelec = 0;
        funcionSelec = scanner.nextInt();
        
        while (funcionSelec < 1 || funcionSelec > 3){
            System.out.println("Debe ingresar una opcion valida (1-3");
            funcionSelec = scanner.nextInt();
        }
        
        switch (funcionSelec) {
            case 1:
                System.out.println("Elija el area donde quiera reservar:");
                System.out.println("(1) VIP($30.000)  (2)Platea Baja($25.000)   (3)Platea Alta(20.000)");
                System.out.println("     (4)Palco A($15.000)  (5)Palco B($15.000)   ");
                System.out.println("==================================================================");
                System.out.println(" * Los precios se muestran en entrada regular sin descuentos *");
                System.out.println("        * El precio final puede variar segun la venta *");
                System.out.println("==================================================================");
                
                int areaSelec = scanner.nextInt();
                
                System.out.println("Muy bien "+nombre+", Cuantas entradas quieres reservar?");
                
                cantidadEntradas=scanner.nextInt();
               
                System.out.println("\nA continuacion, se muestra el plano del teatro.");
                
                while (areaSelec < 1 || areaSelec > 5) {
                    System.out.println("DEBE INGRESAR UNA OPCION VALIDA (1-5)");
                    areaSelec = scanner.nextInt();
                }
                switch (areaSelec) {
                    case 1:
                        mostrarPlanoVIP();
                        zonaEntrada = "VIP";
                        precioEntrada = 30000;
                        ValidarReservaAsientosVIP(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoVIP();
                        break;
                    case 2:
                        mostrarPlanoPlateaBaja();
                        zonaEntrada = "PLATEA BAJA";
                        precioEntrada = 25000;
                        ValidarReservaAsientosPlateaBaja(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPlateaBaja();
                        break;
                    case 3:
                        mostrarPlanoPlateaAlta();
                        zonaEntrada = "PLATEA ALTA";
                        precioEntrada = 20000;
                        ValidarReservaAsientosPlateaAlta(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPlateaAlta();
                        break;
                    case 4:
                        mostrarPlanoPalcoA();
                        zonaEntrada = "PALCO A";
                        precioEntrada = 15000;
                        ValidarReservaAsientosPalcoA(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPalcoA();
                        break;
                    case 5:
                        mostrarPlanoPalcoB();
                        zonaEntrada = "PALCO B";
                        precioEntrada = 15000;
                        ValidarReservaAsientosPalcoB(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPalcoB();
                        break;
                    default:
                        System.out.println("DEBE INGRESAR UNA POCION VALIDA (1-5)");
                        break;
                }
                break;
            case 2:
                System.out.println("Elija el area donde quiera comprar:");
                System.out.println("(1) VIP  (2)Platea Baja   (3)Platea Alta");
                System.out.println("     (4)Palco A  (5)Palco B   ");
                areaSelec = scanner.nextInt();
                System.out.println("\nA continuacion, se muestra el plano del teatro.");

                while (areaSelec < 1 || areaSelec > 5) {
                    System.out.println("DEBE INGRESAR UNA OPCION VALIDA (1-5)");
                    areaSelec = scanner.nextInt();
                }
                switch (areaSelec) {
                    case 1:
                        mostrarPlanoVIP();
                        zonaEntrada = "VIP";
                        precioEntrada = 30000;
                        ValidarReservaAsientosVIP(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoVIP();
                        break;
                    case 2:
                        mostrarPlanoPlateaBaja();
                        zonaEntrada = "PLATEA BAJA";
                        precioEntrada = 25000;
                        ValidarReservaAsientosPlateaBaja(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPlateaBaja();
                        break;
                    case 3:
                        mostrarPlanoPlateaAlta();
                        zonaEntrada = "PLATEA ALTA";
                        precioEntrada = 20000;
                        ValidarReservaAsientosPlateaAlta(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPlateaAlta();
                        break;
                    case 4:
                        mostrarPlanoPalcoA();
                        zonaEntrada = "PALCO A";
                        precioEntrada = 15000;
                        ValidarReservaAsientosPalcoA(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPalcoA();
                        break;
                    case 5:
                        mostrarPlanoPalcoB();
                        zonaEntrada = "PALCO B";
                        precioEntrada = 15000;
                        ValidarReservaAsientosPalcoB(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPalcoB();
                        break;
                    default:
                        System.out.println("DEBE INGRESAR UNA POCION VALIDA (1-5)");
                        break;
                }
                break;
            case 3:
                System.out.println("Elija el area donde quiera comprar:");
                System.out.println("(1) VIP  (2)Platea Baja   (3)Platea Alta");
                System.out.println("     (4)Palco A  (5)Palco B   ");
                areaSelec = scanner.nextInt();
                System.out.println("\nA continuacion, se muestra el plano del teatro.");

                while (areaSelec < 1 || areaSelec > 5) {
                    System.out.println("DEBE INGRESAR UNA OPCION VALIDA (1-5)");
                    areaSelec = scanner.nextInt();
                }
                switch (areaSelec) {
                    case 1:
                        mostrarPlanoVIP();
                        zonaEntrada = "VIP";
                        precioEntrada = 30000;
                        ValidarReservaAsientosVIP(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoVIP();
                        break;
                    case 2:
                        mostrarPlanoPlateaBaja();
                        zonaEntrada = "PLATEA BAJA";
                        precioEntrada = 25000;
                        ValidarReservaAsientosPlateaBaja(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPlateaBaja();
                        break;
                    case 3:
                        mostrarPlanoPlateaAlta();
                        zonaEntrada = "PLATEA ALTA";
                        precioEntrada = 20000;
                        ValidarReservaAsientosPlateaAlta(nombre, precioEntrada,funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPlateaAlta();
                        break;
                    case 4:
                        mostrarPlanoPalcoA();
                        zonaEntrada = "PALCO A";
                        precioEntrada = 15000;
                        ValidarReservaAsientosPalcoA(nombre, precioEntrada, funcionSelec, zonaEntrada, cantidadEntradas);
                        mostrarPlanoPalcoA();
                        break;
                    case 5:
                        mostrarPlanoPalcoB();
                        zonaEntrada = "PALCO B";
                        precioEntrada = 15000;
                        ValidarReservaAsientosPalcoB(nombre, precioEntrada, funcionSelec,zonaEntrada, cantidadEntradas);
                        mostrarPlanoPalcoB();
                        break;
                    default:
                        System.out.println("DEBE INGRESAR UNA POCION VALIDA (1-5)");
                }
                break;
            default:
                System.out.println("INGRESE UNA FUNCION VALIDA (1-3)");
        }
  //===========================================================================================================================================
  //
  //===========================================================================================================================================
    }
     public static void ValidarAsientosVIP(String nombre, int precioEntrada,int funcionSelec, String zonaEntrada, int cantidadEntradas) {
        int asientosSeleccionados = 0;
        
        
        while (asientosSeleccionados < cantidadEntradas) {
            int fila, columna;
            do {
                System.out.println("ingrese una fila(1 a 2)");
                fila = scanner.nextInt();
                System.out.println("Ingrese una columna (1 a 5)");
                columna = scanner.nextInt();

                if (fila <= 0 || fila >= 3 || columna <= 0 || columna >= 6) {
                    System.out.println("ELIJA UNA UBICACION VALIDA");
                } else if (salaVIP[fila][columna].equals("R")) {
                    System.out.println("ESTE ASIENTO YA ESTA RESERVADO, ELIJA OTRO");
                } else if (salaVIP[fila][columna].equals("X")) {
                    System.out.println("ESTE ASIENTO YA ESTA VENDIDO, ELIJA OTRO");
                } else {
                    break;
                }
            } while (true);

            salaVIP[fila][columna] = "X";
            mostrarPlanoVIP();
            
            System.out.println("Ingrese la edad del usuario para esta entrada");
            
            int edad=scanner.nextInt();
            double descuento=0;
            
            if (edad<3){
                System.out.println("Debe ingresar una edad valida");
            }else if (edad<=12){//descuento de niño
                descuento=0.10;
            }else if (edad>=60 && edad<120){ //descuento de adulto mayor
                descuento=0.15;
            }
            int precioFinal=(int)(precioEntrada-(precioEntrada * descuento));
            
            BoletaEntrada boleta = new BoletaEntrada(nombre, fila, columna,funcionSelec, zonaEntrada, edad, precioFinal);
            boleta.mostrarBoleta();
            listadoEntradas.add(boleta);
            asientosSeleccionados++;
            
        }

    }

    public static void ValidarAsientosPlateaBaja(String nombre, int precioEntrada,int funcionSelec, String zonaEntrada, int cantidadEntradas) {
        int asientosSeleccionados = 0;
        
        while (asientosSeleccionados < cantidadEntradas) {
            int fila, columna;
            do {
                System.out.println("ingrese una fila(1 a 4)");
                fila = scanner.nextInt();
                System.out.println("Ingrese una columna (1 a 5)");
                columna = scanner.nextInt();

                if (fila <= 0 || fila >= 5 || columna <= 0 || columna >= 6) {
                    System.out.println("ELIJA UNA UBICACION VALIDA");
                } else if (salaPB[fila][columna].equals("R")) {
                    System.out.println("ESTE ASIENTO YA ESTA RESERVADO, ELIJA OTRO");
                } else if (salaPB[fila][columna].equals("X")) {
                    System.out.println("ESTE ASIENTO YA ESTA VENDIDO, ELIJA OTRO");
                } else {
                    break;
                }
            } while (true);
            salaPB[fila][columna] = "X";
           System.out.println("Ingrese la edad del usuario para esta entrada");
            
            int edad=scanner.nextInt();
            double descuento=0;
            
            if (edad<3){
                System.out.println("Debe ingresar una edad valida");
            }else if (edad<=12){//descuento de niño
                descuento=0.10;
            }else if (edad>=60 && edad<120){ //descuento de adulto mayor
                descuento=0.15;
            }
            int precioFinal=(int)(precioEntrada-(precioEntrada * descuento));
            
            BoletaEntrada boleta = new BoletaEntrada(nombre, fila, columna, funcionSelec, zonaEntrada, edad, precioFinal);
            boleta.mostrarBoleta();
            listadoEntradas.add(boleta);
            asientosSeleccionados++;
            
        }

    }

    public static void ValidarAsientosPlateaAlta(String nombre, int precioEntrada,int funcionSelec, String zonaEntrada, int cantidadEntradas) {
        int asientosSeleccionados = 0;
        while (asientosSeleccionados < cantidadEntradas) {
            int fila, columna;
            do {
                System.out.println("ingrese una fila(1 a 4)");
                fila = scanner.nextInt();
                System.out.println("Ingrese una columna (1 a 5)");
                columna = scanner.nextInt();

                if (fila <= 0 || fila >= 5 || columna <= 0 || columna >= 6) {
                    System.out.println("ELIJA UNA UBICACION VALIDA");
                } else if (salaPA[fila][columna].equals("R")) {
                    System.out.println("ESTE ASIENTO YA ESTA RESERVADO, ELIJA OTRO");
                } else if (salaPA[fila][columna].equals("X")) {
                    System.out.println("ESTE ASIENTO YA ESTA VENDIDO, ELIJA OTRO");
                } else if (salaPA[fila][columna].equals("A")) {
                    System.out.println("ESTE ES EL ASIENTO ACTUAL!");
                    break;
                }
            } while (true);

            salaPA[fila][columna] = "X";
            System.out.println("Ingrese la edad del usuario para esta entrada");
            
            int edad=scanner.nextInt();
            double descuento=0;
            
            if (edad<3){
                System.out.println("Debe ingresar una edad valida");
            }else if (edad<=12){//descuento de niño
                descuento=0.10;
            }else if (edad>=60 && edad<120){ //descuento de adulto mayor
                descuento=0.15;
            }
            int precioFinal=(int)(precioEntrada-(precioEntrada * descuento));
            
            BoletaEntrada boleta = new BoletaEntrada(nombre, fila, columna,funcionSelec, zonaEntrada, edad, precioFinal);
            boleta.mostrarBoleta();
            listadoEntradas.add(boleta);
            asientosSeleccionados++;
            
        }

    }

    public static void ValidarAsientosPalcoA(String nombre, int precioEntrada,int funcionSelec, String zonaEntrada, int cantidadEntradas) {
        int asientosSeleccionados = 0;
        while (asientosSeleccionados < cantidadEntradas) {
            int fila, columna;
            do {
                System.out.println("ingrese una fila(1 a 2)");
                fila = scanner.nextInt();
                System.out.println("Ingrese una columna (1 a 4)");
                columna = scanner.nextInt();

                if (fila <= 0 || fila >= 3 || columna <= 0 || columna >= 6) {
                    System.out.println("ELIJA UNA UBICACION VALIDA");
                } else if (salaPalcoA[fila][columna].equals("R")) {
                    System.out.println("ESTE ASIENTO YA ESTA RESERVADO, ELIJA OTRO");
                } else if (salaPalcoA[fila][columna].equals("X")) {
                    System.out.println("ESTE ASIENTO YA ESTA VENDIDO, ELIJA OTRO");
                } else {
                    break;
                }
            } while (true);

            salaPalcoA[fila][columna] = "X";
            mostrarPlanoPalcoA();
           System.out.println("Ingrese la edad del usuario para esta entrada");
            
            int edad=scanner.nextInt();
            double descuento=0;
            
            if (edad<3){
                System.out.println("Debe ingresar una edad valida");
            }else if (edad<=12){//descuento de niño
                descuento=0.10;
            }else if (edad>=60 && edad<120){ //descuento de adulto mayor
                descuento=0.15;
            }
            int precioFinal=(int)(precioEntrada-(precioEntrada * descuento));            
            BoletaEntrada boleta = new BoletaEntrada(nombre, fila, columna, funcionSelec, zonaEntrada, edad, precioFinal);
            boleta.mostrarBoleta();
            listadoEntradas.add(boleta);
            asientosSeleccionados++;           
        }
    }
    public static void ValidarAsientosPalcoB(String nombre, int precioEntrada,int funcionSelec, String zonaEntrada, int cantidadEntradas) {
        int asientosSeleccionados = 0;
        while (asientosSeleccionados < cantidadEntradas) {
            int fila, columna;
            do {
                System.out.println("ingrese una fila(1 a 2)");
                fila = scanner.nextInt();
                System.out.println("Ingrese una columna (1 a 4)");
                columna = scanner.nextInt();

                if (fila <= 0 || fila >= 3 || columna <= 0 || columna >= 6) {
                    System.out.println("ELIJA UNA UBICACION VALIDA");
                } else if (salaPalcoB[fila][columna].equals("R")) {
                    System.out.println("ESTE ASIENTO YA ESTA RESERVADO, ELIJA OTRO");
                } else if (salaPalcoB[fila][columna].equals("X")) {
                    System.out.println("ESTE ASIENTO YA ESTA VENDIDO, ELIJA OTRO");
                } else {
                    break;
                }
            } while (true);

            salaPalcoB[fila][columna] = "X";
            mostrarPlanoPalcoB();
           System.out.println("Ingrese la edad del usuario para esta entrada");
            int edad=scanner.nextInt();
            double descuento=0;
            
            if (edad<3){
                System.out.println("Debe ingresar una edad valida");
            }else if (edad<=12){//descuento de niño
                descuento=0.10;
            }else if (edad>=60 && edad<120){ //descuento de adulto mayor
                descuento=0.15;
            }
            int precioFinal=(int)(precioEntrada-(precioEntrada * descuento));
            
            BoletaEntrada boleta = new BoletaEntrada(nombre, fila, columna,funcionSelec, zonaEntrada, edad, precioFinal);
            boleta.mostrarBoleta();
            listadoEntradas.add(boleta);
            asientosSeleccionados++;   
        }
    }

//=====================================================================================================        
    public static void ValidarReservaAsientosVIP(String nombre, int precioEntrada,int funcionSelec, String zonaEntrada, int cantidadEntradas) {
        int asientosSeleccionados = 0;
        while (asientosSeleccionados < cantidadEntradas) {
            int fila, columna;
            do {
                System.out.println("ingrese una fila(1 a 2)");
                fila = scanner.nextInt();
                System.out.println("Ingrese una columna (1 a 5)");
                columna = scanner.nextInt();

                if (fila <= 0 || fila >= 3 || columna <= 0 || columna >= 6) {
                    System.out.println("ELIJA UNA UBICACION VALIDA");
                } else if (salaVIP[fila][columna].equals("R")) {
                    System.out.println("ESTE ASIENTO YA ESTA RESERVADO, ELIJA OTRO");
                } else if (salaVIP[fila][columna].equals("X")) {
                    System.out.println("ESTE ASIENTO YA ESTA VENDIDO, ELIJA OTRO");
                } else {
                    break;
                }
            } while (true);
            salaVIP[fila][columna] = "R";
            mostrarPlanoVIP();
            System.out.println("Ingrese la edad del usuario para esta entrada");           
            int edad=scanner.nextInt();
            double descuento=0;           
            if (edad<3){
                System.out.println("Debe ingresar una edad valida");
            }else if (edad<=12){//descuento de niño
                descuento=0.10;
            }else if (edad>=60 && edad<120){ //descuento de adulto mayor
                descuento=0.15;
            }
            int precioFinal=(int)(precioEntrada-(precioEntrada * descuento));
            
            BoletaEntrada boleta = new BoletaEntrada(nombre, fila, columna,funcionSelec, zonaEntrada, edad, precioFinal);
            boleta.mostrarBoleta();
            listadoEntradas.add(boleta);
            asientosSeleccionados++;
            
        }

    }

    public static void ValidarReservaAsientosPlateaBaja(String nombre, int precioEntrada,int funcionSelec, String zonaEntrada, int cantidadEntradas) {
        int asientosSeleccionados = 0;
        
        while (asientosSeleccionados < cantidadEntradas) {
            int fila, columna;
            do {
                System.out.println("ingrese una fila(1 a 4)");
                fila = scanner.nextInt();
                System.out.println("Ingrese una columna (1 a 5)");
                columna = scanner.nextInt();

                if (fila <= 0 || fila >= 5 || columna <= 0 || columna >= 6) {
                    System.out.println("ELIJA UNA UBICACION VALIDA");
                } else if (salaPB[fila][columna].equals("R")) {
                    System.out.println("ESTE ASIENTO YA ESTA RESERVADO, ELIJA OTRO");
                } else if (salaPB[fila][columna].equals("X")) {
                    System.out.println("ESTE ASIENTO YA ESTA VENDIDO, ELIJA OTRO");
                } else {
                    break;
                }
            } while (true);
            salaPB[fila][columna] = "R";
           System.out.println("Ingrese la edad del usuario para esta entrada");
            
            int edad=scanner.nextInt();
            double descuento=0;
            
            if (edad<3){
                System.out.println("Debe ingresar una edad valida");
            }else if (edad<=12){//descuento de niño
                descuento=0.10;
            }else if (edad>=60 && edad<120){ //descuento de adulto mayor
                descuento=0.15;
            }
            int precioFinal=(int)(precioEntrada-(precioEntrada * descuento));
            
            BoletaEntrada boleta = new BoletaEntrada(nombre, fila, columna, funcionSelec, zonaEntrada, edad, precioFinal);
            boleta.mostrarBoleta();
            listadoEntradas.add(boleta);
            asientosSeleccionados++;
            
        }

    }

    public static void ValidarReservaAsientosPlateaAlta(String nombre, int precioEntrada,int funcionSelec, String zonaEntrada, int cantidadEntradas) {
        int asientosSeleccionados = 0;
        while (asientosSeleccionados < cantidadEntradas) {
            int fila, columna;
            do {
                System.out.println("ingrese una fila(1 a 4)");
                fila = scanner.nextInt();
                System.out.println("Ingrese una columna (1 a 5)");
                columna = scanner.nextInt();

                if (fila <= 0 || fila >= 5 || columna <= 0 || columna >= 6) {
                    System.out.println("ELIJA UNA UBICACION VALIDA");
                } else if (salaPA[fila][columna].equals("R")) {
                    System.out.println("ESTE ASIENTO YA ESTA RESERVADO, ELIJA OTRO");
                } else if (salaPA[fila][columna].equals("X")) {
                    System.out.println("ESTE ASIENTO YA ESTA VENDIDO, ELIJA OTRO");
                } else {
                    break;
                }
            } while (true);

            salaPA[fila][columna] = "R";
            System.out.println("Ingrese la edad del usuario para esta entrada");
            
            int edad=scanner.nextInt();
            double descuento=0;
            
            if (edad<3){
                System.out.println("Debe ingresar una edad valida");
            }else if (edad<=12){//descuento de niño
                descuento=0.10;
            }else if (edad>=60 && edad<120){ //descuento de adulto mayor
                descuento=0.15;
            }
            int precioFinal=(int)(precioEntrada-(precioEntrada * descuento));
            
            BoletaEntrada boleta = new BoletaEntrada(nombre, fila, columna,funcionSelec, zonaEntrada, edad, precioFinal);
            boleta.mostrarBoleta();
            listadoEntradas.add(boleta);
            asientosSeleccionados++;
            
        }

    }

    public static void ValidarReservaAsientosPalcoA(String nombre, int precioEntrada,int funcionSelec, String zonaEntrada, int cantidadEntradas) {
        int asientosSeleccionados = 0;
        while (asientosSeleccionados < cantidadEntradas) {
            int fila, columna;
            do {
                System.out.println("ingrese una fila(1 a 2)");
                fila = scanner.nextInt();
                System.out.println("Ingrese una columna (1 a 4)");
                columna = scanner.nextInt();

                if (fila <= 0 || fila >= 3 || columna <= 0 || columna >= 6) {
                    System.out.println("ELIJA UNA UBICACION VALIDA");
                } else if (salaPalcoA[fila][columna].equals("R")) {
                    System.out.println("ESTE ASIENTO YA ESTA RESERVADO, ELIJA OTRO");
                } else if (salaPalcoA[fila][columna].equals("X")) {
                    System.out.println("ESTE ASIENTO YA ESTA VENDIDO, ELIJA OTRO");
                } else {
                    break;
                }
            } while (true);

            salaPalcoA[fila][columna] = "R";
            mostrarPlanoPalcoA();
           System.out.println("Ingrese la edad del usuario para esta entrada");
            
            int edad=scanner.nextInt();
            double descuento=0;
            
            if (edad<3){
                System.out.println("Debe ingresar una edad valida");
            }else if (edad<=12){//descuento de niño
                descuento=0.10;
            }else if (edad>=60 && edad<120){ //descuento de adulto mayor
                descuento=0.15;
            }
            int precioFinal=(int)(precioEntrada-(precioEntrada * descuento));
            
            BoletaEntrada boleta = new BoletaEntrada(nombre, fila, columna, funcionSelec, zonaEntrada, edad, precioFinal);
            boleta.mostrarBoleta();
            listadoEntradas.add(boleta);
            asientosSeleccionados++;
            
        }

    }

    public static void ValidarReservaAsientosPalcoB(String nombre, int precioEntrada,int funcionSelec, String zonaEntrada, int cantidadEntradas) {
        int asientosSeleccionados = 0;
        while (asientosSeleccionados < cantidadEntradas) {
            int fila, columna;
            do {
                System.out.println("ingrese una fila(1 a 2)");
                fila = scanner.nextInt();
                System.out.println("Ingrese una columna (1 a 4)");
                columna = scanner.nextInt();

                if (fila <= 0 || fila >= 3 || columna <= 0 || columna >= 6) {
                    System.out.println("ELIJA UNA UBICACION VALIDA");
                } else if (salaPalcoB[fila][columna].equals("R")) {
                    System.out.println("ESTE ASIENTO YA ESTA RESERVADO, ELIJA OTRO");
                } else if (salaPalcoB[fila][columna].equals("X")) {
                    System.out.println("ESTE ASIENTO YA ESTA VENDIDO, ELIJA OTRO");
                } else {
                    break;
                }
            } while (true);

            salaPalcoB[fila][columna] = "R";
            mostrarPlanoPalcoB();
           System.out.println("Ingrese la edad del usuario para esta entrada");
            int edad=scanner.nextInt();
            double descuento=0;
            
            if (edad<3){
                System.out.println("Debe ingresar una edad valida");
            }else if (edad<=12){//descuento de niño
                descuento=0.10;
            }else if (edad>=60 && edad<120){ //descuento de adulto mayor
                descuento=0.15;
            }
            int precioFinal=(int)(precioEntrada-(precioEntrada * descuento));
            
            BoletaEntrada boleta = new BoletaEntrada(nombre, fila, columna,funcionSelec, zonaEntrada, edad, precioFinal);
            boleta.mostrarBoleta();
            listadoEntradas.add(boleta);
            asientosSeleccionados++;   
        }
    }
//==================================================================================================================================================== 
// MENU 3: BUSCAR ENTRADAS
//====================================================================================================================================================   
    static void buscarEntradas() {
        System.out.println("INGRESE EL CODIGO DE ENTRADA");
        scanner.nextLine();
        String codigoABuscar = scanner.nextLine();
        boolean encontrar = false;
        for (BoletaEntrada e : listadoEntradas) {
            if (e.codigo.equals(codigoABuscar)) {
                System.out.println("ENTRADA ENCONTRADA!");
                System.out.println("===============BOLETA===============");
                System.out.println("| NOMBRE CLIENTE:.........." + e.nombre);
                System.out.println("| FUNCION:................."+e.funcionSelec);
                System.out.println("| ASIENTO  FILA: " + e.fila + " | COLUMNA: " + e.columna);
                System.out.println("| CODIGO DE BOLETA:........" + e.codigo);
                System.out.println("| TOTAL:."+e.precioFinal);
                encontrar = true;
            }
        }
        if (!encontrar) {
            System.out.println("NO SE HA ENCONTRADO LA ENTRADA");
        }
    }
//==================================================================================================================================================== 
// MENU 4: ANULAR ENTRADAS
//====================================================================================================================================================   
    static void anularEntrada() {

        System.out.println("Ingrese el codigo de la entrada que desea anular");
        scanner.nextLine();
        String codigo = scanner.nextLine();

        for (int i = 0; i < listadoEntradas.size(); i++) {
            BoletaEntrada e = listadoEntradas.get(i);
            
            if (e.codigo.equals(codigo)) {
                switch (e.zonaEntrada.toUpperCase()) {
                    case "VIP":
                        salaVIP[e.fila][e.columna]="D";
                        break;
                    case "PLATEA BAJA":
                        salaPB[e.fila][e.columna]="D";
                        break;
                    case "PLATEA ALTA":
                        salaPA[e.fila][e.columna]="D";
                        break;
                    case "PALCO A":
                        salaPalcoA[e.fila][e.columna]="D";
                        break;
                    case "PALCO B":
                        salaPalcoB[e.fila][e.columna]="D";
                        break;
                    default:
                        System.out.println("DATOS INCORRECTOS, VERIFIQUE LA INFORMACION.");
                }
                System.out.println("Se te devolvera el dinero de la entrada anulada : $"+e.precioFinal);
                listadoEntradas.remove(i);
                System.out.println("LA ENTRADA HA SIDO ANULADA, EL ASIENTO HA VUELTO A ESTAR DISPONIBLE");
                return;
            }
        }
        System.out.println("No se ha encontrado la entrada.");
    }
//==================================================================================================================================================== 
// MENU 5: PAGAR RESERVAS 
//==================================================================================================================================================== 
    static void pagoReservas() {
        System.out.println("INGRESE EL CODIGO DE RESERVA");
        scanner.nextLine();
        String codigoABuscar = scanner.nextLine();
        boolean encontrar = false;
        for (BoletaEntrada e : listadoEntradas) {
            if (e.codigo.equals(codigoABuscar)) {
                System.out.println("ENTRADA ENCONTRADA!");
                System.out.println("===============BOLETA===============");
                System.out.println("| NOMBRE CLIENTE:.........." + e.nombre);
                System.out.println("| FUNCION:................." + e.funcionSelec);
                System.out.println("| Zona Teatro:............."+e.zonaEntrada);
                System.out.println("| ASIENTO  FILA: " + e.fila + " | COLUMNA: " + e.columna);
                System.out.println("| CODIGO DE BOLETA:........" + e.codigo);
                System.out.println("| TOTAL:." + e.precioFinal);
                int precioFinal = e.precioFinal;
                encontrar = true;

                if (!encontrar) {
                    System.out.println("NO SE HA ENCONTRADO LA ENTRADA");
                }

                if (e.codigo.equals(codigoABuscar)) {
                    switch (e.zonaEntrada.toUpperCase()) {
                        case "VIP":
                            salaVIP[e.fila][e.columna] = "X";
                            break;
                        case "PLATEA BAJA":
                            salaPB[e.fila][e.columna] = "X";
                            break;
                        case "PLATEA ALTA":
                            salaPA[e.fila][e.columna] = "X";
                            break;
                        case "PALCO A":
                            salaPalcoA[e.fila][e.columna] = "X";
                            break;
                        case "PALCO B":
                            salaPalcoB[e.fila][e.columna] = "X";
                            break;
                        default:
                            System.out.println("DATOS INCORRECTOS, VERIFIQUE LA INFORMACION.");
                    }
                    
                    System.out.println("Como realiza el pago?");
                    System.out.println(" (1)-Tarjeta     (2)-Efectivo");
                    int opcionPago = scanner.nextInt();
                    while (opcionPago <= 0 || opcionPago >= 3) {
                        System.out.println("Debe ingresar una opcion valida (1-2)");
                    }
                    if (opcionPago == 1) {
                        System.out.println("REALIZANDO PAGO CON TARJETA...");
                        System.out.println("LA ENTRADA HA SIDO PAGADA");
                        System.out.println("Gracias por su compra");
                        System.out.println("Necesita realizar otra gestion?");
                        System.out.println("(1)Si    (2)No");
                        int opcionNueva=0;
                        opcionNueva=scanner.nextInt();
                        if (opcionNueva==1){
                            System.exit(1);
                        }else if (opcionNueva==2){
                            System.out.println("Que disfrute su funcion!");
                            System.exit(2);
                        }
                    } else if (opcionPago == 2) {
                        System.out.println("Ingrese la cantidad de dinero (SIN PUNTOS NI COMAS)");
                        int dineroIngresado = scanner.nextInt();
                        while (dineroIngresado < precioFinal) {
                            System.out.println("Dinero insuficiente, intente denuevo");
                            dineroIngresado = scanner.nextInt();
                        }
                        if (dineroIngresado > precioFinal) {
                            System.out.println("LA RESERVA HA SIDO PAGADA");
                            System.out.println("Gracias por su compra, a continuacion se muestra su vuelto:");
                            System.out.println("Vuelto: $" + (dineroIngresado-precioFinal));
                            System.out.println("Que disfrute su funcion!");
                            
                    return;
                }
                
                    }
                }
            }
        }
    }
//==================================================================================================================================================== 
// MENU 8: ADMINISTRADOR
//==================================================================================================================================================== 
    static void menuAdministrador(){
        int entradasVendidas=0;
        int entradasReservadas=0;
        int entradasAnuladas=0;
        int totalRecaudado=0;
        
        for (BoletaEntrada boleta : listadoEntradas){
            if(boleta.getEstado().equalsIgnoreCase("vendido")){
                entradasVendidas++;
                totalRecaudado+=boleta.getPrecio();
            }else if (boleta.getEstado().equalsIgnoreCase("reservado")){
                entradasReservadas++;
            }else if (boleta.getEstado().equalsIgnoreCase("anulado")){
                entradasAnuladas++;
                totalRecaudado-=(boleta.getPrecio()-(boleta.getPrecio()* 0.15));
            }
        }
        System.out.println("=============== MENU ADMINISTRADOR ================");
        System.out.println(" Entradas vendidas: "+entradasVendidas);
        System.out.println(" Entradas reservadas: "+entradasReservadas);
        System.out.println(" Entradas anuladas: "+entradasAnuladas);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" Total Recaudado: $"+totalRecaudado);
    }
}

