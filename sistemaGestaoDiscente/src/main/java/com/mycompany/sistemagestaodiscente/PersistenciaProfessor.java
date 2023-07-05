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
public class PersistenciaProfessor implements PersistenciaDados{
    
    @Override
    public List<Professor> carregarDados() {
        List<Professor> professores = new ArrayList<>();

        Gson gson = new Gson();
        File arquivo = new File("./src/main/java/com/mycompany/bancoDeDados/professores.json");

        if (arquivo.exists() && !arquivo.isDirectory()) {
            try {
                JsonReader reader = new JsonReader(new FileReader(arquivo));

                JsonElement json = gson.fromJson(reader, JsonElement.class);

                if (json != null) {
                    if (json.isJsonArray()) {
                        JsonArray array = json.getAsJsonArray();

                        for (JsonElement element : array) {
                            JsonObject professorJson = element.getAsJsonObject();
                            Professor professor = new Professor();
                            
                            // Desserializa os outros dados do professor do JSON
                            professor.setSiape(professorJson.get("siape").getAsString());
                            professor.setNome(professorJson.get("nome").getAsString());
                            professor.setCPF(professorJson.get("CPF").getAsString());
                            professor.setTelefone(professorJson.get("telefone").getAsString());
                            professor.setEmail(professorJson.get("email").getAsString());
                            professor.setSenha(professorJson.get("senha").getAsString());
                            professor.setTipoUsuario(professorJson.get("tipoUsuario").getAsInt());
                            

                            // Desserializa o HashMap do professor do JSON
                            if (professorJson.has("hashMapJson")) {
                                String hashMapJson = professorJson.get("hashMapJson").getAsString();

                                // Converte o JSON do HashMap de volta para um HashMap usando o GSON
                                Type type = new TypeToken<HashMap<String, String>>(){}.getType();
                                HashMap<String, String> hashMap = gson.fromJson(hashMapJson, type);

                                // Adiciona o HashMap ao objeto Professor
                                professor.setTurmasProfessor(hashMap);
                            }

                            professores.add(professor);
                        }
                    }
                }

                reader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return professores;
    }

    @Override
    public <Professor> void armazenarDados(List<Professor> objetos) {
        
    try {
        File arquivo = new File("./src/main/java/com/mycompany/bancoDeDados/professores.json");
        FileWriter writer = new FileWriter(arquivo);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(objetos, writer);

        writer.flush();
        writer.close();


    } catch (IOException e) {
        System.out.println("Erro ao armazenar os dados: " + e.getMessage());
    }
}

    
}
