public class Cow1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String n = scanner.nextLine();
            int i = Integer.parseInt(n);
            if(i==0)return;
            System.out.println(recurtion(i));
        }
    }
    static int recurtion(int n) {
        if(n==1|| n==2 || n==3 || n==4) return n;
        return recurtion(n-1)+recurtion(n-3);
    }
}