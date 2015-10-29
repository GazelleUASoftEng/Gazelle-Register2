package commands;

import java.util.stream.Collectors;

import commands.interfaces.ResultCommandInterface;
import org.gazelle.api.Product;
import org.gazelle.api.ProductListing;
import org.gazelle.repositories.interfaces.ProductRepositoryInterface;

public class ProductsQuery implements ResultCommandInterface<ProductListing> {
	@Override
	public ProductListing execute() {
		return (new ProductListing()).
			setProducts(
				this.productRepository.all().stream().map(mp -> (new Product(mp))).collect(Collectors.toList()
			)
		);
	}

	//Properties
	private ProductRepositoryInterface productRepository;
	public ProductRepositoryInterface getProductRepository() {
		return this.productRepository;
	}
	public ProductsQuery setProductRepository(ProductRepositoryInterface productRepository) {
		this.productRepository = productRepository;
		return this;
	}
}
