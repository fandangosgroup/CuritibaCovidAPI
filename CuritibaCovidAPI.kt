/***********************************************************************
*   Autores Bruno Vais, Carlos Leite, Raphael Fernando, Fabricio Galo  *
*   data: 07/10/2020                                                   *
*   API que consulta os dados do covid19 em curitiba.                  *
************************************************************************/

package com.github.fandangosgroup.pcovid.model

import java.lang.Exception
import java.net.URL
import java.time.LocalDateTime

class CuritibaCovidAPI {

    companion object{
        private fun consultaDadosAbertos(): String{

            var month = LocalDateTime.now().month.value
            var monthString = ""
            var response = ""
            var day: String
            var i = 31

            while (i > 0){
                day = if(i < 10) "0" + i.toString() else i.toString()
                monthString = if(month < 10) "0" + month.toString() else month.toString()
                try{
                    response = URL("http://dadosabertos.c3sl.ufpr.br/curitiba/CasosCovid19/2020-$monthString-${day}_Casos_Covid_19_-_Base_de_Dados.csv").readText()
                }
                catch (e : Exception){
                    if(i == 1){
                        month--
                        i = 31
                    }
                    if(month == 0){
                        println("Não foram encontrados dados desse ano!")
                        break
                    }
                    i--
                    continue
                }
                break
            }
            return response
        }

        fun getDataSet(): ArrayList<Caso>{

            val response = consultaDadosAbertos()
            val dataRow = response.split("\n")
            var dataset = ArrayList<Caso>()
            var i = 1
            var j: Int

            while(i < dataRow.count()){
                var linha = dataRow[i].split(";")
                j = 0
                while(j < linha.count() - 1){
                    dataset.add(Caso(linha[j], linha[++j], linha[++j], linha[++j], linha[++j], linha[++j], linha[++j]))
                }
                i++
            }
            return dataset
        }
    }
}

data class Caso(val posicao: String = "", val dataInclusaoNotificacao: String = "", val classificacaoFinal: String = "",
                    val idade: String = "", val sexo: String = "", val evolucao: String = "", val dataObito: String = "")