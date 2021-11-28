// You can experiment here, it won’t be checked

import java.util.HashSet;
import java.util.Set;

public class Task {
  public static void main(String[] args) {
    // put your code here

    for (double max_load_factor : new double[]{0.3, 0.5, 0.6, 0.8}) {
      double num_buckets = 2d;
      double current_load_factor;

      for (int i = 1; i <= 3; i++) {
        current_load_factor = i / num_buckets;
        if (current_load_factor > max_load_factor)
          num_buckets *= 2;
      }
      if (num_buckets == 8.0)
        System.out.println(max_load_factor);
    }
    Set<Integer> set = new HashSet<>(Set.of(1, 2, 3, 4));
    set.retainAll(Set.of(2, 3, 4, 5));
    set.removeAll(Set.of(1, 2));
    System.out.println(set);

    String qualifier = "[0-9a-f]{8}-[0-9a-f]{4}-4[0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}";
    String[] words = {"1c1a3de4-c711-4e9c-bed2-e75fd69ce920", "ad9e03f0-4bd4-46db-k79e-94ca17d4b74f",
            "f087d9fc-xyz3-4a3f-93e0-bdb8d9b68268", "92ae7a-94f-40c-a22-de4b42dd13", "f66024c3_50f8_442e_9387_28746581f472"};

    for (String word : words) {
      if (word.matches(qualifier)) {
        System.out.println(word);
      }
    }
  }
}
