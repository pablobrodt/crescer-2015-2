
public class Contador
{
  private static int qtdElfos;
  
  public static void addElfo(){
      qtdElfos++;
  }
  
  public static int getQtdElfos(){
      return qtdElfos;
  }
  
  public static void resetar(){
      qtdElfos = 0;
  }
}
