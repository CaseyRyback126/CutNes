public class Main {
    public static void main(String[] args) {
        MaterialSheet sheet = new MaterialSheet(100, 100);
        sheet.addDetail(new Detail(40, 20));
        sheet.addDetail(new Detail(30, 10));
        sheet.addDetail(new Detail(50, 30));
        sheet.addDetail(new Detail(20, 20));
        sheet.addDetail(new Detail(20, 10));

        sheet.arrangeDetails();
    }
}
