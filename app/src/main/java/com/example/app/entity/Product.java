package com.example.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

import jakarta.persistence.Column;

@Entity // このクラスがJPAエンティティであることを示す
public class Product {

  @Id // 主キーであることを示す
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 自動生成されるID (AUTO_INCREMENT)
  private Long id;

   @OneToMany(mappedBy = "product") // Expansionクラスのidフィールドにマッピング
    private List<Expansion> expansions; // 1つのProductが複数のExpansionを持つ

  @Column(nullable = false) // カラム名を指定しない場合、フィールド名がそのままカラム名になる。nullable=falseでNOT NULL制約
  private String name;

  private String author;

  private int howManyPeple;

  private String playTime;

  private String url;

  // デフォルトコンストラクタはJPAで必須
  public Product() {
  }

  public Product(String name, String author, int howManyPeple, String playTime, String url) {
    this.name = name;
    this.author = author;
    this.howManyPeple = howManyPeple;
    this.playTime = playTime;
    this.url = url;
  }

  // GetterとSetter
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getHowManyPeple() {
    return howManyPeple;
  }

  public void setHowManyPeple(int howManyPeple) {
    this.howManyPeple = howManyPeple;
  }

  public String getPlayTime() {
    return playTime;
  }

  public void setPlayTime(String playTime) {
    this.playTime = playTime;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", author=" + author +
        '}';
  }
}
