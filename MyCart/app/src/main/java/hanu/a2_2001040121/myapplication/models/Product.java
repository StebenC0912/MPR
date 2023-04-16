package hanu.a2_2001040121.myapplication.models;

public class Product {
    private Long id;
    private String thumbnail;
    private String category;
    private int unitPrice;

    public Product(Long id, String thumbnail, String category, int unitPrice) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.category = category;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
}
