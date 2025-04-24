public class Familia extends Departamentos{
    public Familia(int id, double areaMetrosCuadrados,double valorCompra,String direccion,int numHabitaciones,int numBanos, float administracion){
        super(id, areaMetrosCuadrados, valorCompra, direccion, numHabitaciones, numBanos, administracion);
    }
    public void mostrarInfo(){
        super.mostrarInfo();
    }
}
