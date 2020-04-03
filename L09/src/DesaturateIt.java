public class DesaturateIt {
	public static void main(String[] args) {
		int[][][] rgb = Java101ImageUtil.getRGBArrayFromFile();
		if (rgb == null) {
			return;
		}
		int[][][] gray = desaturate(rgb);
		Java101ImageUtil.showViewer(rgb, gray, "Desaturate It!");
	}

	public static int[][][] desaturate(int[][][] rgb) {
		int w = rgb.length;
		int h = rgb[0].length;
		int[][][] img = new int[w][h][3];
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				for (int k = 0; k < 3; k++) {
					img[i][j][k] = (rgb[i][j][0] + rgb[i][j][1] + rgb[i][j][2]) / 3;
				}
			}
		}
		return img;
	}
}