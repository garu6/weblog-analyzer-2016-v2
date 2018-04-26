import java.util.ArrayList;
public class Acceso
{
    // La direccion ip del cliente que realiza el acceso
    private String ip;
    
    // Los datos de la fecha del acceso
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    private String cadena;
    // La direccion web a la que accede el cliente
    private String url;
    
    // El codigo de respuesta HTTP del servidor
    private int Http;

    /**
     * Constructor para objetos de la clase Acceso. Recibe un String con los
     * datos del acceso y los almacena en los atributos de la clase.
     * 
     * @param  datos  Los datos del acceso en formato "91.244.73.61 [2016 01 01 10 56] instituto/normativa.html 403" 
     */
    public Acceso(String cadena)
    {
        this.cadena = cadena;
        String[] datosAcceso = cadena.split(" ");

        if(cadena.matches(".*\\[.*\\].*")){
            this.ip = datosAcceso[0];
            this.ano = Integer.parseInt(datosAcceso[1].substring(1,4));
            this.mes = Integer.parseInt(datosAcceso[2]);
            this.dia = Integer.parseInt(datosAcceso[3]);
            this.hora = Integer.parseInt(datosAcceso[4]);
            this.minutos = Integer.parseInt(datosAcceso[5].substring(0,1));
            this.url = datosAcceso[6];
            this.Http = Integer.parseInt(datosAcceso[7]);
        }
        else{
            this.ano = Integer.parseInt(datosAcceso[0]);
            this.mes = Integer.parseInt(datosAcceso[1]);
            this.dia = Integer.parseInt(datosAcceso[2]);
            this.hora = Integer.parseInt(datosAcceso[3]);
            this.minutos = Integer.parseInt(datosAcceso[4]);
        }
    }
    
    public int getAno() 
    {

        String [] separado = cadena.split(" ");
 
        String caracter = separado[0];
        ano = Integer.parseInt(caracter);
        return ano;
    }
    
    public int getMes()
    {
        String [] separado = cadena.split(" ");
 
        String caracter = separado[1];
        mes = Integer.parseInt(caracter);
        
        return mes;
    }
    
    public int getDia()
    {
        String [] separado = cadena.split(" ");
 
        String caracter = separado[2];
        dia = Integer.parseInt(caracter);
        return dia;
    }
    
    public int getHora()
    {
       
        return hora;
    }
    
    public int getMinutos()
    {
        String [] separado = cadena.split(" ");
 
        String caracter = separado[4];
        minutos = Integer.parseInt(caracter);
        return minutos;
    }
}