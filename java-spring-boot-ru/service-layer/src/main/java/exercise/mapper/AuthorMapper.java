package exercise.mapper;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.model.Author;
import org.mapstruct.*;

@Mapper(
        uses = {JsonNullableMapper.class, ReferenceMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class AuthorMapper {

    // BEGIN
    public abstract Author map(AuthorCreateDTO dto);

    //@Mapping(source = "author.id", target = "authorId")
    public abstract AuthorDTO map(Author model);

    //@Mapping(source = "authorId", target = "author.id")
    //public abstract Author map(AuthorDTO model);
    // END

    public abstract void update(AuthorUpdateDTO dto, @MappingTarget Author model);
}
