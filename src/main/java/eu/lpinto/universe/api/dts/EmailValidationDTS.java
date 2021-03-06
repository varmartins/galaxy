package eu.lpinto.universe.api.dts;

import eu.lpinto.universe.api.dto.EmailValidationDTO;
import eu.lpinto.universe.persistence.entities.EmailValidation;

/**
 *
 * @author Vítor Martins <vitor.martins@petuniversal.com>
 */
public class EmailValidationDTS extends AbstractDTS<EmailValidation, EmailValidationDTO> {

    public static final EmailValidationDTS T = new EmailValidationDTS();

    @Override
    protected EmailValidationDTO buildDTO(EmailValidation entity) {
        if (entity == null) {
            return null;

        } else if (entity.isFull()) {
            return new EmailValidationDTO(
                    entity.getEmail(),
                    entity.getCode(),
                    entity.getBaseUrl(),
                    entity.getDoneDate()
            );

        } else {
            return new EmailValidationDTO(
                    entity.getEmail(),
                    entity.getCode(),
                    entity.getBaseUrl(),
                    entity.getDoneDate()
            );
        }
    }

    @Override
    public EmailValidation toDomain(Long id) {
        if (id == null) {
            return null;
        }

        return new EmailValidation(id);
    }

    @Override
    protected EmailValidation buildEntity(EmailValidationDTO dto) {
        return new EmailValidation(
                dto.getEmail(),
                dto.getCode(),
                dto.getBaseUrl(),
                dto.getDoneDate(),
                dto.getId(),
                dto.getName(),
                UserDTS.T.toDomain(dto.getCreator()),
                dto.getCreated(),
                UserDTS.T.toDomain(dto.getUpdater()),
                dto.getUpdated(),
                dto.getDeleted());
    }
}
