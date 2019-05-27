package samakan.alm.com;

public class ExampleItem {

    private String mLine1;
    private String mLine2;
    private String mLine3;

    ExampleItem(String line1, String line2, String line3) {
        mLine1 = line1;
        mLine2 = line2;
        mLine3 = line3;
    }

    void changeText1(String text) {
        mLine1 = text;
    }

    public String getLine1() {
        return mLine1;
    }

    String getLine2() {
        return mLine2;
    }

    public String getLine3() {
        return mLine3;
    }

}