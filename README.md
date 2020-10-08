# CuritibaCovidAPI
by FandangosGroup

*API para consultar os casos de infecção de covid19 em Curitiba<br>
A CuritibaCovidAPI consulta os dados públicos que são disponibilizados periodicamente pelo governo do Paraná<br>
como usar em java:<br>
chame a api de forma statica usando CuritibaCovidAPI.Companion.getDataSet() essa função retorna um ArrayList<Caso> o tipo "Caso" ja esta incluso na API, basta importar.<br>
  <h3>tipo de dado Caso:</h3><br>
*  component1() = posicao: tipo String
*  component2() = dataInclusaoNotificacao: tipo String
*  component3() = classificacaoFinal: tipo String
*  component4() = idade: tipo String
*  component5() = sexo: tipo String
*  component6() = evolucao: tipo String
*  component7() = dataObito: tipo String
<h3>exemplo de codigo em java:</h3><br>
  ```java
    import com.github.fandangosgroup.pcovid.model.Caso;
    import com.github.fandangosgroup.pcovid.model.CuritibaCovidAPI;
    import java.util.ArrayList;

    public class main {
      public static void main(String[] args){
      
        ArrayList<Caso> c = CuritibaCovidAPI.Companion.getDataSet();
        System.out.println(c.get(0).component2()); //Retorna a data do primeiro caso em curitiba.
      }
    }
    ```
