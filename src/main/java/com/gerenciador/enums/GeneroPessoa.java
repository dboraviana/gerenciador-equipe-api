package com.gerenciador.enums;

public enum GeneroPessoa {
    FEMININO(1, "Feminino"), MASCULINO(2, "Masculino");

    private Integer id;
    private String descricao;

    GeneroPessoa (Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId () {
        return id;
    }

    public String getDescricao () {
        return descricao;
    }

    public static GeneroPessoa toEnum(Integer id) {
        if (id == null) {
            return null;
        }

        for (GeneroPessoa generoPessoa : GeneroPessoa.values()){
            if (id.equals(generoPessoa.getId())){
                return generoPessoa;
            }
        }
        throw new IllegalArgumentException("O id: " + id + "não possui um tipo definido!");
    }
}
