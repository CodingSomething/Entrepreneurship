public class Information{
  private static String intense = "light";
  private static int type;

  public static String getIntensity(){
    return intense;
    
  }
  public static void setIntensity(String a){
    intense = a;
  }
  public static int getType(){
    return type;
  }
  public static void setType(int i){
    type = i;
  }
}