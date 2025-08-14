package com.example.app.service;

import org.springframework.stereotype.Service;

import com.example.app.entity.Product;
import com.example.app.repository.ExpansionRepository;
import com.example.app.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Autowired
@Service // このクラスがSpringのサービスコンポーネントであることを示す
public class ProductService {

    private final ProductRepository productRepository;
    // private final ExpansionRepository ExpansionRepository;

    // コンストラクタインジェクションでProductRepositoryを注入
    public ProductService(ProductRepository productRepository,ExpansionRepository ExpansionRepository) {
        this.productRepository = productRepository;
        // this.ExpansionRepository = ExpansionRepository;
        // ExpansionRepositoryはProductServiceでは使用されていないが、将来の拡張のために保持している可能性があります。
        // もし不要であれば、削除しても問題ありません。
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    // 各フィールドについて、送られてきたデータが存在する場合のみ更新する
    if (productDetails.getName() != null) {
        product.setName(productDetails.getName());
    }
    if (productDetails.getAuthor() != null) {
        product.setAuthor(productDetails.getAuthor());
    }
    // プリミティブ型の場合、0が有効な値である可能性があるので注意が必要です。
    // その場合は、JSONからそのフィールドが送られてきたかどうかを判別するための工夫（DTOなど）が必要になります。
    // 例えば、Integer型のラッパークラスを使うか、フィールドの存在を判別する別のメカニズムを導入する。
    // 現状のint型だと、0を送ってきたのか、送ってこなかったから0になったのかの区別がつきません。
    if (productDetails.getHowManyPeple() != 0) { // 例: 0はデフォルト値であり、明示的な0でない場合のみ更新
        product.setHowManyPeple(productDetails.getHowManyPeple());
    }
    if (productDetails.getPlayTime() != null) { // 同上
        product.setPlayTime(productDetails.getPlayTime());
    }
    if (productDetails.getUrl() != null) {
        product.setUrl(productDetails.getUrl());
    }
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}