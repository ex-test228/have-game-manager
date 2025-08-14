package com.example.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.Expansion;
import com.example.app.entity.Product;
import com.example.app.repository.ExpansionRepository;
import com.example.app.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service // このクラスがSpringのサービスコンポーネントであることを示す
public class ExpansionService {
    @Autowired
    private ProductRepository productRepository;

        public void createExpansion() {
        Expansion newExpansion = new Expansion();
        Product existingProduct = productRepository.findById(1L).orElseThrow();
        newExpansion.setProduct(existingProduct);
        ExpansionRepository.save(newExpansion);
    }
    @Autowired
    private final ExpansionRepository ExpansionRepository;

    // コンストラクタインジェクションでExpansionRepositoryを注入
    public ExpansionService(ExpansionRepository ExpansionRepository) {
        this.ExpansionRepository = ExpansionRepository;
    }

    public List<Expansion> getAllExpansions() {
        return ExpansionRepository.findAll();
    }

    public Optional<Expansion> getExpansionById(Long id) {
        return ExpansionRepository.findById(id);
    }

    public Expansion createExpansion(Expansion Expansion) {
        return ExpansionRepository.save(Expansion);
    }

    public Expansion updateExpansion(Long id, Expansion ExpansionDetails) {
        Expansion Expansion = ExpansionRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Expansion not found with id " + id));
    // 各フィールドについて、送られてきたデータが存在する場合のみ更新する
    if (ExpansionDetails.getName() != null) {
        Expansion.setName(ExpansionDetails.getName());
    }
    if (ExpansionDetails.getAdditionalPoints() != null) {
        Expansion.setAdditionalPoints(ExpansionDetails.getAdditionalPoints());
    }
        return ExpansionRepository.save(Expansion);
    }

    public void deleteExpansion(Long id) {
        ExpansionRepository.deleteById(id);
    }
}
