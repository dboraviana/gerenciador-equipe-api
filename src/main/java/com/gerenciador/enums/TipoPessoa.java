package com.gerenciador.enums;

public enum TipoPessoa {

    PESSOAFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Jurídica"), PESSOAESTRANGEIRA(2, "Pessoa Estrangeira");

    private final Integer id;
    private final String descricao;

    TipoPessoa(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao(){
        return descricao;
    }

    public static TipoPessoa toEnum(Integer id) {
        if (id == null) {
            return null;
        }

        for (TipoPessoa tipoPessoa : TipoPessoa.values()){
            if (id.equals(tipoPessoa.getId())){
                return tipoPessoa;
            }
        }
        throw new IllegalArgumentException("O id: " + id + "não possui um tipo definido!");
    }
}
