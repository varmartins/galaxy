package eu.lpinto.universe.api.dts;

import eu.lpinto.universe.persistence.entities.Image;

/**
 * Image DTO - Data Transformation Object
 *
 * @author Luis Pinto <code>- mail@lpinto.eu</code>
 */
public class ImageDTS extends AbstractDTS<Image, eu.lpinto.universe.api.dto.Image> {

    public static final ImageDTS T = new ImageDTS();

    @Override
    protected eu.lpinto.universe.api.dto.Image buildDTO(Image entity) {
        return new eu.lpinto.universe.api.dto.Image(
                OrganizationDTS.toApiID(entity.getOrganization()),
                entity.getUrl()
        );
    }

    @Override
    public Image toDomain(Long id) {
        if (id == null) {
            return null;
        }

        return new Image(id);
    }

    @Override
    protected Image buildEntity(eu.lpinto.universe.api.dto.Image dto) {
        return new Image(
                OrganizationDTS.T.toDomain(dto.getOrganization()),
                dto.getUrl(),
                dto.getId(), dto.getName(), dto.getCreated(), dto.getUpdated());
    }
}
