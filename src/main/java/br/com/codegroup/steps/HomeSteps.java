package br.com.codegroup.steps;

import br.com.codegroup.pages.HomePage;
import br.com.codegroup.utils.Utils;
import io.cucumber.java.pt.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class HomeSteps {
    HomePage homePage;

    @Dado("que estou na página home da amazon")
    public void que_estou_na_pagina_home_da_amazon() throws InterruptedException {
        Hooks.driver.get("https://www.amazon.com.br/");
        Thread.sleep(5000);
        Hooks.driver.navigate().refresh();
        homePage = new HomePage(Hooks.driver);
    }

    @Quando("busco o produto {string} na barra de pesquisa")
    public void buscoOProdutoNaBarraDePesquisa(String palavra) {
        Utils.fillElement(homePage.getSearchBar(), palavra);
    }

    @Então("a barra de sugestoes e exibida com produtos relacionados com {string}")
    public void a_barra_de_sugesoes_e_exibida_com_produtos_relacionados(String termo) {
        Utils.getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(homePage.getSuggestion())));
        List<WebElement> suggestions = Hooks.driver.findElements(homePage.getSuggestion());
        assertFalse("Nenhuma sugestão foi carregada", suggestions.isEmpty());
        for (WebElement suggestion : suggestions) {
            String texto = suggestion.getText().toLowerCase();
            assertTrue("Sugestão inválida: '" + texto + "' não contém '"+ termo +"'",
                    Arrays.stream(termo.toLowerCase().split("\\s+"))
                            .allMatch(palavra -> texto.toLowerCase().contains(palavra)));
        }
    }

    @Quando("altero as dimensoes da tela para ser equivalente ao dispositivo {string}")
    public void alteroAsDimensoesDaTelaParaSerEquivalenteAoDispositivo(String dispositivo) {
        switch(dispositivo) {
            case "desktop":
                break;
            case "mobile":
                Hooks.driver.manage().window().setSize(new Dimension(375, 812));
                break;
            case "tablet":
                Hooks.driver.manage().window().setSize(new Dimension(1024, 768));
                break;
            default:
                throw new RuntimeException("Nenhum dispositivo valido foi informado para o teste: " + dispositivo);
        }
    }

    @Entao("a pagina é alterada para os padroes do dipositivo {string}")
    public void aPaginaEAlteradaParaOsPadroesDoDipositivo(String dispositivo) {
        switch(dispositivo) {
            case "mobile":
                assertTrue("Elemento deve estar visivel na tela ",viewportValidation(homePage.getLogo()));
                assertTrue("Elemento deve estar visivel na tela ",viewportValidation(homePage.getSearchBarForm()));
                assertTrue("Elemento deve estar visivel na tela ",viewportValidation(homePage.getCartBox()));
                assertTrue("Elemento deve estar visivel na tela ",viewportValidation(homePage.getMenuNavItens()));
                assertFalse("Elemento não deve estar visivel na tela ",viewportValidation(homePage.getCepBox()));
                assertFalse("Elemento não deve estar visivel na tela ",viewportValidation(homePage.getAccountLinksBox()));
                assertFalse("Elemento não deve estar visivel na tela ",viewportValidation(homePage.getOrdersBox()));
                break;
            case "desktop":
            case "tablet":
                assertTrue("Elemento deve estar visivel na tela ",viewportValidation(homePage.getLogo()));
                assertTrue("Elemento deve estar visivel na tela ",viewportValidation(homePage.getSearchBarForm()));
                assertTrue("Elemento deve estar visivel na tela ",viewportValidation(homePage.getCartBox()));
                assertTrue("Elemento deve estar visivel na tela ",viewportValidation(homePage.getMenuNavItens()));
                assertTrue("Elemento deve estar visivel na tela ",viewportValidation(homePage.getCepBox()));
                assertTrue("Elemento deve estar visivel na tela ",viewportValidation(homePage.getAccountLinksBox()));
                assertTrue("Elemento deve estar visivel na tela ",viewportValidation(homePage.getOrdersBox()));
                break;
            default:
                throw new RuntimeException("Nenhum dispositivo valido foi informado para o teste: " + dispositivo);
        }
    }

    @Entao("o tempo de carregamento da pagina deve ser menor que {int} ms")
    public void oTempoDeCarregamentoDaPaginaDeveSerMenorQueSegundos(int sec) {

        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;

        long loadTime = (Long) js.executeScript(
                "return window.performance.timing.loadEventEnd - window.performance.timing.navigationStart;"
        );

        System.out.println("Tempo real de carregamento: " + loadTime + " ms");

        assertTrue("A página demorou mais de " + sec + " ms para carregar.", loadTime < sec);
    }

    public static boolean viewportValidation(By element) {
        Utils.getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;

        String script =
                "const rect = arguments[0].getBoundingClientRect();" +
                        "return (" +
                        "  rect.top >= 0 &&" +
                        "  rect.left >= 0 &&" +
                        "  rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&" +
                        "  rect.right <= (window.innerWidth || document.documentElement.clientWidth)" +
                        ");";

        return (Boolean) js.executeScript(script, Hooks.driver.findElement(element));
    }

}