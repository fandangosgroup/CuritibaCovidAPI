# CuritibaCovidAPI
by FandangosGroup

API para consultar os casos de infecção de covid19 em Curitiba
A CuritibaCovidAPI consulta os dados publicos que são disponibilizados periodicamente pelo governo do Paraná
como usar em java:
chame a api de forma statica usando CuritibaCovidAPI.Companion.getDataSet() essa função retorna um ArrayList<Caso> o tipo de Caso ja esta incluso na API, basta importar.
tipo de dado Caso:
  component1() = posicao: tipo String
  component2() = dataInclusaoNotificacao: tipo String
  component3() = classificacaoFinal: tipo String
  component4() = idade: tipo String
  component5() = sexo: tipo String
  component6() = evolucao: tipo String
  component7() = dataObito: tipo String
exemplo de codigo em java:
  ```java
    import com.github.fandangosgroup.pcovid.model.Caso;
    import com.github.fandangosgroup.pcovid.model.CuritibaCovidAPI;
    import java.util.ArrayList;

    public class main {
      public static void main(String[] args){
        ArrayList<Caso> c = CuritibaCovidAPI.Companion.getDataSet();
        System.out.println(c.get(0).component1());
        System.out.println(c.get(0).component2());
        System.out.println(c.get(0).component3());
        System.out.println(c.get(0).component4());
        System.out.println(c.get(0).component5());
        System.out.println(c.get(0).component6());
        System.out.println(c.get(0).component7());
      }
    }
    ```
