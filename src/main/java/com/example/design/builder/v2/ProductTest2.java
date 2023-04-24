package com.example.design.builder.v2;

/**
 * 建造者模式
 */
public class ProductTest2 {
    public static void main(String[] args) {
//        Product product = new Product("productName", "companyName", "partA", "partB", "partC");
        Product product = new Product.Builder()
                .productName("productName")
                .companyName("companyName")
                .partA("partA")
                .partB("partB")
                .partC("partC")
                .build();
        System.out.println(product);
    }
}


/**
 * 参数的构造存在顺序
 */
class Product {
    private final String productName;
    private final String companyName;
    private final String partA;
    private final String partB;
    private final String partC;

    public Product(String productName, String companyName, String partA, String partB, String partC) {
        this.productName = productName;
        this.companyName = companyName;
        this.partA = partA;
        this.partB = partB;
        this.partC = partC;
    }

    static class Builder {
        private String productName;
        private String companyName;
        private String partA;
        private String partB;
        private String partC;

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }
        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }
        public Builder partA(String partA) {
            this.partA = partA;
            return this;
        }

        public Builder partB(String partB) {
            this.partB = partB;
            return this;
        }

        public Builder partC(String partC) {
            this.partC = partC;
            return this;
        }

        public Product build() {
            return new Product(productName, companyName, partA, partB, partC);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                '}';
    }
}