//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Esercizio U4-W3-D1");


        System.out.println("-----------------------------------");
        System.out.println("\n");
        //CLIENTI CON NOME MARIO
        System.out.println("SELECT * FROM clienti WHERE nome ILIKE 'Mario'");
        System.out.println("\n");
        //CLIENTI NATI NEL 1982
        System.out.println("SELECT nome, cognome FROM clienti WHERE anno_nascita = 1982");
        System.out.println("\n");
        //NUMERO DI FATTURE CON IVA AL 20
        System.out.println("SELECT numero_fattura FROM fatture WHERE iva = 20");
        System.out.println("\n");
        //PRODOTTI ATTIVATI NEL 2017, IN PRODUZIONE O IN COMMERCIO
        System.out.println("SELECT * FROM prodotti WHERE EXTRACT(YEAR FROM data_attivazione)=2017 \n" +
                "AND (in_produzione = true OR in_commercio = true)");
        System.out.println("\n");
        //FATTURE CON IMPORTO INFERIORE A 1000 E I DATI DEI CLIENTI
        System.out.println("SELECT fatture.numero_fattura,\n" +
                "fatture.importo,\n" +
                "fatture.iva,\n" +
                "fatture.data_fattura,\n" +
                "clienti.nome,\n" +
                "clienti.cognome\n" +
                "        FROM fatture\n" +
                "        JOIN clienti ON fatture.id_cliente = clienti.numero_cliente\n" +
                "        WHERE CAST(importo AS numeric) > 1000;\n");
        System.out.println("\n");

        //ELENCO DELLE FATTURE CON IL NOME DEL FORNITORE
        System.out.println("SELECT fatture.numero_fattura,\n" +
                "fatture.importo,\n" +
                "fatture.iva,\n" +
                "fatture.data_fattura,\n" +
                "fornitori.denominazione\n" +
                "FROM\n" +
                "fatture\n" +
                "JOIN \n" +
                "fornitori ON fatture.numero_fornitore = fornitori.numero_fornitore");
        System.out.println("\n");

        //NUMERO DI FATTURE PER OGNI ANNO RELATIVIALLE FATTURE CON IVA 20%

        System.out.println("\n");
        System.out.println("SELECT EXTRACT (YEAR FROM data_fattura) as years,\n" +
                "                count(*) as numero_fattura from fatture where iva = 20 group by extract(year from data_fattura)");

        //NUMERO DI FATTURE E LA SOMMA DEI RELATIVI IMPORTI DIVISI PER ANNO DI FATTURAZIONE
        System.out.println("SELECT EXTRACT(YEAR FROM data_fattura) AS anno,\n" +
                "COUNT(*) AS numero_fatture,\n" +
                "SUM(importo) AS somma_importi\n" +
                "FROM fatture GROUP BY EXTRACT(YEAR FROM data_fattura)");



        //ESTRARRE GLI ANNI IN CUI SONO STATE REGISTRATE PIU DI 2 FATTURE DI TIPO "type_A"
        System.out.println("\n");
        System.out.println("SELECT EXTRACT(YEAR FROM data_fattura) AS years,\n" +
                "COUNT(*) AS numero_fatture\n" +
                "FROM \n" +
                "fatture\n" +
                "WHERE tipologia = 'type_A'\n" +
                "GROUP BY EXTRACT(YEAR FROM data_fattura)\n" +
                "HAVING COUNT(*) > 2;");


    }
}