import java.util.Arrays;
import java.util.Comparator;

public class MyUtils {

  private static void sortbyColumn(int arr[][]) {

    Arrays.sort(arr, new Comparator<int[]>() {

      @Override
      public int compare(final int[] entry1, final int[] entry2) {

        int a = entry1.length == 0 ? 0 : entry1[0];
        int b = entry2.length == 0 ? 0 : entry2[0];

        if (a < b) {
          return 1;
        } else if (a > b) {
          return -1;
        } else {

          int c = entry1.length == 1 ? 0 : entry1[1];
          int d = entry2.length == 1 ? 0 : entry2[1];

          if (c > d) {
            return 1;
          } else if (c < d) {
            return -1;
          }
        }
        return 0;
      }
    });
  }

  public int[][] arrSort(int[][] arr) {

    sortbyColumn(arr);
    return arr;
  }
}
