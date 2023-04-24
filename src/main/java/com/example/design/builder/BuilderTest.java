package com.example.design.builder;

/**
 * 建造者模式
 */
public class BuilderTest {
    public static void main(String[] args) {

//        Product product = new Product();
//        product.setCompanyName("companyName");
//        product.setProductName("productName");
//        product.setPartA("partA");
//        product.setPartB("partB");
//        product.setPartC("partC");

        // 产品的构造存在顺序
        // 代码赋者不好构造
        ProductBuilder productBuilder = new SpecialConcreteProductBuilder();
        Director director = new Director(productBuilder);
        Product product = director.makeProduct("productName", "companyName", "partA", "partB", "partC");
        System.out.println(product);


    }
}


interface ProductBuilder {
    void buildProductName(String productName);
    void buildCompanyName(String companyName);
    void buildPartA(String partA);
    void buildPartB(String partB);
    void buildPartC(String part);
    Product build();
}

class DefaultConcreteProductBuilder implements ProductBuilder {

    private String productName;
    private String companyName;
    private String partA;
    private String partB;
    private String partC;

    @Override
    public void buildProductName(String productName) {
        this.productName = productName ;
    }

    @Override
    public void buildCompanyName(String companyName) {
        this.companyName = companyName ;
    }

    @Override
    public void buildPartA(String partA) {
        this.partA = partA ;
    }

    @Override
    public void buildPartB(String partB) {
        this.partB = partB ;
    }

    @Override
    public void buildPartC(String partC) {
        this.partC = partC ;
    }

    @Override
    public Product build() {
        return new Product(this.productName,this.companyName, this.partA, this.partB, this.partC);
    }
}

class SpecialConcreteProductBuilder implements ProductBuilder {

    private String productName;
    private String companyName;
    private String partA;
    private String partB;
    private String partC;

    @Override
    public void buildProductName(String productName) {
        this.productName = productName ;
    }

    @Override
    public void buildCompanyName(String companyName) {
        this.companyName = companyName ;
    }

    @Override
    public void buildPartA(String partA) {
        this.partA = partA ;
    }

    @Override
    public void buildPartB(String partB) {
        this.partB = partB ;
    }

    @Override
    public void buildPartC(String partC) {
        this.partC = partC ;
    }

    @Override
    public Product build() {
        return new Product(this.productName,this.companyName, this.partA, this.partB, this.partC);
    }
}

class Director {
    private ProductBuilder builder;

    public Director(ProductBuilder builder) {
        this.builder = builder;
    }

    public Product makeProduct(String productName, String companyName, String partA, String partB, String partC) {
        builder.buildProductName(productName);
        builder.buildCompanyName(companyName);
        builder.buildPartA(partA);
        builder.buildPartB(partB);
        builder.buildPartC(partC);
        return builder.build();
    }
}

/**
 * 参数的构造存在顺序
 */
class Product {
    private String productName;
    private String companyName;
    private String partA;
    private String partB;
    private String partC;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public  Product(){

    }

    public Product(String productName, String companyName, String partA, String partB, String partC) {
        this.productName = productName;
        this.companyName = companyName;
        this.partA = partA;
        this.partB = partB;
        this.partC = partC;
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
