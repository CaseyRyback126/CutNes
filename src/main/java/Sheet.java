import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Sheet {
    private int width;
    private int height;
    private List<Detail> details;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public Sheet(int width, int height) {
        this.width = width;
        this.height = height;
        this.details = new ArrayList<>();
    }

    public boolean canPlaceDetail(@NotNull Detail detail) {
        int x = 0;
        int y = 0;
        while (y + detail.getHeight() <= height) {
            int remainingWidth = width;
            while (x + detail.getWidth() <= remainingWidth) {
                boolean overlap = false;
                for (Detail placedDetail : details) {
                    if (isOverlap(x, y, placedDetail)) {
                        overlap = true;
                        break;
                    }
                }
                if (!overlap) {
                    return true;
                }
                x++;
                remainingWidth--;
            }
            x = 0;
            y++;
        }
        return false;
    }

    private boolean isOverlap(int x, int y, @NotNull Detail placedDetail) {
        int detailRight = placedDetail.getX() + placedDetail.getWidth();
        int detailBottom = placedDetail.getY() + placedDetail.getHeight();
        int xRight = x + placedDetail.getWidth();
        int yBottom = y + placedDetail.getHeight();

        if (x >= detailRight || placedDetail.getX() >= xRight) {
            return false;
        }

        return y < detailBottom && placedDetail.getY() < yBottom;
    }

    public void placeDetail(@NotNull Detail detail) {
        int x = 0;
        int y = 0;
        while (y + detail.getHeight() <= height) {
            int remainingWidth = width;
            while (x + detail.getWidth() <= remainingWidth) {
                boolean overlap = false;
                for (Detail placedDetail : details) {
                    if (isOverlap(x, y, placedDetail)) {
                        overlap = true;
                        break;
                    }
                }
                if (!overlap) {
                    detail.setCoordinates(x, y);
                    details.add(detail);
                    return;
                }
                x++;
                remainingWidth--;
            }
            x = 0;
            y++;
        }
    }

    public void displayDetails() {
        for (Detail detail : details) {
            System.out.println("Detail: width=" + detail.getWidth() + ", height=" + detail.getHeight() +
                    ", x=" + detail.getX() + ", y=" + detail.getY());
        }
        System.out.println();
    }
}
