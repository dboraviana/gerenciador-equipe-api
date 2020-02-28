package com.gerenciador.enums;

public enum GeneroPessoa {
    FEMININO("F", "Feminino"), MASCULINO("M", "Masculino");

    private String codigo;
    private String descricao;

    GeneroPessoa (String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo () {
        return codigo;
    }

    public String getDescricao () {
        return descricao;
    }

    public static GeneroPessoa toEnum(String id) {
        if (id == null) {
            return null;
        }

        for (GeneroPessoa generoPessoa : GeneroPessoa.values()){
            if (id.equals(generoPessoa.getCodigo())){
                return generoPessoa;
            }
        }
        throw new IllegalArgumentException("O id: " + id + "não possui um tipo definido!");
    }
}
