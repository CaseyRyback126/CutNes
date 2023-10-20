import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaterialSheet {

    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    private List<Detail> details;

    public MaterialSheet(int width, int height) {
        this.width = width;
        this.height = height;
        this.details = new ArrayList<>();
    }

    public void addDetail(Detail detail) {
        details.add(detail);
    }

    public void arrangeDetails() {
        // Сортируем детали по убыванию размера сторон
        details.sort(Comparator.comparing(Detail::getWidth).reversed().thenComparing(Detail::getHeight));

        List<Sheet> sheets = new ArrayList<>();
        Sheet currentSheet = new Sheet(width, height);
        sheets.add(currentSheet);

        for (Detail detail : details) {
            boolean placed = false;
            for (Sheet sheet : sheets) {
                if (sheet.canPlaceDetail(detail)) {
                    sheet.placeDetail(detail);
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                currentSheet = new Sheet(width, height);
                sheets.add(currentSheet);
                currentSheet.placeDetail(detail);
            }
        }
        for (int i = 0; i < sheets.size(); i++) {
            Sheet sheet = sheets.get(i);
            System.out.println("Sheet " + (i + 1) + ":");
            sheet.displayDetails();
        }
    }
}
