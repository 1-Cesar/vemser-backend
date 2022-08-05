import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Arrays;
import java.util.Date;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;

public class Main {

    public static void main(String[] args) {

        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("vemserdbc");

        MongoCollection<Document> usuarios = mongoDatabase.getCollection("devland");

        Document novoUsuario = new Document("nome", "Cesar")
                .append("email", "cesar@teste.com.br")
                .append("areaAtuacao", "Java")
                .append("cpfCnpj", "66928892862")
                .append("foto", "https://foto")
                .append("genero","MASCULINO")
                .append("tipoUsuario", "DEV");

        Document novoUsuario2 = new Document("nome", "Mercadinho")
                .append("email", "mercadinho@teste.com.br")
                .append("areaAtuacao", "area do mercadinho")
                .append("cpfCnpj", "11166928892862")
                .append("foto", "https://foto")
                .append("genero", "MASCULINO")
                .append("tipoUsuario", "EMPRESA");

        Document postagemVaga = new Document("tipoPostagem", "VAGAS")
                .append("titulo", "Trabalho remoto")
                .append("descricao", "ganhos em dolar")
                .append("curtidas", 50)
                .append("data", new Date(2022, 12, 5));

        Document postagemVaga2 = new Document("tipoPostagem", "VAGAS")
                .append("titulo", "Trabalho remoto")
                .append("descricao", "ganhos em euro")
                .append("curtidas", 60)
                .append("data", new Date(2022, 12, 5));

        Document postagemPrograma = new Document("tipoPostagem", "PROGRAMA DE FORMAÇÃO")
                .append("titulo", "Acelera Carreira Dev :)")
                .append("descricao", "Aprenda como nunca antes")
                .append("curtidas", 70)
                .append("data", new Date(2022, 12, 5));

        Document postagemPrograma2 = new Document("tipoPostagem", "PROGRAMA DE FORMAÇÃO")
                .append("titulo", "Acelera Carreira Dev :)")
                .append("descricao", "Aprenda e ganhe em dolar")
                .append("curtidas", 80)
                .append("data", new Date(2022, 12, 5));


        usuarios.insertOne(novoUsuario);
        usuarios.insertOne(novoUsuario2);
        usuarios.insertOne(postagemVaga);
        usuarios.insertOne(postagemVaga2);
        usuarios.insertOne(postagemPrograma);
        usuarios.insertOne(postagemPrograma2);

        usuarios.updateOne(Filters.eq("nome", "Cesar"), new Document("$set", new Document("areaAtuacao" , "Javascript")));
        usuarios.updateOne(Filters.eq("nome", "Mercadinho"), new Document("$set", new Document("areaAtuacao" , "Produtos de Informática Básica!!")));

        usuarios.deleteOne(Filters.eq("nome" , "Cesar"));
        usuarios.deleteOne(Filters.eq("nome" , "Mercadinho"));

        System.out.println("\n-- Usuarios");
        Document usuario = usuarios.find(new Document("nome" , "Cesar"))
                .first();
        Document usuario2 = usuarios.find(new Document("nome" , "Mercadinho"))
                .first();

        System.out.println(usuario);
        System.out.println(usuario2);


        System.out.println("\n-- Vagas");
        usuarios.aggregate(Arrays.asList(
                        match(Filters.empty()),
                        group("$titulo", Accumulators.sum("curtidas", 1))))
                .forEach(doc -> System.out.println(doc.toJson()));

        System.out.println("\n-- PROGRAMA DE FORMAÇÃO");
        usuarios.aggregate(
                Arrays.asList(
                        match(Filters.eq("tipoPostagem", "PROGRAMA DE FORMAÇÃO")),
                        group("$titulo", Accumulators.sum("sumCurtidas", "$curtidas"))
                )).forEach(doc -> System.out.println(doc.toJson()));

        mongoClient.close();
    }
}
