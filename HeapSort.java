package Algorithms_02;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Начальная макс-куча
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Извлечение максимального элемента
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    // Преобразование поддерева в макс-кучу
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Наибольший элемент как корень
        int left = 2 * i + 1; // Левый дочерний
        int right = 2 * i + 2; // Правый дочерний

        // Если левый дочерний больше корня
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Если правый дочерний больше текущего наибольшего элемента
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Если наибольший элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    // Вывод массива
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 9, 1, 7, 4, 10, 2, 6, 8};

        System.out.println("Исходный массив:");
        printArray(arr);

        heapSort(arr);

        System.out.println("Отсортированный массив:");
        printArray(arr);
    }
}
