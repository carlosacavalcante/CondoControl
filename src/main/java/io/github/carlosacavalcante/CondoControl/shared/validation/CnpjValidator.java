package io.github.carlosacavalcante.CondoControl.shared.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CnpjValidator implements ConstraintValidator<ValidCnpj, String> {

    @Override
    public boolean isValid(String cnpj, ConstraintValidatorContext context) {

        if (cnpj == null) {
            return false;
        }

        cnpj = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.length() != 14) {
            return false;
        }

        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        try {

            int soma = 0;
            int peso = 5;

            for (int i = 0; i < 12; i++) {
                soma += (cnpj.charAt(i) - '0') * peso--;
                if (peso < 2) peso = 9;
            }

            int digito1 = soma % 11 < 2 ? 0 : 11 - soma % 11;

            soma = 0;
            peso = 6;

            for (int i = 0; i < 13; i++) {
                soma += (cnpj.charAt(i) - '0') * peso--;
                if (peso < 2) peso = 9;
            }

            int digito2 = soma % 11 < 2 ? 0 : 11 - soma % 11;

            return digito1 == (cnpj.charAt(12) - '0') &&
                    digito2 == (cnpj.charAt(13) - '0');

        } catch (Exception e) {
            return false;
        }
    }
}