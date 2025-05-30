package designPatterns.proxy;

public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        // تحميل الصورة الحقيقية فقط عند أول استخدام
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display(); // ثم عرضها
    }
}
