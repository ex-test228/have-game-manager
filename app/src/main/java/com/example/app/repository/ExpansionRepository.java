package com.example.app.repository;

// import com.example.app.Expansion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.entity.Expansion;

// Expansionエンティティと、その主キーの型 (Long) を指定する
@Repository // このインターフェースがデータリポジトリであることを示す
public interface ExpansionRepository extends JpaRepository<Expansion, Long> {

    // Spring Data JPAは、メソッド名からクエリを自動生成できます。
    // 例: findByName(String name) と定義すると、SELECT * FROM Expansion WHERE name = ? を生成
    // 例: findByPriceGreaterThan(double price)
    // 複雑なクエリは @Query アノテーションを使用します。
}