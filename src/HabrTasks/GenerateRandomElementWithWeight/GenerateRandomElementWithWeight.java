package HabrTasks.GenerateRandomElementWithWeight;

public class GenerateRandomElementWithWeight {
   private int[] valuesArr;
   private int[] weightsArr;
   public GenerateRandomElementWithWeight(int[] valuesArr, int[] weightsArr){
      this.valuesArr = valuesArr;
      this.weightsArr = weightsArr;
   }
   public int getRandValue(){
      int sum_weight = 0;
      int count = 0;
      int n = 0;

      for (int i: weightsArr) {
         sum_weight += i;
      }

      int rand = (int) ((int)sum_weight* Math.random());


      while (n < sum_weight){
         count += weightsArr[n];
         if(count >= rand ){
            break;
         }
         n++;
      }

      return valuesArr[n];
   }
}
