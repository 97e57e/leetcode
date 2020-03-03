public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 0, 3};
        int index = 0;

        // 1. 배열 앞에서 부터 0이 아닌것 채우기
        for(int i=0; i<arr.length; i++) {
            if(arr[i]!=0) {
                arr[index]=arr[i];
                index++;
            }
        }

        //2. index 뒤로 0을 채우기
        while(index<arr.length) {
            arr[index]=0;
            index++;
        }

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

}
