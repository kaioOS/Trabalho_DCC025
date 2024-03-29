/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author filipe
 */
/**
Kaio de Oliveira e Sousa(202165080AC)
Filipe de Lima Namorato(202165035AB)
Gustavo Silva Ribeiro (202165057AC) 
 */
public class PersistenciaTurma implements PersistenciaDados {

    @Override
    public <Turma> void armazenarDados(List<Turma> objetos) {

        try {
            File arquivo = new File("./src/main/java/com/mycompany/bancoDeDados/turmas.json");
            FileWriter writer = new FileWriter(arquivo);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(objetos, writer);

            writer.flush();
            writer.close();

        } catch (IOException e) {
            System.out.println("Erro ao armazenar os dados: " + e.getMessage());
        }
    }

    @Override
    public List<Turma> carregarDados() {
        List<Turma> turmas = new ArrayList<>();

        Gson gson = new Gson();
        File arquivo = new File("./src/main/java/com/mycompany/bancoDeDados/turmas.json");

        if (arquivo.exists() && !arquivo.isDirectory()) {
            try {
                JsonReader reader = new JsonReader(new FileReader(arquivo));

                JsonElement json = gson.fromJson(reader, JsonElement.class);

                if (json != null) {
                    if (json.isJsonArray()) {
                        JsonArray array = json.getAsJsonArray();

                        for (JsonElement element : array) {
                            JsonObject turmaJson = element.getAsJsonObject();
                            Turma turma = new Turma();

                            // Desserializa os outros dados da turma do JSON
                            turma.setCodigoTurma(turmaJson.get("codigoTurma").getAsString());
                            turma.setSiapeProfessor(turmaJson.get("siapeProfessor").getAsString());
                            turma.setCodigoDisciplina(turmaJson.get("codigoDisciplina").getAsString());
                            turma.setFormaAvaliacao(turmaJson.get("formaAvaliacao").getAsInt());
                            turma.defineFormaAvaliacao(turma.getFormaAvaliacao());

                            // Desserializa a lista de alunos do JSON
                            if (turmaJson.has("alunos")) {
                                JsonArray alunosJsonArray = turmaJson.getAsJsonArray("alunos");
                                List<Aluno> alunos = new ArrayList<>();

                                for (JsonElement alunoElement : alunosJsonArray) {
                                    JsonObject alunoJson = alunoElement.getAsJsonObject();
                                    Aluno aluno = gson.fromJson(alunoJson, Aluno.class);
                                    alunos.add(aluno);
                                }

                                turma.setAlunos(alunos);
                            }

                            // Desserializa o HashMap do turma do JSON
                            if (turmaJson.has("hashMapJson")) {
                                String hashMapJson = turmaJson.get("hashMapJson").getAsString();

                                // Converte o JSON do HashMap de volta para um HashMap usando o GSON
                                Type type = new TypeToken<HashMap<String, Integer>>() {
                                }.getType();
                                HashMap<String, Integer> hashMap = gson.fromJson(hashMapJson, type);

                                // Adiciona o HashMap ao objeto Turma
                                turma.setFrequencia(hashMap);
                            }

                            turmas.add(turma);
                        }
                    }
                }

                reader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return turmas;
    }

}
