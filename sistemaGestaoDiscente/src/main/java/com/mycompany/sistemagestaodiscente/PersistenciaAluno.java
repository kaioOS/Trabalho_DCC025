/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

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
import java.util.HashMap;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;

/**
 *
 * @author filipe
 */
public class PersistenciaAluno implements PersistenciaDados {

    @Override
    public List<Aluno> carregarDados() {
        List<Aluno> alunos = new ArrayList<>();

        Gson gson = new Gson();
        File arquivo = new File("./src/main/java/com/mycompany/bancoDeDados/alunos.json");

        if (arquivo.exists() && !arquivo.isDirectory()) {
            try {
                JsonReader reader = new JsonReader(new FileReader(arquivo));

                JsonElement json = gson.fromJson(reader, JsonElement.class);

                if (json != null) {
                    if (json.isJsonArray()) {
                        JsonArray array = json.getAsJsonArray();

                        for (JsonElement element : array) {
                            JsonObject alunoJson = element.getAsJsonObject();
                            Aluno aluno = new Aluno();
                            HashMap<String, String> hashMap = null;

                            // Desserializa os outros dados do aluno do JSON
                            aluno.setMatricula(alunoJson.get("matricula").getAsString());
                            aluno.setNome(alunoJson.get("nome").getAsString());
                            aluno.setCPF(alunoJson.get("CPF").getAsString());
                            aluno.setTelefone(alunoJson.get("telefone").getAsString());
                            aluno.setSenha(alunoJson.get("senha").getAsString());
                            aluno.setTipoUsuario(alunoJson.get("tipoUsuario").getAsInt());
                            aluno.setTurmaAluno(hashMap);   
                            // Desserializa o HashMap do aluno do JSON
                            if (alunoJson.has("hashMapJson") && !alunoJson.get("hashMapJson").isJsonNull()) {
                                String hashMapJson = alunoJson.get("hashMapJson").getAsString();

                                // Converte o JSON do HashMap de volta para um HashMap usando o GSON
                                Type type = new TypeToken<HashMap<String, String>>() {
                                }.getType();
                                hashMap = gson.fromJson(hashMapJson, type);

                                // Adiciona o HashMap ao objeto Aluno
                                aluno.setTurmaAluno(hashMap);
                            }

                            alunos.add(aluno);
                        }
                    }
                }

                reader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return alunos;
    }

    @Override
    public <Aluno> void armazenarDados(List<Aluno> objetos) {
        try {
            File arquivo = new File("./src/main/java/com/mycompany/bancoDeDados/alunos.json");
            FileWriter writer = new FileWriter(arquivo);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(objetos, writer);

            writer.flush();
            writer.close();

            System.out.println("Dados dos alunos armazenados com sucesso.");

        } catch (IOException e) {
            System.out.println("Erro ao armazenar os dados dos alunos: " + e.getMessage());
        }
    }

}
