package Montecarlo_Difusion;
import java.util.*;

public class Difusion_Montecarlo {
    private int N1; //Moleculas en el recipiente A
    private int N2; //Moleculas en el recipiente B
    private int t; //timepo

    private Random rnd=new Random();//números aleatorios

    public Difusion_Montecarlo(int N1, int N2) { //metodo constructor
        this.N1=N1;
        this.N2=N2;
        t=0;//contador tiempo en cero
    }
    public int getParticulasIzq(){return N1;}
    public int getParticulasDcha(){return N2;}

    public int evolucion(int dt){//calcula el estado del sistema cada cierto intervalo de tiempo dt
    //Funcion mienbro calcula el numero de particulas en cada recipiente A Y B
    //en funcion del tiempo
    //de acuerdo con el resultado del sorteo de una variable aleatoria g 
    //uniformemente distribuida en el intervalo [0, 1).
        double p;//Calculamos la probabilidad p 
        //na partícula pase del recipiente A al B
        //sta probabilidad es proporcional al número N1 de partículas del recipiente A.
        for(int i=0; i<dt; i++){
            p=(double)N1/(N1+N2);//
            if(rnd.nextDouble()<p){
                N1--;   N2++;
            }else{
                N1++;   N2--;
            }
        }
        t+=dt;
        return N1;
    }
    public static void main(String[] args) {
        int dt=10; //observar cada 10 unidades de tiempo
        int N=500; //número inicial de partículas en cada recipiente  
        Difusion_Montecarlo dif=new Difusion_Montecarlo(N, 0);//se crea el objeto
        System.out.println("tiempo \t izquierda \t derecha");
        int n1=N;
        int i=0;
        System.out.println(" "+i*dt+ " \t "+n1+" \t \t"+(N-n1));//estado del sistema en el instante i*dt
        //número de partículas del recipiente A, y el número N-N1 de partículas en el recipiente B.
        for(i=1; i<20; i++){
            n1=dif.evolucion(dt);
            System.out.println(" "+i*dt+ " \t "+n1+" \t \t"+(N-n1));//estado del sistema en el instante i*dt
        }
        try  {
//espera la pulsación de una tecla y luego RETORNO
            System.in.read();
        }catch (Exception ex) {  }
    }
}




