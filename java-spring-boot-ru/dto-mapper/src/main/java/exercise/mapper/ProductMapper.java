package exercise.mapper;

// BEGIN
import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.model.Product;

import org.mapstruct.*;


@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)

public abstract class ProductMapper {
    @Mapping(target = "name", source = "title")
    @Mapping(target = "barcode", source = "vendorCode")
    @Mapping(target = "cost", source = "price")
    public abstract Product map(ProductCreateDTO dto);

    @Mapping(target = "cost", source = "price")
    public abstract void update(ProductUpdateDTO dto, @MappingTarget Product model);

    @Mapping(target = "title", source = "name")
    @Mapping(target = "vendorCode", source = "barcode")
    @Mapping(target = "price", source = "cost")
    public abstract ProductDTO map(Product model);
}
// END
