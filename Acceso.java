import java.util.ArrayList;
public class Acceso
{
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    private String cadena;

    
    public Acceso(String cadena)
    {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.cadena=cadena;
        this.minutos = minutos;

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
        String [] separado = cadena.split(" ");
 
        String dos = separado[3];
        hora = Integer.parseInt(dos);
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