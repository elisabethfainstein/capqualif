package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto;

public class AdministresDto extends ApiDataDto {

    private String dateNaissance;

    public String getDateNaissance() {
        return dateNaissance;
    }

    @Override
    public String toString() {
        return "AdministresDTO{" +
                "dateNaissance='" + dateNaissance + '\'' +
                '}';
    }
}
