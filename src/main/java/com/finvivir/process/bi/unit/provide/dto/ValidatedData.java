package com.finvivir.process.bi.unit.provide.dto;

import lombok.Data;

import java.util.List;

@Data
public class ValidatedData {
    List<Integer> personasEnLos3lados;
    List<Integer> personasSinScore;
    List<Integer> personasSinBusiness;
    List<Integer> personasSinAmbos;
}
