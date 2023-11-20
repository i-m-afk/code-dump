import java.util.*;

public class BinarySearch {
  static int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }

  static int firstOccurrence(int[] nums, int target, int low, int high) {
    while (low <= high) {
      int mid = (low + high) / 2;
      if (nums[mid] == target) {
        if (nums[mid - 1] == -1 || nums[mid - 1] != target) {
          return mid;
        }
        // go left
        firstOccurrence(nums, target, low, mid - 1);
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  // TODO: static int lastOccurence(int[] nums, int target) {}

  public static void main(String[] args) {
    int nums[] = {1, 3, 5, 21, 21, 21, 69};
    System.out.println(search(nums, 69));
    System.out.println(search(nums, 3));
    System.out.println(search(nums, 13));

    System.out.println(firstOccurrence(nums, 21, 0, nums.length - 1));
  }
}
