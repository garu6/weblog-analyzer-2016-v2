import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> accesos;
    private boolean antes;
    
    public AnalizadorAccesosAServidor() 
    {
        accesos = new ArrayList<>();
        antes = false;
    }
    
    
    public void analizarArchivoDeLog(String archivo)
    {
        
        accesos.clear();
        File archivoALeer = new File(archivo);
        try {
            Scanner sc = new Scanner(archivoALeer);
            while (sc.hasNextLine()) {
                String lineaLeida = sc.nextLine();               
                String[] elementosLinea = lineaLeida.split(" ");
                Acceso accesoActual = new Acceso(lineaLeida);
                                                            
                
                accesos.add(accesoActual);
            }
            antes = true;
            sc.close();
            
        }
        catch (Exception e) {
            System.out.println("Ocurrio algun error al leer el archivo.");
        }
    }
    
    
    public int obtenerHoraMasAccesos() 
    {
        int valorADevolver = -1;
        
        if (!accesos.isEmpty()) {
            int[] accesosPorHora = new int[24];
    
            for (Acceso accesoActual : accesos) {
                int horaAccesoActual = accesoActual.getHora();
                accesosPorHora[horaAccesoActual] = accesosPorHora[horaAccesoActual] + 1;
            }
            
            int numeroDeAccesosMasAlto = accesosPorHora[0];
            int horaDeAccesosMasAlto = 0;
            for (int i = 0; i < accesosPorHora.length; i++) {
                if (accesosPorHora[i] >= numeroDeAccesosMasAlto) {
                    numeroDeAccesosMasAlto = accesosPorHora[i];
                    horaDeAccesosMasAlto = i;
                }
            }
            
            valorADevolver = horaDeAccesosMasAlto;                      
        }
        
        return valorADevolver;
    }

    
    
    public String paginaWebMasSolicitada() 
    {
        String resultado = "";
        
        HashMap<String,Integer> webs = new HashMap<>();
        if (antes){

    
            for (Acceso accesoActual : accesos) {
               if (webs.containsKey(accesoActual.getUrl())){
                   webs.replace(accesoActual.getUrl(),webs.get(accesoActual.getUrl())+1);
                   
                }else{
                    webs.put(accesoActual.getUrl(),1);
                    
                }
            }
            
            int maximoVisitas =0;
            
            for (String url : webs.keySet()){
                if (webs.get(url) >= maximoVisitas){
                    maximoVisitas = webs.get(url);
                    resultado = url;
                }
                
                
            }
            
                           
            
            
        }else{
            System.out.println("no tengo datos con los que trabajar mete un archivo");
            resultado=null;
            
        }
        
        return resultado;
    }
    
    public String clienteConMasAccesosExitosos()
    {
        String resultado = "";
        
        HashMap<String,Integer> ips = new HashMap<>();
        if (antes){

    
            for (Acceso accesoActual : accesos) {
               if  (accesoActual.getHttp() == 200){
               if (ips.containsKey(accesoActual.getIp())){
                   ips.replace(accesoActual.getIp(),ips.get(accesoActual.getIp())+1);
                   
                }else{
                    ips.put(accesoActual.getIp(),1);
                    
                }
            }
            
            int maximoAccesos =0;
            resultado = "192.168.1.0";
            for (String ip : ips.keySet()){
                if (ip.compareTo(resultado) > 0 && ips.get(ip) >= maximoAccesos || ips.get(ip) > maximoAccesos){
                    maximoAccesos = ips.get(ip);
                    resultado = ip;
                }
                
                
            }
            
                           
            
        }  
        }else{
            System.out.println("no tengo datos con los que trabajar mete un archivo");
            resultado=null;
            
        }
        
        return resultado;
    }


}
