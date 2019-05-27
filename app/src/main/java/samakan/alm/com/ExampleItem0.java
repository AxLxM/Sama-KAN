package samakan.alm.com;

public class ExampleItem0 {
    private int mImageResource;
    private int Pic;
    private String mText2;

    ExampleItem0(int imageResource, int pic, String text2) {
        mImageResource = imageResource;
        Pic = pic;
        mText2 = text2;
    }

    public int getImg() {
        return mImageResource;
    }

    public int getText() {
        return Pic;
    }

    public String getText2() {
        return mText2;
    }
}