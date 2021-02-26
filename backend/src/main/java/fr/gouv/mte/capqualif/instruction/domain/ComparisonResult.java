package fr.gouv.mte.capqualif.instruction.domain;

public class ComparisonResult {

    private String conditionJuridicalDesignation;
    private boolean isValid;

    public ComparisonResult(String conditionJuridicalDesignation, boolean isValid) {
        this.conditionJuridicalDesignation = conditionJuridicalDesignation;
        this.isValid = isValid;
    }

    public String getConditionJuridicalDesignation() {
        return conditionJuridicalDesignation;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setConditionJuridicalDesignation(String conditionJuridicalDesignation) {
        this.conditionJuridicalDesignation = conditionJuridicalDesignation;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ComparisonResult result = (ComparisonResult) o;
        return isValid == result.isValid &&
                conditionJuridicalDesignation.equals(result.conditionJuridicalDesignation);
    }

    @Override
    public String toString() {
        return "ComparisonResult{" +
                "conditionJuridicalDesignation='" + conditionJuridicalDesignation + '\'' +
                ", isValid=" + isValid +
                '}';
    }
}
