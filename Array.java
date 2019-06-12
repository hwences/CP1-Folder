public class array{
  public static void main(String[] args){
    int[] array = new int[20];
    for(int i = 0; i < array.length; i++){
      int x = (int)((Math.random()* 100) + 1);
      array[i] = x;
    }
    for(int i = 0; i < array.length; i++){
      System.out.println(array[i]);
    }
  }
}