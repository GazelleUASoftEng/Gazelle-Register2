package commands;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import commands.interfaces.ResultCommandInterface;
import org.gazelle.api.Product;
import org.gazelle.enums.ProductApiRequestStatus;
import org.gazelle.repositories.interfaces.ProductRepositoryInterface;

public class CreateProductCommand implements ResultCommandInterface<Product> {
	@Override
	public Product execute() {
		if (StringUtils.isBlank(this.apiProduct.getLookupCode())) {
			return (new Product()).setApiRequestStatus(ProductApiRequestStatus.INVALID_INPUT);
		}
		
		org.gazelle.models.Product modelProduct = this.productRepository.byLookupCode(this.apiProduct.getLookupCode());
		if (modelProduct != null) {
			return (new Product()).setApiRequestStatus(ProductApiRequestStatus.LOOKUP_CODE_ALREADY_EXISTS);
		}
		
		this.apiProduct.setId(UUID.randomUUID());
		modelProduct = new org.gazelle.models.Product(this.apiProduct); //not sure why this isnt working. referencing a constructor already made yet still has an error
		modelProduct.save();

		return this.apiProduct;
	}

	//Properties
	private Product apiProduct;
	public Product getApiProduct() {
		return this.apiProduct;
	}
	public CreateProductCommand setApiProduct(Product apiProduct) {
		this.apiProduct = apiProduct;
		return this;
	}
	
	private ProductRepositoryInterface productRepository;
	public ProductRepositoryInterface getProductRepository() {
		return this.productRepository;
	}
	public CreateProductCommand setProductRepository(ProductRepositoryInterface productRepository) {
		this.productRepository = productRepository;
		return this;
	}
}
