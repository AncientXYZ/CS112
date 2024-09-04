public class Cubes {
    public static void main(String[] args) {
        for(int i = 1;;i++){
            int cube = i * i * i; //cube equals 3time by them self
            if(cube > 2000){
                break;
            }
            System.out.println(cube);
        }
    }
}
