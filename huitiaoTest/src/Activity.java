public class Activity {
    public static void main(String[] args) {
        Button button=new Button();
        button.setOnClickListener(b -> System.out.println(button==b));
        button.click();
    }
}
