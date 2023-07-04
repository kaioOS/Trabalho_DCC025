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
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author gustavo
 */
public class PersistenciaNotaSomatorio implements PersistenciaDados {

    @Override
    public <T> void armazenarDados(List<T> objetos) {
        try {
            File arquivo = new File("./src/main/java/com/mycompany/bancoDeDados/notaSomatorio.json");
            FileWriter writer = new FileWriter(arquivo);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonArray jsonArray = new JsonArray();

            for (T objeto : objetos) {
                JsonObject objetoJson = new JsonObject();

                // Extrair dados específicos do objeto NotaSomatorio
                if (objeto instanceof NotaSomatorio) {
                    NotaSomatorio notaSomatorio = (NotaSomatorio) objeto;

                    // Serializar o ID da avaliação
                    objetoJson.addProperty("idAvaliacao", notaSomatorio.getIdAvaliacao());

                    // Serializar o mapa de notas dos alunos
                    Map<String, List<Float>> notaAlunos = notaSomatorio.getNotaAlunos();
                    JsonObject notaAlunosJson = new JsonObject();

                    for (Map.Entry<String, List<Float>> entry : notaAlunos.entrySet()) {
                        String disciplina = entry.getKey();
                        List<Float> notas = entry.getValue();
                        JsonArray notasJson = new JsonArray();

                        for (Float nota : notas) {
                            notasJson.add(nota);
                        }

                        notaAlunosJson.add(disciplina, notasJson);
                    }

                    objetoJson.add("notaAlunos", notaAlunosJson);
                }

                jsonArray.add(objetoJson);
            }

            gson.toJson(jsonArray, writer);

            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao armazenar os dados: " + e.getMessage());
        }
    }

    @Override
    public List<NotaSomatorio> carregarDados() {

        List<NotaSomatorio> notasSomatorio = new ArrayList<>();

        Gson gson = new Gson();
        File arquivo = new File("./src/main/java/com/mycompany/bancoDeDados/notaSomatorio.json");

        if (arquivo.exists() && !arquivo.isDirectory()) {
            try {
                JsonReader reader = new JsonReader(new FileReader(arquivo));

                JsonElement json = gson.fromJson(reader, JsonElement.class);

                if (json != null) {
                    if (json.isJsonArray()) {
                        JsonArray array = json.getAsJsonArray();

                        for (JsonElement element : array) {
                            JsonObject notaSomatorioJson = element.getAsJsonObject();
                            NotaSomatorio notaSomatorio = new NotaSomatorio();

                            // Desserializa os outros dados do JSON
                            notaSomatorio.setIdAvaliacao(notaSomatorioJson.get("idAvaliacao").getAsInt());

                            // Desserializa o HashMap do JSON
                            if (notaSomatorioJson.has("notaAlunos")) {
                                JsonObject notaAlunosJson = notaSomatorioJson.get("notaAlunos").getAsJsonObject();
                                Map<String, List<Float>> notaAlunos = new HashMap<>();

                                for (Map.Entry<String, JsonElement> entry : notaAlunosJson.entrySet()) {
                                    String disciplina = entry.getKey();
                                    JsonArray notasJson = entry.getValue().getAsJsonArray();
                                    List<Float> notas = gson.fromJson(notasJson, new TypeToken<List<Float>>() {
                                    }.getType());
                                    notaAlunos.put(disciplina, notas);
                                }

                                // Adiciona o HashMap ao objeto NotaSomatorio
                                notaSomatorio.setNotaAlunos(notaAlunos);
                            }

                            notasSomatorio.add(notaSomatorio);
                        }
                    }
                }

                reader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return notasSomatorio;
    }

}