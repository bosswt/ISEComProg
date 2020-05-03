public class CountryInfected {
    private String country;
    private int[] infected;

    public CountryInfected(String countryName, String[] rowData) {
        this.country = countryName;
        this.infected = new int[rowData.length - 4];
        for (int i = 4; i < rowData.length; i++) {
            this.infected[i - 4] = Integer.parseInt(rowData[i]);
        }
    }

    public String getCountry() {
        return this.country;
    }

    public int[] getInfectedNumbers() {
        return this.infected;
    }

    public int getInfectedNumbersByIndex(int index) {
        return this.infected[index];
    }

    public void addInfected(String[] rowData) {
        for (int i = 4; i < rowData.length; i++) {
            this.infected[i - 4] += Integer.parseInt(rowData[i]);
        }
    }

}