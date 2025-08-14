package com.example.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity // このクラスがJPAエンティティであることを示す
public class Expansion {

  @Id // 主キーであることを示す
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

    @ManyToOne // 複数のOrderが1つのUserに紐づく
    @JoinColumn(name = "game_id", nullable = false) // 外部キーのカラム名を指定
    private Product product; // ここでproductオブジェクトを参照

  @Column(nullable = false) // カラム名を指定しない場合、フィールド名がそのままカラム名になる。nullable=falseでNOT NULL制約
  private String name;

  private String additionalPoints;

  // デフォルトコンストラクタはJPAで必須
  public Expansion() {
  }

  public Expansion(String name, String additionalPoints) {
    this.name = name;
    this.additionalPoints = additionalPoints;
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

  public String getAdditionalPoints() {
    return additionalPoints;
  }

  public void setAdditionalPoints(String additionalPoints) {
    this.additionalPoints = additionalPoints;
  }


  @Override
  public String toString() {
    return "Expansion{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", additionalPoints='" + additionalPoints + '\'' +
        '}';
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}
