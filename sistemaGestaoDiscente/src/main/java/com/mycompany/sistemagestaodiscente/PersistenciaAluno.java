/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author filipe
 */
public class PersistenciaAluno  implements PersistenciaDados{


    @Override
    public List<Aluno> carregarDados() {
        List<Aluno> Alunos = new ArrayList<>();

        Gson gson = new Gson();
        File arquivo = new File("./src/main/java/com/mycompany/bancoDeDados/alunos.json");

        if (arquivo.exists() && !arquivo.isDirectory()) {
            try {
                JsonReader reader = new JsonReader(new FileReader(arquivo));

                JsonElement json = gson.fromJson(reader, JsonElement.class);

                if (json != null) {
                    JsonArray array = json.getAsJsonArray();

                    for (JsonElement element : array) {
                        Aluno Aluno = gson.fromJson(element, Aluno.class);
                        Alunos.add(Aluno);
                    }
                }

                reader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return Alunos;
    }

    @Override
    public <Aluno> void armazenarDados(List<Aluno> objetos) {
                try {
            FileWriter writer = new FileWriter(
                    "./src/main/java/com/mycompany/bancoDeDados/alunos.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(objetos, writer);
            writer.flush();
            writer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
