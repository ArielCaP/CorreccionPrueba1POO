package org.example;

public class TarjetaMetro {
       public static final double TARIFA_GENERAL=0.45;
       private String titular;
       private String cedula;
       private int edad;
       private boolean tieneDiscapacidad;
       private double saldo;
       private int viajesRealizados;
       private double totalRecargado;

        public TarjetaMetro() {
                this.titular="ANONIMO";
                this.cedula="1111111111";
                this.edad=30;
                this.tieneDiscapacidad=false;
                this.saldo=0;
        }

        public TarjetaMetro(String titular, String cedula, int edad,double saldoInicial, boolean tieneDiscapacidad) {
                setTitular(titular);
                setCedula(cedula);
                setEdad(edad);
                setTieneDiscapacidad(tieneDiscapacidad);
                if(saldoInicial>=0 && saldoInicial<=40){
                        this.saldo=saldoInicial;
                }else {
                        System.out.println("El saldo debe ser entre 1 y 40 dolares maximo");
                        this.saldo=0;
                }
        }

        public String getTitular() {
                return titular;
        }

        public String getCedula() {
                return cedula;
        }

        public int getEdad() {
                return edad;
        }

        public boolean isTieneDiscapacidad() {
                return tieneDiscapacidad;
        }

        public double getSaldo() {
                return saldo;
        }

        public int getViajesRealizados() {
                return viajesRealizados;
        }

        public double getTotalRecargado() {
                return totalRecargado;
        }

        public void setTitular(String titular) {
                if(titular!=null && !titular.isBlank()){
                        this.titular=titular.strip();
                }else{
                        System.out.println("Titular no valido");
                        this.titular="SinNombre";
                }
        }

        public void setCedula(String cedula) {
                if(cedula!=null && cedula.length()==10){
                        this.cedula=cedula;
                }else {
                        System.out.println("Cedula no valido");
                        this.cedula="0000000000";
                }
        }

        public void setEdad(int edad) {
                if(edad>=5&&edad<=110){
                        this.edad=edad;
                }else{
                        System.out.println("Edad es invalida");
                        this.edad=18;
                }
        }

        public void setTieneDiscapacidad(boolean tieneDiscapacidad) {
                this.tieneDiscapacidad = tieneDiscapacidad;
        }
        public static void mostrarTarifas() {
                System.out.println("===== TARIFAS DEL METRO DE QUITO =====");
                System.out.println("Persona con discapacidad ........ $0.10 (tiene prioridad sobre la edad)");
                System.out.println("De 5 a 17 anios o 65 en adelante  $0.22 (tarifa reducida)");
                System.out.println("Resto de usuarios ............... $0.45 (tarifa general)");
                System.out.println();
                System.out.println("===== REGLAS DE RECARGA =====");
                System.out.println("- Cada recarga debe ser de $1.00 a $20.00");
                System.out.println("- El saldo total no puede superar $40.00");
                System.out.println("- Un viaje se permite si el saldo es mayor o igual a la tarifa");
                System.out.println("======================================");
        }

        public double calcularTarifa(){
                if(tieneDiscapacidad){
                        return 0.10;
                }else if((edad>=5&& edad<=17) || edad>=65){
                        return 0.22;
                }else{
                        return TARIFA_GENERAL;
                }
        }
        public double calcularViajesDisponibles(){
                return saldo/calcularTarifa();
        }

        public double calcularViajesDisponibles(double montoAdicional){
                return (saldo+montoAdicional)/calcularTarifa();
        }
        public boolean recargar(double monto){
                if(monto<1 || monto>20){
                        System.out.println("MONTO NO PERMITIDO");
                        return false;
                }
                if (saldo+monto>40){
                        System.out.println("SUPERA EL MAXIMO DE SALDO");
                        return false;

                }
                saldo+=monto;
                totalRecargado+=monto;
                System.out.println("Recarga exitosa.");
                return true;
        }
        public boolean pagarViaje(){
                if(saldo>=calcularTarifa()){
                        System.out.println("ACCESO PERMITIDO");
                        viajesRealizados++;
                        saldo-=calcularTarifa();
                        return true;
                }else {
                        System.out.println("SALDO INSUFICIENTE");
                        return false;
                }
        }
        public void mostrarInformacion(){
                System.out.println("INFORMACION DE LA TARJETA------");
                System.out.println("Titular: "+ titular);
                System.out.println("Cedula: "+ cedula);
                System.out.println("Edad: "+ edad);
                if (tieneDiscapacidad){
                        System.out.println("Discapacidad: si");
                }else{
                        System.out.println("Discapacidad: no");
                }
                System.out.println("Tarifa aplicada: "+ calcularTarifa());
                System.out.println("Saldo: "+ saldo);
                System.out.println("Viajes Relizados: "+viajesRealizados);
                System.out.println("=====================================");
        }


}

