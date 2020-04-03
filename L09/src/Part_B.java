import java.util.Scanner;

public class Part_B {
    public static void main(String[] args) {
        // All-White image
        // int[][][] img = new int[64][128][3];
        // for (int i = 0; i < 64; i++) {
        // for (int j = 0; j < 128; j++) {
        // img[i][j][0] = 255;
        // img[i][j][1] = 255;
        // img[i][j][2] = 255;
        // }
        // }
        // Java101ImageUtil.showViewer(img, "Image");
        // Triangle image
        Scanner kb = new Scanner(System.in);
        int w = kb.nextInt();
        int h = kb.nextInt();
        int[][][] img = new int[w][h][3];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (j > -h + 4 * i && j > h - 4 * i) {
                    img[i][j][0] = 255;
                    img[i][j][1] = 128;
                    img[i][j][2] = 0;
                } else {
                    img[i][j][0] = 0;
                    img[i][j][1] = 128;
                    img[i][j][2] = 255;
                }
            }
        }
        Java101ImageUtil.showViewer(img, "Image");
    }
}