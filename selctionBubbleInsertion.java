import java.util.Random;
class selctionBubbleInsertion {

	public static void main(String[] args) {
		int[] a = {3,1,6,7,1,2};
		int[] b = {8,3,7,8,7,1,0};
		runSort(a);
		runSort(b);
		runSort(randomArray());
	}

	public static int[] randomArray(){
		Random r = new Random();
		int[] ans = new int[r.nextInt(10)];
		for (int i = 0; i<ans.length; i++) {
			ans[i] = r.nextInt(10);
		}
		return ans;
	}

	public static int[] selcectionSort(int[] arr){
		System.out.println("Selection Sort:");
		printArray(arr);
		int storage;
		int min;
		for (int i = 0; i<arr.length; i++) {
			storage = arr[i];
			min = i;
			for (int k = i; k<arr.length; k++) {
				if(arr[k] < storage){
					storage = arr[k];
					min = k;
				}

			}

			arr[min] = arr[i];
			arr[i] = storage;
			printArray(arr);			
		}
		return arr;
	}

	public static int[] insertionSort(int[] arr){
		System.out.println("Insertion Sort:");
		printArray(arr);
		int temp;
		for (int i = 0; i<arr.length; i++) {
			for (int k = i; k>0 && arr[k] < arr[k-1]; k-- ) {
				temp = arr[k];
				arr[k] = arr[k-1];
				arr[k-1] = temp;
				printArray(arr);
			}
		}
		return arr;
	}

	public static int[] bubbleSort(int[] arr){
		System.out.println("Bubble Sort:");
		printArray(arr);
		int swaps = 1;
		int temp;
		while (swaps > 0) {
			swaps = 0;
			for (int i = 0; i<arr.length-1; i++) {
				if(arr[i] > arr[i+1]){
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					swaps++;
				}
				printArray(arr);
			}
		}
		return arr;
	}

	public static void printArray(int[] arr){
		System.out.println("");
		for(int a : arr){			
			System.out.print(a + " ");
		}
	}

	public static boolean isSorted(int[] arr){
		for (int i = 1; i<arr.length; i++) {
			if(arr[i] < arr[i-1]){
				return false;
			}
		}
		return true;
	}

	public static int[] newArr(int[] arr){
		int[] res = new int[arr.length];
		for (int i = 0; i<arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	public static void runSort(int[] arr){
		System.out.println();
		if(isSorted(selcectionSort(newArr(arr)))){
			System.out.println();
			System.out.println("Selection Success!");
		}
		if (isSorted(insertionSort(newArr(arr)))) {
			System.out.println();
			System.out.println("Insertion Success!");
		}
		if (isSorted(bubbleSort(newArr(arr)))) {
			System.out.println();
			System.out.println("Bubble Success!");
		}
	}
}